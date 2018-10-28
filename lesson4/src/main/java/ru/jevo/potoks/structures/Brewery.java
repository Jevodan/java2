package ru.jevo.potoks.structures;

import lombok.Data;

@Data
public class Brewery extends AbstractStructure {

    public int wood = 2;
    public int iron = 1;
    public String name = "Пивоварня";

}
