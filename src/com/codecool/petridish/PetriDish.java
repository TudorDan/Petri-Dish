package com.codecool.petridish;

import com.codecool.petridish.LifeForms.Bacillus;
import com.codecool.petridish.LifeForms.Bacteria;
import com.codecool.petridish.LifeForms.Coccus;
import com.codecool.petridish.Utilities.BacteriaType;
import com.codecool.petridish.Utilities.Position;

import java.util.ArrayList;
import java.util.List;

public class PetriDish {
    private static PetriDish instance = null;
    private static List<Bacteria> bacteriaList = new ArrayList<>();
    private static int timePulse;
    private int width;

    private PetriDish() {
    }

    public static PetriDish getInstance() {
        if (instance == null) {
            instance = new PetriDish();
            System.out.println("[Global] Petri dish created.");
        }
        return instance;
    }

    public static void setBacteriaList() {
        Position firstBacillusPos = new Position(3, 5);
        bacteriaList.add(new Bacillus(bacteriaList.size() + 1, firstBacillusPos));
        Position firstCoccusPos = new Position(2, 4);
        bacteriaList.add(new Coccus(bacteriaList.size() + 1, firstCoccusPos));
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public static void setTimePulse() {
        timePulse = 0;
    }

    public void addBacteria(Bacteria bacteria) {
        bacteriaList.add(bacteria);
    }

    public static List<Bacteria> getBacteriaList() {
        return bacteriaList;
    }

    public List<Coccus> getCoccuses() {
        List<Coccus> coccuses = new ArrayList<>();
        for (Bacteria bacteria : bacteriaList) {
            if (bacteria.getType() == BacteriaType.COCCUS) {
                coccuses.add((Coccus) bacteria);
            }
        }
        return coccuses;
    }
}
