package ru.imbabot.java3.lesson7;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Stream;

public class TestExecute {

    public static void start(Class c) {
        Method[] methods = c.getDeclaredMethods();
        Map<Method, Integer> map = new HashMap<>();
        for (Method m : methods){
            if (m.isAnnotationPresent(Test.class)) {
                map.put(m, m.getAnnotation(Test.class).priority());
            }
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                map.put(m, m.getAnnotation(BeforeSuite.class).priority());
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                map.put(m, m.getAnnotation(AfterSuite.class).priority());
            }
        }
    }




    public static void main(String[] args) {
            start(Tests.class);
    }
}
