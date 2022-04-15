package ru.imbabot.java3.lesson1;

import java.util.Arrays;
import java.util.List;

public class lesson1 {

    private static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }


    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,4,5};
        swap(ints, 0, 1);
        System.out.println(Arrays.toString(ints));
    }
}
