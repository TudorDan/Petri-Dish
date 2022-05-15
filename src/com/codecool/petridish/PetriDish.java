package com.codecool.petridish;

import com.codecool.petridish.LifeForms.Bacillus;
import com.codecool.petridish.LifeForms.Bacteria;
import com.codecool.petridish.LifeForms.Coccus;
import com.codecool.petridish.LifeForms.Spirillum;
import com.codecool.petridish.Utilities.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public void setInitialBacteria() {
        Position firstBacillusPos = new Position(3, 5);
        bacteriaList.add(new Bacillus(firstBacillusPos));
        Position firstCoccusPos = new Position(2, 4);
        bacteriaList.add(new Coccus(firstCoccusPos));
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setTimePulse() {
        timePulse = 0;
    }

    public void addBacteria(Bacteria bacteria) {
        bacteriaList.add(bacteria);
    }

    public void processBacteriaList() {
        timePulse++;
        System.out.println("\nTime Pulse: " + timePulse + " Petri dish contains:");
        //enumerateBacteria();
        display();

        List<Bacteria> copyOfBacteriaList = new ArrayList<>(bacteriaList);
        for (Bacteria bacteria : bacteriaList) {
            bacteria.increaseCounter();
            // dividing bacteria
            if (bacteria.canSplit()) {
                Position newBacteriaPos1 = new Position(getRandomNumberInRange(0, width - 1), getRandomNumberInRange(0,
                        width - 1));
                Position newBacteriaPos2 = new Position(getRandomNumberInRange(0, width - 1), getRandomNumberInRange(0,
                        width - 1));

                while (!bacteria.isInsideRadius(newBacteriaPos1) || bacteria.isOverlapping(newBacteriaPos1)
                        || (newBacteriaPos1.x == newBacteriaPos2.x && newBacteriaPos1.y == newBacteriaPos2.y)) {
                    newBacteriaPos1 = new Position(getRandomNumberInRange(0, width - 1), getRandomNumberInRange(0,
                            width - 1));
                }
                while (!bacteria.isInsideRadius(newBacteriaPos2) || bacteria.isOverlapping(newBacteriaPos2)
                        || (newBacteriaPos1.x == newBacteriaPos2.x && newBacteriaPos1.y == newBacteriaPos2.y)) {
                    newBacteriaPos2 = new Position(getRandomNumberInRange(0, width - 1), getRandomNumberInRange(0,
                            width - 1));
                }

                switch (bacteria.getType()) {
                    case BACILLUS:
                        copyOfBacteriaList.add(new Bacillus(newBacteriaPos1));
                        copyOfBacteriaList.add(new Bacillus(newBacteriaPos2));
                        System.out.println(bacteria.getId() + " " + bacteria.getType() + " split into 2 new Bacilli");
                        break;
                    case COCCUS:
                        copyOfBacteriaList.add(new Coccus(newBacteriaPos1));
                        copyOfBacteriaList.add(new Coccus(newBacteriaPos2));
                        System.out.println(bacteria.getId() + " " + bacteria.getType() + " split into 2 new Coccuses");
                        break;
                    case SPIRILLUM:
                        copyOfBacteriaList.add(new Spirillum(newBacteriaPos1));
                        copyOfBacteriaList.add(new Spirillum(newBacteriaPos2));
                        System.out.println(bacteria.getId() + " " + bacteria.getType() + " split into 2 new Spirillum");
                        break;
                }
                copyOfBacteriaList.remove(bacteria);
                System.out.println(bacteria.getId() + " " + bacteria.getType() + " died fom Life Span End");
            } else if (bacteria.isDead(bacteriaList)) {
                System.out.println(bacteria.getId() + " " + bacteria.getType() + " died from Nearby Conditions");
                copyOfBacteriaList.remove(bacteria);
            }
            bacteriaList = new ArrayList<>(copyOfBacteriaList);
        }
    }

    public void display() {
        for (int y = 0; y < width; y++) {
            StringBuilder line = new StringBuilder();
            for (int x = 0; x < width; x++) {
                boolean isSpaceOccupied = false;
                for (Bacteria bacteria : bacteriaList) {
                    if (bacteria.getPosition().x == x && bacteria.getPosition().y == y) {
                        line.append(bacteria.getType().getName()).append(" ");
                        isSpaceOccupied = true;
                        break;
                    }
                }
                if (!isSpaceOccupied) {
                    line.append(". ");
                }
            }
            System.out.println(line);
        }
    }

    /**
     * Generates a random integer
     *
     * @param min inclusive
     * @param max inclusive
     * @return integer
     */
    public int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
