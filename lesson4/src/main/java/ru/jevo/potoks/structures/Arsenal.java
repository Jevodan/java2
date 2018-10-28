package ru.jevo.potoks.structures;

import lombok.Data;

@Data
public class Arsenal extends AbstractStructure {

    private int wood = 4;
    private int iron = 1;
    private String name = "Арсенал";

}
