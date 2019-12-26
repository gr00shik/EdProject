package sping.task1.classes.raceImpl;

import sping.task1.interfaces.Horse;
import sping.task1.interfaces.Race;
import sping.task1.interfaces.Rider;

public class RaceImpl implements Race{

    private Horse gameHorse;
    private Rider gameRider;

    public Horse getGameHorse() {
        return gameHorse;
    }

    public void setGameHorse(Horse gameHorse) {
        this.gameHorse = gameHorse;
    }

    public Rider getGameRider() {
        return gameRider;
    }

    public void setGameRider(Rider gameRider) {
        this.gameRider = gameRider;
    }

    public RaceImpl() {
        System.out.println("RaceImpl");
    }
}
