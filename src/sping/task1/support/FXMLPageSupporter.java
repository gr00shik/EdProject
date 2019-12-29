package sping.task1.support;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Control;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class FXMLPageSupporter {

    public static void startWindow(String path, String fileName) throws IOException {
        ResourceBundle rb = ResourceBundle.getBundle("sizes");
        String[] sizeArray = rb.getString(fileName).split(";");

        Parent root = FXMLLoader.load(FXMLPageSupporter.class.getResource(path));
        Stage stage = new Stage();
        stage.setScene(new Scene(root, Double.valueOf(sizeArray[0]), Double.valueOf(sizeArray[1])));
        stage.show();
    }

    public static void closeWindow(Control sceneItem){
        Stage stage = (Stage) sceneItem.getScene().getWindow();
        stage.close();
    }

    public static void printError(String msg, Alert.AlertType alertType){
        Alert alert = alertMsg(msg, alertType);
        alert.showAndWait();
    }

    private static Alert alertMsg(String msg, Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setTitle("Dialog");
        alert.setHeaderText(msg);

        return alert;
    }

}
