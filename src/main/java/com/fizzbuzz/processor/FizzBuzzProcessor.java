package com.fizzbuzz.processor;

import com.fizzbuzz.domain.FizzBuzzType;
import com.fizzbuzz.predicates.FizzBuzzPredicates;
import org.springframework.stereotype.Component;

@Component
public class FizzBuzzProcessor extends Processor {

    @Override
    protected FizzBuzzType processRequest(int number) {
        return evaluate(number);
    }

    @Override
    public FizzBuzzType evaluate(int number) {
        return FizzBuzzPredicates.isFizzBuzz.test(number) ? FizzBuzzType.FIZZBUZZ : null;
    }
}
