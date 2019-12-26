package sping.task1.classes.horseImpl;

import sping.task1.interfaces.Breed;
import sping.task1.interfaces.Horse;

import java.util.Random;

public class HorseImpl implements Horse{

    private Breed breed;

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public Horse createHorseForRace() {
        Horse horseForRace = new HorseImpl();
        breed.setCharacteristics(getRandomParam(), getRandomParam(), getRandomParam());

        return horseForRace;
    }

    private int getRandomParam() {
        Random rand = new Random();
        return (rand.nextInt(10)) + 2;
    }
}
