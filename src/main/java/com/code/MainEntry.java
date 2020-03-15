package com.code;

import com.code.test.UserInput;

import java.util.Scanner;

public class MainEntry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.nextLine();

            try {
                UserInput userInput = new UserInput(input);
                System.out.println(userInput.getResult());
            } catch (Exception e) {
                System.out.println("error:" + e.getMessage());
            }
        }
    }
}
