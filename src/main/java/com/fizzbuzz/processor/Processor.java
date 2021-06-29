package com.fizzbuzz.processor;

import com.fizzbuzz.domain.FizzBuzzType;

public abstract class Processor {

    public Processor nextProcessor;

    protected abstract FizzBuzzType processRequest(int number);

    public FizzBuzzType receiveRequest(int number) {
        FizzBuzzType fizzBuzzType = processRequest(number);
        return (fizzBuzzType != null) ? fizzBuzzType : nextProcessor.receiveRequest(number);
    }

    public abstract FizzBuzzType evaluate(int number);

    public void setNextProcessor(Processor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

}
