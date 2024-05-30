package com.tng.tntierverwaltung;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class AnimalOverviewController {

    @FXML
    public ListView viewList;

    public void onClickTierAufnahmeBtn(ActionEvent actionEvent) {
        SceneManager.getInstance().switchScene("AnimalDetails.fxml");
    }

    public void onSortTierartBtn(ActionEvent actionEvent) {
    }

    public void onSortNameBtn(ActionEvent actionEvent) {
    }

    public void onSortAlterBtn(ActionEvent actionEvent) {
    }

    public void onSortFarbeBtn(ActionEvent actionEvent) {
    }
}