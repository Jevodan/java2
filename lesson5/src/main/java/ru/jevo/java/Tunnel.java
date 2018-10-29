package ru.jevo.java;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    final Semaphore semaphore;
    public Tunnel(Semaphore semaphore) {
        this.semaphore =semaphore;
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    @SneakyThrows
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                semaphore.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
