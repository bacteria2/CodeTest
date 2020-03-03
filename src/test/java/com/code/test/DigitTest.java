package com.code.test;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@Slf4j
public class DigitTest {

    DigitPanel digitPanel=new DigitPanel();

    @Test
    public void stage1() {
        log.info("stage1 start");
        Integer[] input = {0,4, 1, 2, 3};
        String result= digitPanel.digitMatrix9(input);
        log.info("result is {}",result);
    }

    @Test
    public void stage2() {
        log.info("stage2 start");
        Integer[] input = {5, 0, 93};
        String result=digitPanel.digitMatrix99(input);
        log.info("result is {}",result);

    }
}
