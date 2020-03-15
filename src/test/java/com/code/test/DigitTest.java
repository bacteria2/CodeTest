package com.code.test;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
public class DigitTest {

    @Test
    public void stage1() {
        log.info("stage1 start");
        String input = "0 4 1 2 3";
        UserInput userInput = new UserInput(input);
        String result = userInput.getResult();
        log.info("result is {}", result);
    }

    @Test
    public void stage2() {
        log.info("stage2 start");
        String input = "0 4 13 22 99";
        UserInput userInput = new UserInput(input);
        String result = userInput.getResult();
        log.info("result is {}", result);

    }

    @Test
    public void nullParam() {
        log.info("nullException start");
        String input = null;
        Exception exception=assertThrows(IllegalArgumentException.class,
                () -> {
                    UserInput userInput = new UserInput(input);
                    userInput.getResult();
                },
                "Expected");

        log.info("exception :"+exception.getMessage());
    }


    @Test
    public void emptyStringInput() {
        log.info("nullException start");
        String input = "  ";
        Exception exception=assertThrows(InputMismatchException.class,
                () -> {
                    UserInput userInput = new UserInput(input);
                    userInput.getResult();
                },
                "Expected");

        log.info("exception :"+exception.getMessage());
    }

    @Test
    public void notNumber() {
        log.info("notNumber start");
        String input = " 11 x3  ";
        Exception exception= assertThrows(InputMismatchException.class,
                () -> {
                    UserInput userInput = new UserInput(input);
                    userInput.getResult();
                },
                "Expected InputMismatchException,but not match");
        log.info("exception :"+exception.getMessage());
    }


    @Test
    public void splitNotBlank() {
        log.info("splitNotBlank start");
        String input = " 11,22,33 ";
        Exception exception= assertThrows(InputMismatchException.class,
                () -> {
                    UserInput userInput = new UserInput(input);
                    userInput.getResult();
                },
                "Expected InputMismatchException,but not match");
        log.info("exception :"+exception.getMessage());
    }

}
