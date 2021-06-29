package com.fizzbuzz;

import com.fizzbuzz.service.FizzBuzzService;
import com.fizzbuzz.utils.ConsoleOutputUtils;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.IntStream;

@SpringBootApplication
public class Application implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    FizzBuzzService fizzBuzzService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {

        logger.info("START");
        IntStream.rangeClosed(1, 100).forEach(ConsoleOutputUtils.printLine(fizzBuzzService::evalNumber));
        logger.info("END");

    }
}
