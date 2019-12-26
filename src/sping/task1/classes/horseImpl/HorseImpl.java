package sping.task1.classes.horseImpl;

import sping.task1.interfaces.Breed;
import sping.task1.interfaces.Horse;

import java.util.Random;

public class HorseImpl implements Horse{

    private Breed breedImpl;

    public Breed getBreedImpl() {
        return breedImpl;
    }

    public void setBreedImpl(Breed breed) {
        this.breedImpl = breed;
    }

    public int getWinChance(){


        return 0;
    }

}
