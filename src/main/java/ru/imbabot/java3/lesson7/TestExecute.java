package ru.imbabot.java3.lesson7;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Stream;

public class TestExecute {

    public static void start(Class c) {
        Method[] methods = c.getDeclaredMethods();
        int[]arr = new int[methods.length];
        for (int i = 0; i < methods.length ; i++) {
            for (int j = 0; j < methods.length ; j++) {
                if (methods[i].isAnnotationPresent(Test.class)){
                    arr[i] = methods[i].getAnnotation(Test.class).priority();
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
            start(Tests.class);
    }
}
