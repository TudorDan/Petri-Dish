package com.codecool.petridish.LifeForms;

import com.codecool.petridish.Utilities.BacteriaType;
import com.codecool.petridish.Utilities.Position;

public abstract class Bacteria {
    private int id;
    private BacteriaType type;
    private Position coordinates;
    private int nearbyRadius;
    private int lifeSpan;

    public boolean canSplit() {
        return false;
    }

    public boolean isDead() {
        return false;
    }
}
