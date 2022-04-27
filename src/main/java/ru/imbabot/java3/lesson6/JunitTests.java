package ru.imbabot.java3.lesson6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JunitTests {

    public void method(int[]arr){
        List<Integer> elements = new ArrayList<>();
        for (int i = 0; i <arr.length ; i++) {
            elements.add(arr[i]);
        }

        for (int i = 0; i < elements.size(); i++) {
            if (!elements.contains(4)){
                throw new RuntimeException("Must contain at least one 4");
            }
        }
    }
}
