package ru.jevo.threads;

import lombok.SneakyThrows;

import static java.lang.Thread.sleep;

public class App {

    public static int COUNT = 0;
    public static String marker = "A";
    private Object lock1 = new Object();

    @SneakyThrows
    public static void main(String[] args) {
        App e1 = new App();
        System.out.println("Start");
        while (COUNT < 15) {
            new Thread(() -> e1.first()).start();
            new Thread(() -> e1.second()).start();
            new Thread(() -> e1.third()).start();
            sleep(500);
        }
    }

    @SneakyThrows
    public synchronized void first() {
        if (marker.equals("A")) {
            COUNT++;
            System.out.print("A");
            marker = "B";
            notifyAll();
        } else {
            wait();
        }
    }

    @SneakyThrows
    public synchronized void second() {
        if (marker.equals("B")) {
            COUNT++;
            System.out.print("B");
            marker = "C";
            notifyAll();
        } else {
            wait();
        }
    }

    @SneakyThrows
    public synchronized void third() {
        if (marker.equals("C")) {
            COUNT++;
            System.out.print("C");
            marker = "A";
            notifyAll();
        } else {
            wait();
        }
    }

}

