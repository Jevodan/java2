package ru.jevo.potoks.structures;

import lombok.Data;

@Data
public class Palace extends AbstractStructure {

    private int wood = 10;
    private int iron = 10;
    private String name = "Дворец";

}
