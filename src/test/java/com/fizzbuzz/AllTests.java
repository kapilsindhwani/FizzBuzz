package com.fizzbuzz;

import com.fizzbuzz.main.ApplicationTests;
import com.fizzbuzz.service.FizzBuzzServiceTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        FizzBuzzServiceTests.class, ApplicationTests.class
})
public class AllTests {
}
