package ru.imbabot.java3.lesson5;

public class WaitNotify {

    private Object object = new Object();
    private char current_letter = 'a';


    private void printA() {
        try {
            synchronized (object) {
                for (int i = 0; i < 5; i++) {
                    while (current_letter != 'a') {
                        object.wait();
                    }
                    System.out.print(current_letter);
                    current_letter = 'b';
                    object.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


       private void printB(){
            try {
                synchronized (object) {
                    for (int i = 0; i < 5; i++) {
                        while (current_letter != 'b') {
                            object.wait();
                        }
                        System.out.print(current_letter);
                        current_letter = 'c';
                        object.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void printC () {
            try {
                synchronized (object) {
                    for (int i = 0; i < 5; i++) {
                        while (current_letter != 'c') {
                            object.wait();
                        }
                        System.out.print(current_letter);
                        current_letter = 'a';
                        object.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    public static void main(String[] args) {
        WaitNotify waitNotify = new WaitNotify();
        new Thread(()->{
            waitNotify.printA();
        }).start();
        new Thread(()->{
            waitNotify.printB();
        }).start();
        new Thread(()->{
            waitNotify.printC();
        }).start();
    }
}
