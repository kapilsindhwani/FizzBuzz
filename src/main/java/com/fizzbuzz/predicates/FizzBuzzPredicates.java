package com.fizzbuzz.predicates;

import java.util.function.IntPredicate;

public class FizzBuzzPredicates {

    public static final IntPredicate isDivisibleBy3 = number -> number % 3 == 0;
    public static final IntPredicate isDivisibleBy5 = number -> number % 5 == 0;
    public static final IntPredicate contains3 = number -> String.valueOf(number).contains("3");
    public static final IntPredicate contains5 = number -> String.valueOf(number).contains("5");

    public static final IntPredicate isFizz = number -> isDivisibleBy5.negate().and(isDivisibleBy3).test(number);
    public static final IntPredicate isBuzz = number -> isDivisibleBy3.negate().and(isDivisibleBy5).test(number);
    public static final IntPredicate isFizzBuzz = number -> isDivisibleBy3.and(isDivisibleBy5).test(number);
    public static final IntPredicate isNotFizzBuzz = number -> isDivisibleBy3.negate().and(isDivisibleBy5.negate()).test(number);

    private FizzBuzzPredicates() {}
}
