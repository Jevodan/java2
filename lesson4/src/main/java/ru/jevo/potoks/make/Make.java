package ru.jevo.potoks.make;

import ru.jevo.potoks.Working;

public class Make implements Runnable {

    Working working;

    public Make(Working working) {
        this.working = working;
    }

    @Override
    public void run() {
        working.make();
    }

}
