package com.codecool.petridish.LifeForms;

import com.codecool.petridish.Utilities.BacteriaType;
import com.codecool.petridish.Utilities.Position;

public class Coccus extends Bacteria {
    public Coccus(int id, BacteriaType type, Position position) {
        super(id);
        setType(type);
        setCoordinates(position);
        setLifeSpan(100);
        setNearbyRadius(1);
    }
}
