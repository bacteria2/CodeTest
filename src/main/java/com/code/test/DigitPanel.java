package com.code.test;

import lombok.extern.slf4j.Slf4j;

import java.util.*;


@Slf4j
public class DigitPanel {
    private Map<String, DigitNumber> digitMap = new HashMap<>();

    public DigitPanel() {
        basicPanel();
    }

    public void basicPanel() {
        digitMap.put("1", new DigitNumber("1", new String[]{}));
        digitMap.put("2", new DigitNumber("2", new String[]{"a", "b", "c"}));
        digitMap.put("3", new DigitNumber("3", new String[]{"d", "e", "f"}));
        digitMap.put("4", new DigitNumber("4", new String[]{"g", "h", "i"}));
        digitMap.put("5", new DigitNumber("5", new String[]{"j", "k", "l"}));
        digitMap.put("6", new DigitNumber("6", new String[]{"m", "n", "o"}));
        digitMap.put("7", new DigitNumber("7", new String[]{"p", "q", "r", "s"}));
        digitMap.put("8", new DigitNumber("8", new String[]{"t", "u", "v"}));
        digitMap.put("9", new DigitNumber("9", new String[]{"w", "x", "y", "z"}));
        digitMap.put("0", new DigitNumber("0", new String[]{}));
        digitMap.put("*", new DigitNumber("*", new String[]{}));
        digitMap.put("#", new DigitNumber("#", new String[]{}));
    }

    public String digitMatrix99(Integer[] ditArray) {

        List<Integer> list = new ArrayList<>();
        // 把数字拆分为个位数
        for (Integer i : ditArray) {
            String result = String.valueOf(i);
            for (char c : result.toCharArray()) {
                list.add(Integer.valueOf(String.valueOf(c)));
            }
        }
        return matrix(list.toArray(new Integer[0]));
    }


    /**
     *  计算拆分后的数组相乘结果，已字符串返回
     *
     * */
    private String matrix(Integer[] digitArray) {
        String resultStr = "";
        List<String[]> validList = new ArrayList<>();
        for (int i : digitArray) {
            DigitNumber number = digitMap.get(String.valueOf(i));
            log.info(Arrays.toString(number.getCharArray()));
            if (number.getCharArray().length > 0) {
                validList.add(number.getCharArray());
            }
        }
        int size = validList.size();
        if (size >= 1) {
            String[] resultArray = validList.get(0);
            for (String[] elementArray : validList.subList(1, size)) {
                resultArray = multi(resultArray, elementArray);
            }
            resultStr = String.join(" ", resultArray);
        }
        return resultStr;
    }

    /**
     * 递归计算数组a 乘以 数组b的结果
     * */
    private String[] multi(String[] a, String[] b) {
        if (a.length == 0) {
            return b;
        }
        if (b.length == 0) {
            return a;
        }
        int size = a.length * b.length;
        String[] result = new String[size];
        // 以a数组为基底，循环完成a[i]+b[j]的计算
        // 将结果放入result,索引为 i * b.length + j
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int index = i * b.length + j;
                result[index] = a[i] + b[j];
            }
        }
        return result;
    }
}
