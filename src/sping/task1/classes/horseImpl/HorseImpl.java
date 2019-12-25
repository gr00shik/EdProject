package sping.task1.classes.horseImpl;

import sping.task1.interfaces.Breed;
import sping.task1.interfaces.Horse;

public class HorseImpl implements Horse{

    private Breed breed;

    public HorseImpl(){
        System.out.println("HorseImpl");
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

}
