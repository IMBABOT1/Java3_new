package ru.imbabot.java3.lesson6;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        JunitTests tests = new JunitTests();

        System.out.println(Arrays.toString(tests.method(new int[]{1,5,4,3,5,4,4,8,9,4,0,3,2})));
    }
}
