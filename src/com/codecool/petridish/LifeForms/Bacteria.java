package com.codecool.petridish.LifeForms;

import com.codecool.petridish.Utilities.BacteriaType;
import com.codecool.petridish.Utilities.Position;

public abstract class Bacteria {
    private int id;
    private BacteriaType type;
    private Position coordinates;
    private int lifeSpan;
    private int nearbyRadius;


    public Bacteria(int id) {
        this.id = id;
    }

    public void setType(BacteriaType type) {
        this.type = type;
    }

    public void setCoordinates(Position coordinates) {
        this.coordinates = coordinates;
    }

    public void setLifeSpan(int lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public void setNearbyRadius(int nearbyRadius) {
        this.nearbyRadius = nearbyRadius;
    }

    public boolean canSplit() {
        return false;
    }

    public boolean isDead() {
        return false;
    }
}
