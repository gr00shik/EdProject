package sping.task1.classes.raceImpl;

import sping.task1.interfaces.Horse;
import sping.task1.interfaces.Race;
import sping.task1.interfaces.Rider;

import java.util.List;
import java.util.Random;

public class RaceImpl implements Race{

    private Horse gameHorse;
    private Rider gameRider;

    private List<Horse> horseParticipants;
    private List<Rider> riderParticipants;

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

    public String createRace() {
        Random rand = new Random();
        // horses count in race
        int participants = rand.nextInt(10) + 2;
        for (int i = 0 ; i < participants ; i++) {
//            horseParticipants.add(gameHorse.)
        }

        return null;
    }
}
