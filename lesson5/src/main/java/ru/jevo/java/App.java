package ru.jevo.java;

import lombok.SneakyThrows;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class App {

    public static AtomicBoolean win = new AtomicBoolean(true);
    public static final int CARS_COUNT = 4;

    @SneakyThrows
    public static void main(String[] args) throws InterruptedException {

        final int count = 3;
        final ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(count);
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT + 1);
        final Semaphore semaphore = new Semaphore(2);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка к гонке!");
        Race race = new Race(new Road(60), new Tunnel(semaphore), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), countDownLatch, cyclicBarrier);
        }

        for (int i = 0; i < cars.length; i++) {
            executorService.submit(cars[i]);
        }

        for (int i = count; i > 0 ; i--) {
            Thread.sleep(1000);
            System.out.println("Отсчет: " + i);
            countDownLatch.countDown();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        cyclicBarrier.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

}

