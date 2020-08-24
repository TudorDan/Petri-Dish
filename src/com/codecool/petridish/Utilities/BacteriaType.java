package com.codecool.petridish.Utilities;

public enum BacteriaType {
    BACILLUS("B"),
    COCCUS("C"),
    SPIRILLUM("S");

    private final String name;

    private BacteriaType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
