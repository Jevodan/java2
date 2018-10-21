package ru.jevo.model.box;

import lombok.Getter;
import ru.jevo.model.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

import static ru.jevo.model.constants.Constant.CHARGE_1;
import static ru.jevo.model.constants.Constant.CHARGE_2;

@Getter
public class Box<T extends Fruit> implements BoxService<T> {

    private T fruitType;
    private float weight = 0f;
    private List<T> box = new ArrayList<>();
    private int capacity;

    public Box(int capacity) {
        this.capacity = capacity;
    }

    public void add(T fruit) {
        this.fruitType = fruit;
        System.out.println(fruit.getClass().getSimpleName());
        for (int i = 0; i < capacity; i++)
            this.box.add(fruit);
    }

    private void clear() {
        List<T> sublist = this.getBox().subList(0, this.getBox().size());
        this.getBox().removeAll(sublist);
    }

    @Override
    public void charge(Box box) {
        if (this.getFruitType().getName().equals(box.getFruitType().getName())) {
            for (int i = 0; i < this.getBox().size(); i++)
                box.getBox().add(box.getBox().size(), this.getBox().get(i));
            this.clear();
        } else System.out.println(CHARGE_1 + box.fruitType.getName() + CHARGE_2 + this.fruitType.getName());
    }

    @Override
    public boolean isCompare(Box box) {
        return (this.getWeight() == box.getWeight()) ? true : false;
    }


    @Override
    public float getWeight() {
        return this.getBox().size() * fruitType.getWeight();
    }
}
