package com.fizzbuzz.main;

import com.fizzbuzz.Application;
import com.fizzbuzz.domain.FizzBuzzType;
import com.fizzbuzz.service.FizzBuzzService;
import com.fizzbuzz.utils.ConsoleOutputUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @Test
    public void runMainProgram_List1To100Given_ShouldShowFizzBuzzTypePerNumber() {
        // when
        Application.main(new String[]{});
        // then
        checkConsoleOutput();
    }

    private void checkConsoleOutput() {
        outputCapture.expect(containsString("START"));
        outputCapture.expect(containsString("END"));
        // then
        String standardOutput = outputCapture.toString();
        List<String> neededLines = Arrays.asList(standardOutput.split(System.lineSeparator()));
        neededLines.stream().filter(StringUtils::isNotBlank).filter(ConsoleOutputUtils::isLineNeeded).forEach(this::assertLine);
    }

    private void assertLine(String line) {
        String[] split = line.split(":");
        int number = Integer.parseInt(split[0].trim());
        FizzBuzzType fizzBuzzType = fizzBuzzService.evalNumber(number);
        if (fizzBuzzType.equals(FizzBuzzType.NUMBER))
            Assertions.assertEquals(split[1].trim(), String.valueOf(number));
        else
            Assertions.assertEquals(split[1].trim(), fizzBuzzType.toString());
    }
}