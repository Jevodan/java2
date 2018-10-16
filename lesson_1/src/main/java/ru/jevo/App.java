package ru.jevo;

import ru.jevo.model.box.Box;
import ru.jevo.model.constants.Constant;
import ru.jevo.model.fruits.Apple;
import ru.jevo.model.fruits.Garnet;
import ru.jevo.service.ArrayServiceImpl;
import java.util.List;
import java.util.Random;

public class App {

    public static final int SIZE_ARRAY = 50;

    public static void main(String[] args) {
        App.partFirstSecond();
        App.partThird();
    }

    /**
     * Первый и второй пункт ДЗ( Обобщения) - Преобразуем массив в список, затем меняем в нем произвольные элементы
     */
    public static void partFirstSecond() {
        final Random rand = new Random();
        final ArrayServiceImpl impl = new ArrayServiceImpl(new String[SIZE_ARRAY]);

        impl.capacity();
        List list = impl.arrayToList(impl.getArray());
        impl.changeElements(list, rand.nextInt(SIZE_ARRAY), rand.nextInt(SIZE_ARRAY));
        System.out.println(list);
    }

    /**
     * Часть 3 ДЗ(обобщения)
     * Есть классы Fruit -> Apple, Orange (больше фруктов не надо);
     * Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
     * Для хранения фруктов внутри коробки можно использовать ArrayList;
     * Сделать метод getWeight(), который высчитывает вес коробки, зная количество фруктов и вес одного фрукта (вес яблока – 1.0f, апельсина – 1.5f. Не важно, в каких это единицах);
     * Внутри класса Коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true – если она равны по весу, false – в противном случае (коробки с яблоками мы можем сравнивать с коробками с апельсинами);
     * Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую (помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами). Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
     * Не забываем про метод добавления фрукта в коробку.
     */
    public static void partThird() {
        final Box appleFirstBox = new Box(new Apple(), 50);
        final Box garnetFirstBox = new Box(new Garnet(), 60);
        final Box appleSecondBox = new Box(new Apple(), 90);
        final Box garnetSecondBox = new Box(new Garnet(), 80);
        final Box appleThirdBox = new Box(new Apple(), 50);

        printCompare(appleSecondBox, garnetFirstBox);
        printCompare(appleSecondBox, appleFirstBox);

        printCharge(appleFirstBox, garnetFirstBox);
        printCharge(appleFirstBox, appleThirdBox);
        printCharge(garnetFirstBox, garnetSecondBox);

    }

    public static void printCompare(Box box1, Box box2) {
        pre();
        System.out.println("Сравнимаем две коробки (" + box1.getFruitType().getName()
                + "[" + box1.getFruitType().getWeight() + " * " + box1.getBox().size() + " ] и "
                + box2.getFruitType().getName() + "[" + box2.getFruitType().getWeight() + " * " + box2.getBox().size() + " ]");
        System.out.println((box1.isCompare(box2)) ? Constant.BOX_EQUALS : Constant.BOX_NOT_EQUALS);
        pre();
    }

    public static void printCharge(Box box1, Box box2) {
        pre();
        System.out.println("Перекидываем " + box1.getFruitType().getName() + " в коробку с " + box2.getFruitType().getName());
        box1.charge(box2);
        System.out.println("Итог:");
        System.out.println(" Коробка 1: " + box1.getFruitType().getName() + " Вес: " + box1.getWeight());
        System.out.println(" Коробка 2: " + box2.getFruitType().getName() + " Вес: " + box2.getWeight());
        pre();
    }

    public static void pre() {
        System.out.println("_______________________________________________________________________________________");
    }
}
