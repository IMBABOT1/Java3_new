package ru.imbabot.java3.lesson7;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Stream;

public class TestExecute {

    public static void start(Class c) {
        Method[] methods = c.getDeclaredMethods();
        int temp = 2;
        while (temp <= 9){
            for (int i = 0; i <methods.length ; i++) {
              if (methods[i].isAnnotationPresent(Test.class) && methods[i].getAnnotation(Test.class).priority() == temp){
                  System.out.println(methods[i].getName());
                  temp++;
              }
            }
        }

    }







    public static void main(String[] args) {
            start(Tests.class);
    }
}
