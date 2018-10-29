package ru.jevo.java;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {

    final CountDownLatch countDownLatch;
    final CyclicBarrier cyclicBarrier;
    private static int CARS_COUNT;

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

    public Car(Race race, int speed, CountDownLatch countDownLatch, CyclicBarrier cyclicBarrier) {

        this.cyclicBarrier = cyclicBarrier;
        this.countDownLatch = countDownLatch;
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    @SneakyThrows
    public void run() {
        System.out.println(this.name + " готовится");
        Thread.sleep(500 + (int) (Math.random() * 100));
        System.out.println(this.name + " готов");
        countDownLatch.await();
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        if (App.win.get() == true) {
            System.out.println(this.name + " WIN");
            App.win.set(false);
        }
        cyclicBarrier.await();
    }

}