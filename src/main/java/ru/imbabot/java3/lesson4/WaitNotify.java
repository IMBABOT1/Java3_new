package ru.imbabot.java3.lesson4;

public class WaitNotify {

    private Object object = new Object();
    private char current = 'a';


    private void methodA()  {
        synchronized (object) {
            for (int i = 0; i < 5; i++) {
                while (current != 'a') {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(current);
                current = 'b';
                object.notifyAll();
            }
        }
    }

    private void methodB() {
        synchronized (object) {
            for (int i = 0; i < 5; i++) {
                while (current != 'b') {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(current);
                current = 'c';
                object.notifyAll();
            }
        }
    }

    private void methodC() {
        synchronized (object) {
            for (int i = 0; i < 5; i++) {
                while (current != 'c') {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(current);
                current = 'a';
                object.notifyAll();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        WaitNotify waitNotify = new WaitNotify();
        new Thread(()-> {
            waitNotify.methodA();
        }).start();
        new Thread(()-> {
            waitNotify.methodB();
        }).start();
        new Thread(()-> {
            waitNotify.methodC();
        }).start();
    }

}
