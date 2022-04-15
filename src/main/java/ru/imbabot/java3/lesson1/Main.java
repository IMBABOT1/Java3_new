package ru.imbabot.java3.lesson1;

import java.util.Arrays;

public class Main {

    private static void swap(Object[] arr, int first, int second){
        Object temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }


    public static void main(String[] args) {
        Integer[]  ints = new Integer[]{1,2,3,4,5};
        swap(ints, 0, 1);
        System.out.println(Arrays.toString(ints));
    }
}
