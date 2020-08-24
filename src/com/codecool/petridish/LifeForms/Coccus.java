package com.codecool.petridish.LifeForms;

import com.codecool.petridish.Utilities.BacteriaType;
import com.codecool.petridish.Utilities.Position;

public class Coccus extends Bacteria {
    public Coccus(int id, Position position) {
        super(id, position);
        setType(BacteriaType.COCCUS);
        setLifeSpan(100);
        setNearbyRadius(1);
    }
}
