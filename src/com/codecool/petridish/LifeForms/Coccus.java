package com.codecool.petridish.LifeForms;

import com.codecool.petridish.PetriDish;
import com.codecool.petridish.Utilities.BacteriaType;
import com.codecool.petridish.Utilities.Position;

import java.util.List;

public class Coccus extends Bacteria {
    public Coccus(int id, Position position) {
        super(id, position);
        setType(BacteriaType.COCCUS);
        setLifeSpan(100);
        setNearbyRadius(1);
    }

    @Override
    public boolean isDead() {
        List<Bacteria> bacteriaList = PetriDish.getBacteriaList();
        int bacteriaInstances = 0;
        for (Bacteria bacteria : bacteriaList) {
            Position bacteriaPos = bacteria.getPosition();
            if (isInsideRadius(bacteriaPos)) {
                bacteriaInstances++;
            }
        }
        return bacteriaInstances < 2;
    }
}
