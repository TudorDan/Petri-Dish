package com.codecool.petridish.LifeForms;

import com.codecool.petridish.Utilities.BacteriaType;
import com.codecool.petridish.Utilities.Position;

public class Spirillum extends Bacteria {
    public Spirillum(int id, Position position) {
        super(id, position);
        setType(BacteriaType.SPIRILLUM);
        setLifeSpan(40);
        setNearbyRadius(2);
    }
}
