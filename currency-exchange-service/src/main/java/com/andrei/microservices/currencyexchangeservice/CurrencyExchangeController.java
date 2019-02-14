package com.andrei.microservices.currencyexchangeservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CurrencyExchangeController {

    private final ExchangeRepository exchangeRepository;

    public CurrencyExchangeController(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public Exchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to){

        Exchange exchangeValue = exchangeRepository.findByFromAndTo(from, to);
        log.info("Exchange Value {}", exchangeValue);

        return exchangeValue;
    }
}
