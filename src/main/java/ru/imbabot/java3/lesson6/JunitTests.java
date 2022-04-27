package ru.imbabot.java3.lesson6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JunitTests {

    public void method(int[]arr){
        List<Integer> elements = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <arr.length ; i++) {
            elements.add(arr[i]);
        }

        for (int i = 0; i < elements.size(); i++) {
            if (!elements.contains(4)){
                throw new RuntimeException("Must contain at least one 4");
            }
        }

        int index = elements.size() - 1;

        while (elements.get(index) != 4){
            result.add(elements.get(index));
            index--;
        }

        int[]temp = new int[result.size()];
        int[]tests = new int[result.size()];

        for (int i = 0; i <temp.length ; i++) {
            temp[i] = result.get(i);
        }

        for(int i = 0; i < temp.length / 2; i++) {
            int t = temp[i];
            temp[i] = temp[temp.length - i - 1];
            temp[temp.length - i - 1] = t;
        }

    }
}
