package com.codecool.petridish.LifeForms;

import com.codecool.petridish.Utilities.BacteriaType;
import com.codecool.petridish.Utilities.Position;

public class Bacillus extends Bacteria {
    public Bacillus(int id, Position position) {
        super(id, position);
        setType(BacteriaType.BACILLUS);
        setLifeSpan(10);
        setNearbyRadius(3);
    }
}
