package com.codecool.petridish.LifeForms;

import com.codecool.petridish.Utilities.BacteriaType;
import com.codecool.petridish.Utilities.Position;

public class Spirillum extends Bacteria {
    public Spirillum(int id, BacteriaType type, Position position) {
        super(id);
        setType(type);
        setCoordinates(position);
        setLifeSpan(40);
        setNearbyRadius(2);
    }
}
