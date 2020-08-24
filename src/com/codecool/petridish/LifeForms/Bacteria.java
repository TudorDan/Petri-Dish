package com.codecool.petridish.LifeForms;

import com.codecool.petridish.Utilities.BacteriaType;
import com.codecool.petridish.Utilities.Position;

import java.util.UUID;

public abstract class Bacteria {
    private final UUID id;
    private BacteriaType type;
    private final Position position;
    private int lifeSpan;
    private int nearbyRadius;
    private int counter;

    public Bacteria(Position position) {
        this.id = UUID.randomUUID();
        this.position = position;
        this.counter = 1;
    }

    public void setType(BacteriaType type) {
        this.type = type;
    }

    public void setLifeSpan(int lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public void setNearbyRadius(int nearbyRadius) {
        this.nearbyRadius = nearbyRadius;
    }

    public void increaseCounter() {
        counter++;
    }

    public Position getPosition() {
        return position;
    }

    public BacteriaType getType() {
        return type;
    }

    public String getId() {
        return id.toString().replace("-", "");
    }

    public boolean canSplit() {
        return counter == lifeSpan;
    }

    public boolean isDead() {
        return false;
    }

    public boolean isInsideRadius(Position otherBacteriaPos) {
        // Compare radius of circle with distance of its center from given
        return (otherBacteriaPos.x - position.x) * (otherBacteriaPos.x - position.x)
                + (otherBacteriaPos.y - position.y) * (otherBacteriaPos.y - position.y) <= nearbyRadius * nearbyRadius;
    }

    public boolean isOverlapping(Position otherBacteriaPos) {
        return position.x == otherBacteriaPos.x && position.y == otherBacteriaPos.y;
    }
}
