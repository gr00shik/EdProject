package sping.task1.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.context.ApplicationContext;
import sping.task1.interfaces.Race;
import sping.task1.support.FXMLPageSupporter;
import sping.task1.support.SpringXmlContext;

import java.util.Objects;

public class AppController {

    public Label money;
    public TextArea eventInfo;
    public Button addBet;
    public TextField betTF;
    public TextField betTF1;
    public TextArea racInfo;

    private int moneyCount = 1000;

    @FXML
    public void initialize() {
        ApplicationContext context = SpringXmlContext.getInstance().getContext();
        Race raceObject = (Race) context.getBean("race");

        setMoneyCountInfo();
        eventInfo.setText(raceObject.createRace());
    }

    private void setMoneyCountInfo(){
        money.setText(String.valueOf(moneyCount));
    }

    public void setBet(ActionEvent actionEvent) throws InterruptedException {
        ApplicationContext context = SpringXmlContext.getInstance().getContext();
        Race raceObject = (Race) context.getBean("race");

        betTF.setDisable(true);
        betTF1.setDisable(true);

        Integer winner = raceObject.startRace(racInfo);
        if(winner != 0){
            winActivity(winner);
            resetRace(raceObject);
        }
    }

    private void winActivity(Integer winner) {
        Integer horseBet = Integer.valueOf(betTF.getText());
        Integer winMoney = Integer.valueOf(betTF1.getText());

        if(Objects.equals(horseBet, winner)){
            moneyCount += winMoney;
        } else {
            winMoney = -winMoney;
            moneyCount += winMoney;
        }
        setMoneyCountInfo();

        String msg = "Победитель - " + winner +
                " Ваш выигрыш - " + winMoney;
        FXMLPageSupporter.printError(msg, Alert.AlertType.INFORMATION);
    }

    private void resetRace(Race raceObject){
        racInfo.clear();
        betTF.setDisable(false);
        betTF1.setDisable(false);
        eventInfo.setText(raceObject.createRace());
    }
}
