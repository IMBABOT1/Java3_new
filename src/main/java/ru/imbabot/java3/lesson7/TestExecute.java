package ru.imbabot.java3.lesson7;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestExecute {

    public static void start(Class c){
        Method[] methods = c.getDeclaredMethods();
        for (Method m: methods){
            System.out.println(m.getName());
        }

    }

    public static void main(String[] args) {
            start(Tests.class);
    }
}
