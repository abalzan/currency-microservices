package com.andrei.microservices.currencyexchangeservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    private final ExchangeRepository exchangeRepository;

    public CurrencyExchangeController(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public Exchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to){

        return exchangeRepository.findByFromAndTo(from, to);
    }
}
