package ru.jevo.potoks;

import ru.jevo.potoks.make.Make;

public class App {

    public static void main(String[] args) {
        Working working = new Working();
        Make make = new Make(working);
        Build build = new Build(working);
        new Thread(build).start();
        new Thread(make).start();
    }

}
