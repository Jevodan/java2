package ru.jevo.potoks.structures;

import lombok.Data;

@Data
public class Temple extends AbstractStructure {

    private int wood = 10;
    private int iron = 5;
    private String name = "Храм предков";

}
