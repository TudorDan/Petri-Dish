package com.codecool.petridish.LifeForms;

import com.codecool.petridish.PetriDish;
import com.codecool.petridish.Utilities.BacteriaType;
import com.codecool.petridish.Utilities.Position;

import java.util.List;

public class Bacillus extends Bacteria {
    public Bacillus(int id, Position position) {
        super(id, position);
        setType(BacteriaType.BACILLUS);
        setLifeSpan(10);
        setNearbyRadius(3);
    }

    @Override
    public boolean isDead() {
        List<Coccus> coccusList = PetriDish.getInstance().getCoccuses();
        for (Coccus coccus : coccusList) {
            Position coccusPos = coccus.getPosition();
            if (isInsideRadius(coccusPos)) {
                return false;
            }
        }
        return true;
    }
}
