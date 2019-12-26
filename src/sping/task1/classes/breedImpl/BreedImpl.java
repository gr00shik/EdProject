package sping.task1.classes.breedImpl;

import sping.task1.interfaces.Breed;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BreedImpl implements Breed {

    private int horseSpeed;
    private int horseMaxSpeed;

    public BreedImpl() {
        this.horseSpeed = getRandomParam();
        this.horseMaxSpeed = getRandomParam();
    }

    private int getRandomParam() {
        Random rand = new Random();
        return (rand.nextInt(10)) + 2;
    }
}
