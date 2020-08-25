package com.codecool.petridish;

import com.codecool.petridish.LifeForms.Bacillus;
import com.codecool.petridish.LifeForms.Bacteria;
import com.codecool.petridish.LifeForms.Spirillum;
import com.codecool.petridish.Utilities.Position;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Project simulation..");

        PetriDish petriDish = PetriDish.getInstance();
        petriDish.setWidth(10);
        petriDish.setTimePulse();
        petriDish.setInitialBacteria();

        Position spirillumPos = new Position(7, 7);
        petriDish.addBacteria(new Spirillum(spirillumPos));
        Position bacillusPos2 = new Position(2, 3);
        petriDish.addBacteria(new Bacillus(bacillusPos2));
        Position bacillusPos3 = new Position(1, 4);
        petriDish.addBacteria(new Bacillus(bacillusPos3));

        for (int i = 1; i <= 100; i++) {
            petriDish.processBacteriaList();
        }

        System.out.println("End of Project simulation.");
    }
}
