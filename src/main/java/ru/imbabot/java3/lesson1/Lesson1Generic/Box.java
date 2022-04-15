package ru.imbabot.java3.lesson1.Lesson1Generic;

import java.util.ArrayList;
import java.util.List;

public class Box<T>  {

    private List<Fruit> list;

    public Box(){
        list = new ArrayList<>();
    }

    public double getWeight(){
        double weight = 0;
        for (Fruit f : list){
            weight += f.getWeight();
        }
        return weight;
    }

    public boolean compare(Box box){
       return Math.abs(this.getWeight() - box.getWeight()) < 0000000.1f;
    }

    public void addFruit(Fruit fruit){
        list.add(fruit);
    }


    public Box<T> pour(Box<?> box){
        this.list.clear();
        for (Fruit f: box.list){
            list.add(f);
        }
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(list.get(0));

        return sb.toString();
    }
}
