package common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;

@RestController
@RequestMapping("/common")
public class CommonController {
    private DynamicStringProperty propertyOneWithDynamic
            = DynamicPropertyFactory.getInstance()
            .getStringProperty("baeldung.archaius.properties.one", "not found!");

    @GetMapping(value = "/get")
    public String fromDiscovery () {
        return propertyOneWithDynamic.getName() + ": " + propertyOneWithDynamic.get();
    }
}
