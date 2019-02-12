package com.andrei.microservices.currencyexchangeservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap implements CommandLineRunner {


    private final ExchangeRepository exchangeRepository;

    public Bootstrap(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    @Override
    public void run(String... args){

        exchangeRepository.deleteAll();

        List<Exchange> exchanges = new ArrayList<>();
        exchanges.add(new Exchange(1L, "USD", "BLR", BigDecimal.valueOf(3)));
        exchanges.add(new Exchange(2L, "USD", "INR", BigDecimal.valueOf(65)));
        exchanges.add(new Exchange(3L, "EUR", "BLR", BigDecimal.valueOf(4)));
        exchanges.add(new Exchange(4L, "AUD", "BLR", BigDecimal.valueOf(1)));

        exchangeRepository.saveAll(exchanges);

    }

}