package com.andrei.microservices.limitsservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    private final LimitConfiguration limitConfiguration;

    public LimitsConfigurationController(LimitConfiguration limitConfiguration) {
        this.limitConfiguration = limitConfiguration;
    }

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfiguration(){
        return new LimitConfiguration(limitConfiguration.getMinimum(), limitConfiguration.getMaximum());
    }
}
