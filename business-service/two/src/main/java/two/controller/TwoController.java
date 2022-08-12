package two.controller;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.servo.Metric;
import com.netflix.servo.monitor.BasicGauge;
import com.netflix.servo.monitor.Counter;
import com.netflix.servo.monitor.Gauge;
import com.netflix.servo.monitor.MonitorConfig;
import com.netflix.servo.monitor.PeakRateCounter;
import com.netflix.servo.publish.BasicMetricFilter;
import com.netflix.servo.publish.JvmMetricPoller;
import com.netflix.servo.publish.MemoryMetricObserver;
import com.netflix.servo.publish.PollRunnable;
import com.netflix.servo.publish.PollScheduler;

@RestController
@RequestMapping("/two")
public class TwoController {
    Counter counter = new PeakRateCounter(MonitorConfig.builder("test").build());
    Gauge<Double> gauge = new BasicGauge<>(MonitorConfig.builder("test")
            .build(), () -> 2.32);

    MemoryMetricObserver observer = new MemoryMetricObserver();
    PollRunnable pollRunnable = new PollRunnable(new JvmMetricPoller(),
            new BasicMetricFilter(true), observer);

    @GetMapping(value = "/get")
    public String fromOne () {
        return observer.toString();
    }

    @GetMapping(value = "/getGauge")
    public String fromOneGauge () {
        return gauge.getValue().toString();
    }
}
