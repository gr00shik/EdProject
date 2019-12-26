package sping.task1;

import javafx.application.Application;
import javafx.stage.Stage;
import sping.task1.support.FXMLPageSupporter;

import java.io.IOException;

public class Task1_Main extends Application {

    public static void main(String args[]){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLPageSupporter.startWindow("/sping/task1/fx/app.fxml", "StartPage");
    }

}