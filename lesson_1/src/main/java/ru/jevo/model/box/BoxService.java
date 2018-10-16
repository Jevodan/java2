package ru.jevo.model.box;

import ru.jevo.model.fruits.Fruit;

public interface BoxService<T extends Fruit> {

    public void charge(Box box);

    public boolean isCompare(Box box);

    public float getWeight();
}
