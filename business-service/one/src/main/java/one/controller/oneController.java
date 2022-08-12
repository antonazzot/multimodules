package one.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.servo.monitor.BasicGauge;
import com.netflix.servo.monitor.Counter;
import com.netflix.servo.monitor.Gauge;
import com.netflix.servo.monitor.MonitorConfig;
import com.netflix.servo.monitor.PeakRateCounter;

@RestController
@RequestMapping("/one")
public class oneController {
    Counter counter = new PeakRateCounter(MonitorConfig.builder("test").build());
    Gauge<Double> gauge = new BasicGauge<>(MonitorConfig.builder("test")
            .build(), () -> 2.32);

    @GetMapping(value = "/get")
    public String fromOne () {
        counter.increment();
        return counter.toString();
    }

    @GetMapping(value = "/getGauge")
    public String fromOneGauge () {
        return gauge.getValue().toString();
    }
}
