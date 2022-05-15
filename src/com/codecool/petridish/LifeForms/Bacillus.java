package com.codecool.petridish.LifeForms;

import com.codecool.petridish.PetriDish;
import com.codecool.petridish.Utilities.BacteriaType;
import com.codecool.petridish.Utilities.Position;

import java.util.List;

public class Bacillus extends Bacteria {
    private int counter;

    public Bacillus(Position position) {
        super(position);
        setType(BacteriaType.BACILLUS);
        setLifeSpan(10);
        setNearbyRadius(3);
    }

    @Override
    public boolean isDead(List<Bacteria> bacteriaList) {
        for (Bacteria bacteria : bacteriaList) {
            if (bacteria.getType() == BacteriaType.COCCUS) {
                Position coccusPos = bacteria.getPosition();
                if (isInsideRadius(coccusPos)) {
                    return false;
                }
            }
        }
        return true;
    }
}
