package ru.imbabot.java3.lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    public static final int CARS_COUNT = 4;


    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

    }
}

class Car implements Runnable {
    private static int CARS_COUNT;
    AtomicInteger am = new AtomicInteger();
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    CyclicBarrier cb = new CyclicBarrier(1);
    CountDownLatch cdl = new CountDownLatch(4);

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            cb.await();
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cdl.countDown();
            cdl.await(2, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }



    }
}
abstract class Stage {
    protected int length;
    protected String description;
    public String getDescription() {
        return description;
    }
    public abstract void go(Car c);
}

class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    CountDownLatch cdl = new CountDownLatch(4);
    AtomicInteger am = new AtomicInteger();
    AtomicInteger value = new AtomicInteger();
    AtomicInteger temp = new AtomicInteger();
    @Override
    public void go(Car c) {
        try {
            temp.incrementAndGet();
            if (temp.get() == 1) {
                System.out.println("Гонка началась");
            }
            CyclicBarrier cb = new CyclicBarrier(1);
            System.out.println(c.getName() + " начал этап: " + description);
            try {
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            Thread.sleep(length / c.getSpeed() * 1000);
            cdl.countDown();
            System.out.println(c.getName() + " закончил этап: " + description);
            cdl.await(2, TimeUnit.SECONDS);


            am.incrementAndGet();

            if (am.get() == 1){
                System.out.println("WIN:" + c.getName());
            }

            value.incrementAndGet();
            if (value.get() == 4){
                System.out.println("Гонка закончилась");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Tunnel extends Stage {
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    Semaphore semaphore = new Semaphore(2);
    @Override
    public void go(Car c) {
        try {
            try {
                semaphore.acquire();
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Race {
    private static   ArrayList<Stage> stages;
    public static   ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

}