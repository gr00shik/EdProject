package sping.task1;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sping.task1.interfaces.Race;

public class Task1_Main extends Application {

    public static void main(String args[]){
//        ApplicationContext context = new ClassPathXmlApplicationContext("sping/task1/TaskOneConfig.xml");
//        Race raceObject = (Race) context.getBean("race");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }

}
