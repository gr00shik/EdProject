package sping.task1.classes.raceImpl;

import org.springframework.context.ApplicationContext;
import sping.task1.interfaces.Horse;
import sping.task1.interfaces.Pare;
import sping.task1.interfaces.Race;
import sping.task1.interfaces.Rider;
import sping.task1.support.SpringXmlContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceImpl implements Race{

    private List<Pare> participants;
    String template = "|Num | MaxSpeed| Rider mastery| prize|";

    public String createRace() {
        Random rand = new Random();
        participants = new ArrayList<Pare>();

        // horses count in race
        int members = rand.nextInt(10) + 2;
        for (int i = 0 ; i < members ; i++) {

            ApplicationContext context = SpringXmlContext.getInstance().getContext();
            Pare gameHorse = (Pare) context.getBean("pare");

            participants.add(gameHorse);
        }


        return null;
    }
}
