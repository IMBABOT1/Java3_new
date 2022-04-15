package ru.imbabot.java3.lesson1;

import java.util.Arrays;
import java.util.List;

public class ArrayToList<T> {

    public <T> List<T> arrayToList(T[]arr){
        List<T> list = Arrays.asList(arr);
        return list;
    }
}