package ru.jevo.potoks.make;

import lombok.Data;
import lombok.SneakyThrows;
import ru.jevo.potoks.Working;

import static java.lang.Thread.sleep;

@Data
public class MakeIron implements Runnable {

    public static int iron = 0;
    private int forDay = 3000; // затрачиваемое время на производство одной единицы товара
    private Working working;

    @Override
    @SneakyThrows
    public void run() {
        sleep(forDay);
        iron++;
        System.out.println("На рудниках добыто и складировано " + iron + " железа ");
    }

}
