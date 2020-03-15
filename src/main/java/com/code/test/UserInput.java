package com.code.test;


import lombok.Getter;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class UserInput {

    private DigitPanel digitPanel = new DigitPanel();

    private Integer[] data;


    static String pattern="[\\d+ ]+";


    public UserInput(String input) {
        data = transform(input);
    }

    public static void main(String[] args) {
        System.out.println( Pattern.matches(pattern,"12,33")); ;
        System.out.println( Pattern.matches(pattern,"12 33")); ;

        System.out.println( Pattern.matches(pattern,"")); ;
    }


    public String getResult() {
        return digitPanel.digitMatrix99(data);
    }

    private Integer[] transform(String input) {
        if (input == null) {
            throw new IllegalArgumentException("输入不能为空");
        }
        input=input.trim();
        if (!Pattern.matches(pattern,input)) {
            throw new InputMismatchException("输入格式不正确,请按照‘{数字} {数字} {数字}’的方式输入");
        }
        String[] strArray = input.split(" ");
        Integer[] result = new Integer[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            result[i] = Integer.parseInt(strArray[i]);
        }
        return result;
    }
}
