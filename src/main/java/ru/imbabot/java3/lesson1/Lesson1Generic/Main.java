package ru.imbabot.java3.lesson1.Lesson1Generic;

public class Main {

    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());


        System.out.println(orangeBox.getWeight());
        System.out.println(appleBox.getWeight());

        System.out.println(orangeBox);
        System.out.println(appleBox);

        System.out.println(appleBox.compare(orangeBox));

    }
}
