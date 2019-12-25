package sping.task1.fx;

import javafx.scene.control.Alert;

public class DialogController {

    public static void printError(String msg){
        Alert alert = alertMsg(msg, Alert.AlertType.INFORMATION);
        alert.showAndWait();
    }

    private static Alert alertMsg(String msg, Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setTitle("Error Dialog");
        alert.setHeaderText(msg);

        return alert;
    }
}
