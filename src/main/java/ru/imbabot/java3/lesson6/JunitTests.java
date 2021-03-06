package ru.imbabot.java3.lesson6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JunitTests {

    public int[] method(int[]arr){
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

        for (int i = 0; i <temp.length ; i++) {
            temp[i] = result.get(i);
        }

        for(int i = 0; i < temp.length / 2; i++) {
            int t = temp[i];
            temp[i] = temp[temp.length - i - 1];
            temp[temp.length - i - 1] = t;
        }

        return temp;

    }

    public boolean oneOrFour(int[] arr){
        int one = 0;
        int four = 0;
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1){
                one++;
            }else if (arr[i] == 4){
                four++;
            }else {
                temp++;
            }
        }

        if ((one == 0 || four == 0) || temp != 0){
            return false;
        }
        return true;
    }
}
