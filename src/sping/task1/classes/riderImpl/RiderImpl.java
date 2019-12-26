package sping.task1.classes.riderImpl;

import sping.task1.interfaces.Rider;

import java.util.Random;

public class RiderImpl implements Rider{

    private int mastery;

    public RiderImpl(){
        mastery = getRandomParam();
    }

    private int getRandomParam() {
        Random rand = new Random();
        return (rand.nextInt(10)) + 2;
    }
}
