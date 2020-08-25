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
    public boolean isDead() {
        List<Bacillus> bacillusList = PetriDish.getInstance().getBacilli();
        for (Bacillus bacillus : bacillusList) {
            Position bacillusPos = bacillus.getPosition();
            if (isInsideRadius(bacillusPos)) {
                return true;
            }
        }
        return false;
    }
}
