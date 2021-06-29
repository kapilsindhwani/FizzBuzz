package com.fizzbuzz.service;

import com.fizzbuzz.domain.FizzBuzzType;
import com.fizzbuzz.processor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {

    private Processor processor;

    @Autowired
    public FizzBuzzService(
            NumberProcessor numberProcessor,
            FizzProcessor fizzProcessor,
            FizzBuzzProcessor fizzBuzzProcessor,
            BuzzProcessor buzzProcessor
    ) {
        fizzProcessor.setNextProcessor(buzzProcessor);
        buzzProcessor.setNextProcessor(fizzBuzzProcessor);
        fizzBuzzProcessor.setNextProcessor(numberProcessor);
        this.processor = fizzProcessor;
    }

    public FizzBuzzType evalNumber(int number) {
        return processor.receiveRequest(number);
    }
}
