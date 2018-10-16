package ru.jevo.service;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class ArrayServiceImpl<T> implements ArrayService<T> {

    private T[] array = null;
    private List<T> list = null;

    /**
     * @param array - Создание обычного массива произвольного ссылочного типа
     */
    public ArrayServiceImpl(T[] array) {
        this.array = array;
    }

    public void capacity(){
        for (int i = 0; i < array.length; i++)
            array[i] = (T) ("яблоко" + i);
    }


    /**
     * Метод  переставляет два элемента местами
     *
     * @param arrayList - исходный список
     * @param el1       - позиция элемента, который переставляем на позицию el2
     * @param el2       - позиция элемента, который переставляем на позицию el1
     */
    @Override
    public void changeElements(List<T> arrayList, int el1, int el2) {
        final T elementMemory = arrayList.get(el2);
        arrayList.set(el2, arrayList.get(el1));
        arrayList.set(el1, elementMemory);
    }

    /**
     * Метод конвертирует обычный массив произвольного ссылочного типа в список
     * @param array - Получаем на входе массив, который конвертируем в список
     * @return - список List
     */
    @Override
    public List<T> arrayToList(T[] array) {
        this.list = Arrays.asList(array);
        return list;
    }
}
