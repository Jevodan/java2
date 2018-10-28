package ru.jevo.potoks.make;

import lombok.Data;
import lombok.SneakyThrows;
import ru.jevo.potoks.Working;

import static java.lang.Thread.sleep;

@Data
public class MakeWood implements Runnable {

    public static float wood = 0;
    private int forDay = 2000; // затрачиваемое время на производство 1.5 единицы товара

    @Override
    @SneakyThrows
    public void run() {
        sleep(forDay);
        wood = wood  + 1.5f;
        System.out.println("Лесорубы добыли и складировали " + wood + " дерева ");
    }

}
