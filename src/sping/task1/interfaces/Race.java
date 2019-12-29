package sping.task1.interfaces;

import javafx.scene.control.TextArea;

public interface Race {

    String createRace();
    Integer startRace(TextArea textArea) throws InterruptedException;

}
