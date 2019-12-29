package sping.task1.classes.raceImpl;

import javafx.scene.control.TextArea;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import sping.task1.interfaces.Horse;
import sping.task1.interfaces.Pare;
import sping.task1.interfaces.Race;
import sping.task1.interfaces.Rider;
import sping.task1.support.RandomUtil;
import sping.task1.support.SpringXmlContext;

import java.util.*;

@Component("race")
public class RaceImpl implements Race{

    private Map<Integer, Pare> participants;
    TextArea textArea;
    String template = "|Num | MaxSpeed | Rider mastery |";

    public String createRace() {
        participants = new HashMap<>();
        String raceInfo = template + "\n";
        ApplicationContext context = SpringXmlContext.getInstance().getContext();

        // horses count in race
        int members = RandomUtil.getRandomParam(10, 2);
        for (int i = 1 ; i <= members ; i++) {

            Pare gameHorse = (Pare) context.getBean("pare");

            raceInfo = raceInfo
                    + "|       " + i
                    + "|               " + gameHorse.getHorse().getHorseMaxSpeed()
                    + "|               " + gameHorse.getRider().getRiderMastery() + " |" + "\n";
            participants.put(i, gameHorse);
        }

        return raceInfo;
    }

    @Override
    public Integer startRace(TextArea textArea) throws InterruptedException {
        this.textArea = textArea;
        Integer winner = 0;

        clearTextArea();
        for (int i = 1; i <= participants.size(); i++) {
            Pare pare = participants.get(i);
            Integer position = pare.pareHeap();

            if (position >= 100){
                winner = i;
                setRaceParePosition(100, i);
                return winner;
            }

            setRaceParePosition(position, i);
        }

        return winner;
    }

    private void setRaceParePosition(Integer pos, Integer name){
        setTextAreaText("|");
        for (int i = 1; i <= 100; i++){
            if(i == pos){
                setTextAreaText(name.toString());
            } else {
                setTextAreaText("-");
            }
        }
        setTextAreaText("|\n");
    }

    private void setTextAreaText(String text){
        textArea.setText(textArea.getText() + text);
    }

    private void clearTextArea() {
        textArea.clear();
    }
}
