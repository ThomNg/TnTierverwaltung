package com.tng.tntierverwaltung.gui;

import com.tng.tntierverwaltung.listview.TierCellFactory;
import com.tng.tntierverwaltung.logic.TierManager;
import com.tng.tntierverwaltung.model.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

import java.util.Comparator;

public class AnimalOverviewController{

    @FXML
    private TextField searchbar;
    // FXML private <-> public
    @FXML
    private ListView<Tier> listViewHandler;

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

        searchbar.textProperty().addListener((observableValue, oldV, newV) ->
                listViewHandler.setItems(TierManager.getInstance().filterBy(newV)));
    }

    private void goToDetailsOverviewWithSelectedTier() {
        Tier selectedTier = listViewHandler.getSelectionModel().getSelectedItem();
        SceneManager.getInstance().switchToDetailWithTier(selectedTier);
    }

    @FXML
    public void onClickTierAufnahmeBtn() {
        SceneManager.getInstance().switchToDetailWithTier(null);
    }
    @FXML
    public void onSortTierartBtn() {
        ObservableList<Tier> listTiers = TierManager.getInstance().getTiers();
        listTiers.sort(Comparator.comparing(o -> o.getTierart().toLowerCase()));
    }
    @FXML
    public void onSortNameBtn() {
        ObservableList<Tier> listTiers = TierManager.getInstance().getTiers();
        listTiers.sort(Comparator.comparing(o -> o.getName().toLowerCase()));
    }
    @FXML
    public void onSortAlterBtn() {
        ObservableList<Tier> listTiers = TierManager.getInstance().getTiers();
        listTiers.sort(Comparator.comparingInt(Tier::getAlter));
    }
    @FXML
    public void onSortFarbeBtn() {
        ObservableList<Tier> listTiers = TierManager.getInstance().getTiers();
        listTiers.sort(Comparator.comparing(o -> o.getFarbe().toLowerCase()));
    }
}