package ru.imbabot.java3.lesson7;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Stream;

public class TestExecute {

    public static void start(Class c) {
        Method[] methods = c.getDeclaredMethods();
        int before = 0;
        int after = 0;

        for (int i = 0; i <methods.length ; i++) {
            if (methods[i].isAnnotationPresent(BeforeSuite.class)){
                before++;
            }
            if (methods[i].isAnnotationPresent(AfterSuite.class)){
                after++;
            }
        }

       if (before > 1 || after > 1){
           throw new RuntimeException("Must be only one Before and only one after");
       }


        int temp = 1;
        while (temp <= 10){
            for (int i = 0; i <methods.length ; i++) {
                if (methods[i].isAnnotationPresent(Test.class) && methods[i].getAnnotation(Test.class).priority() == temp){
                    System.out.println(methods[i].getName());
                    temp++;
                }
                if (methods[i].isAnnotationPresent(BeforeSuite.class) && methods[i].getAnnotation(BeforeSuite.class).priority() == temp){
                    System.out.println(methods[i].getName());
                    temp++;
                }
                if (methods[i].isAnnotationPresent(AfterSuite.class) && methods[i].getAnnotation(AfterSuite.class).priority() == temp){
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