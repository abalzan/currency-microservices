package com.andrei.microservices.limitsservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
    @GetMapping("/fault-tolerance-sample")
    public LimitConfiguration faultTolerace(){
        throw new RuntimeException("EXCEPTION");
    }

    public LimitConfiguration fallbackRetrieveConfiguration(){
        return new LimitConfiguration(9, 9876);
    }
}
