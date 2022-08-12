package discovery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discovery")
public class DiscoveryController {
    @GetMapping(value = "/get")
    public String fromDiscovery () {
        return "Hello from discovery";
    }
}
