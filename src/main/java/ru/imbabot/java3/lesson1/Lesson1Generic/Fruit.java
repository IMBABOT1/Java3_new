package ru.imbabot.java3.lesson1.Lesson1Generic;

public class Fruit {

    private float weight;
    private String name;

    public float getWeight() {
        return weight;
    }

    public String getName(){
        return name;
    }

    public Fruit(float weight, String name){
        this.weight = weight;
        this.name = name;
    }


    @Override
    public String toString() {
        return "Name: " + name;
    }
}
