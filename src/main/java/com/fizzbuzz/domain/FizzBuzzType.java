package com.fizzbuzz.domain;

public enum FizzBuzzType {

    NUMBER,
    FIZZ,
    BUZZ,
    FIZZBUZZ;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
