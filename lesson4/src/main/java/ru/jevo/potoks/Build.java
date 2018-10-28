package ru.jevo.potoks;

import lombok.SneakyThrows;
import ru.jevo.potoks.make.MakeIron;
import ru.jevo.potoks.make.MakeWood;

public class Build implements Runnable {

    Working working;

    public Build(Working working) {
        this.working = working;
    }

    @Override
    @SneakyThrows
    public void run() {
        working.build();
    }

}
