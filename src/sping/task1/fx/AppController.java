package sping.task1.fx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sping.task1.interfaces.Race;

public class AppController {

    public Label money;

    public TextArea eventInfo;
    public Button addBet;
    public Button skipBet;
    public TextField betTF;
    public TextArea racInfo;
    public Label betMoneyInfo;

    private int moneyCount = 1000;

    @FXML
    public void initialize() {
        ApplicationContext context = new ClassPathXmlApplicationContext("sping/task1/TaskOneConfig.xml");
        Race raceObject = (Race) context.getBean("race");

        setMoneyCountInfo();


    }

    private void setMoneyCountInfo(){
        money.setText(String.valueOf(moneyCount));
    }

}
