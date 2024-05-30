package com.tng.tntierverwaltung.gui;

import com.tng.tntierverwaltung.listview.TierCellFactory;
import com.tng.tntierverwaltung.model.Tier;
import com.tng.tntierverwaltung.test.TestData;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

public class AnimalOverviewController{

    @FXML
    public ListView<Tier> listViewHandler;

    public void initialize(){
        // for cell
        listViewHandler.setCellFactory(new TierCellFactory());

        // get data
        listViewHandler.setItems(FXCollections.observableList(TestData.getTier()));

        // two kind event-handler for view list
        listViewHandler.setOnMousePressed(mouseEvent -> {
            if (mouseEvent.getButton() == MouseButton.PRIMARY && mouseEvent.getClickCount() == 2) {
                goToDetailsOverviewWithSelectedTier();
            }
        });

        listViewHandler.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode() == KeyCode.ENTER){
                goToDetailsOverviewWithSelectedTier();
            }
        });
    }

    private void goToDetailsOverviewWithSelectedTier() {
        Tier selectedTier = listViewHandler.getSelectionModel().getSelectedItem();
        SceneManager.getInstance().switchToDetailWithTier(selectedTier);
    }

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