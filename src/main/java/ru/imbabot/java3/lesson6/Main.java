package ru.imbabot.java3.lesson6;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        JunitTests tests = new JunitTests();


        System.out.println(tests.oneOrFour(new int[]{1,1,1,1,1,4,3}));
    }
}
