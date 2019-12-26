package sping.task1.classes.breedImpl;

import sping.task1.interfaces.Breed;

public class BreedImpl implements Breed {

    private int horseSpeed;
    private int horseMaxSpeed;
    private int horseBoost;



    public void setCharacteristics(int horseSpeed, int horseMaxSpeed, int horseBoost) {
        this.horseSpeed = horseSpeed;
        this.horseMaxSpeed = horseMaxSpeed;
        this.horseBoost = horseBoost;
    }

}
