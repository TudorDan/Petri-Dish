package com.codecool.petridish;

import com.codecool.petridish.LifeForms.Bacillus;
import com.codecool.petridish.LifeForms.Bacteria;
import com.codecool.petridish.LifeForms.Coccus;
import com.codecool.petridish.LifeForms.Spirillum;
import com.codecool.petridish.Utilities.BacteriaType;
import com.codecool.petridish.Utilities.Position;

import java.util.*;

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
        bacteriaList.add(new Bacillus(firstBacillusPos));
        Position firstCoccusPos = new Position(2, 4);
        bacteriaList.add(new Coccus(firstCoccusPos));
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

    public static int getTimePulse() {
        return timePulse;
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

    public List<Bacillus> getBacilli() {
        List<Bacillus> bacilli = new ArrayList<>();
        for (Bacteria bacteria : bacteriaList) {
            if (bacteria.getType() == BacteriaType.BACILLUS) {
                bacilli.add((Bacillus) bacteria);
            }
        }
        return bacilli;
    }

    public void splitBacteria() {
        ListIterator<Bacteria> iterator = bacteriaList.listIterator();
        while (iterator.hasNext()) {
            Bacteria bacteria = iterator.next();
            if (bacteria.canSplit()) {
                Position newBacteriaPos1 = new Position(getRandomNumberInRange(0, width), getRandomNumberInRange(0,
                        width));
                Position newBacteriaPos2 = new Position(getRandomNumberInRange(0, width), getRandomNumberInRange(0,
                        width));

                while (!bacteria.isInsideRadius(newBacteriaPos1)
                        && (newBacteriaPos1.x != newBacteriaPos2.x || newBacteriaPos1.y != newBacteriaPos2.y)) {
                    newBacteriaPos1 = new Position(getRandomNumberInRange(0, width), getRandomNumberInRange(0, width));
                }
                while (!bacteria.isInsideRadius(newBacteriaPos2)
                        && (newBacteriaPos1.x != newBacteriaPos2.x || newBacteriaPos1.y != newBacteriaPos2.y)){
                    newBacteriaPos2 = new Position(getRandomNumberInRange(0, width), getRandomNumberInRange(0, width));
                }

                switch (bacteria.getType()) {
                    case BACILLUS:
                        iterator.add(new Bacillus(newBacteriaPos1));
                        iterator.add(new Bacillus(newBacteriaPos2));
                        break;
                    case COCCUS:
                        iterator.add(new Coccus(newBacteriaPos1));
                        iterator.add(new Coccus(newBacteriaPos2));
                        break;
                    case SPIRILLUM:
                        iterator.add(new Spirillum(newBacteriaPos1));
                        iterator.add(new Spirillum(newBacteriaPos2));
                        break;
                }
                iterator.remove();
            }
        }
    }

    /**
     * Generates a random integer
     *
     * @param min inclusive
     * @param max inclusive
     * @return integer
     */
    public static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
