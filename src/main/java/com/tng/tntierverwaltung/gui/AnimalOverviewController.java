package com.tng.tntierverwaltung.gui;

import com.tng.tntierverwaltung.listview.TierCellFactory;
import com.tng.tntierverwaltung.logic.TierManager;
import com.tng.tntierverwaltung.model.*;
import com.tng.tntierverwaltung.test.TestData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

import java.util.Collections;
import java.util.Comparator;

public class AnimalOverviewController{

    @FXML
    public ListView<Tier> listViewHandler;

    public void initialize(){
        // for cell
        listViewHandler.setCellFactory(new TierCellFactory());

        // get data
        listViewHandler.setItems(TierManager.getInstance().getTiers());

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
        SceneManager.getInstance().switchToDetailWithTier(null);
    }

    public void onSortTierartBtn(ActionEvent actionEvent) {
        ObservableList<Tier> listTiers = TierManager.getInstance().getTiers();
        listTiers.sort(new Comparator<Tier>() {
            @Override
            public int compare(Tier o1, Tier o2) {
                return o1.getTierart().toLowerCase().compareTo(o2.getTierart().toLowerCase());
            }
        });
    }

    public void onSortNameBtn(ActionEvent actionEvent) {
        ObservableList<Tier> listTiers = TierManager.getInstance().getTiers();
        listTiers.sort(new Comparator<Tier>() {
            @Override
            public int compare(Tier o1, Tier o2) {
                return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });
    }

    public void onSortAlterBtn(ActionEvent actionEvent) {
        ObservableList<Tier> listTiers = TierManager.getInstance().getTiers();
        listTiers.sort(new Comparator<Tier>() {
            @Override
            public int compare(Tier o1, Tier o2) {
                if(o1.getAlter()>o2.getAlter())
                    return 1;
                else
                    return -1;
            }
        });
    }

    public void onSortFarbeBtn(ActionEvent actionEvent) {
        ObservableList<Tier> listTiers = TierManager.getInstance().getTiers();

        listTiers.sort(new Comparator<Tier>() {
            @Override
            public int compare(Tier o1, Tier o2) {
                return(o1.getFarbe().toLowerCase().compareTo(o2.getFarbe().toLowerCase()));
            }
        });
    }
}