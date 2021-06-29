package com.fizzbuzz.processor;

import com.fizzbuzz.domain.FizzBuzzType;
import com.fizzbuzz.predicates.FizzBuzzPredicates;
import org.springframework.stereotype.Component;

@Component
public class FizzProcessor extends Processor {

    @Override
    protected FizzBuzzType processRequest(int number) {
        return evaluate(number);
    }

    @Override
    public FizzBuzzType evaluate(int number) {
        return FizzBuzzPredicates.isFizz.test(number) ? FizzBuzzType.FIZZ : null;
    }
}
