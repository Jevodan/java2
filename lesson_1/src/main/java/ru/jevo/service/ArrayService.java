package ru.jevo.service;

import java.util.ArrayList;
import java.util.List;

public interface ArrayService<T> {

    void changeElements(List<T> arrayList, int el1, int el2);

    List<T> arrayToList(T array[]);
}
