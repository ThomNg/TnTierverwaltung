package com.tng.tntierverwaltung;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AnimalDetailsController {

    //region Konstanten
    // endregion


    //region Attribute
    @FXML
    public TextField tierartField;
    @FXML
    public TextField nameField;
    @FXML
    public TextField alterField;
    @FXML
    public TextField farbeField;
    //endregion

    //region Konstruktoren
    //endregion

    //region Methoden
    public void onVermitteltBtn(ActionEvent actionEvent) {
    }

    public void onSpeichernBtn(ActionEvent actionEvent) {

    }

    public void onZurückBtn(ActionEvent actionEvent) {
        SceneManager.getInstance().switchScene("AnimalOverview.fxml");
    }
    //endregion
}
