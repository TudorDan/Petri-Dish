package com.codecool.petridish.LifeForms;

import com.codecool.petridish.PetriDish;
import com.codecool.petridish.Utilities.BacteriaType;
import com.codecool.petridish.Utilities.Position;

import java.util.List;

public class Spirillum extends Bacteria {
    private int counter;

    public Spirillum(Position position) {
        super(position);
        setType(BacteriaType.SPIRILLUM);
        setLifeSpan(40);
        setNearbyRadius(2);
    }

    @Override
    public boolean isDead(List<Bacteria> bacteriaList) {
        for (Bacteria bacteria : bacteriaList) {
            if (bacteria.getType() == BacteriaType.BACILLUS) {
                Position bacillusPos = bacteria.getPosition();
                if (isInsideRadius(bacillusPos)) {
                    return true;
                }
            }
        }
        return false;
    }
}
