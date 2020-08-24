package com.codecool.petridish.LifeForms;

import com.codecool.petridish.Utilities.BacteriaType;
import com.codecool.petridish.Utilities.Position;

public class Bacillus extends Bacteria {
    public Bacillus(int id, BacteriaType type, Position position) {
        super(id);
        setType(type);
        setCoordinates(position);
        setLifeSpan(10);
        setNearbyRadius(3);
    }
}