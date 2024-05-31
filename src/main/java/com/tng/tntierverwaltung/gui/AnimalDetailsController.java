package com.tng.tntierverwaltung.gui;

import com.tng.tntierverwaltung.logic.TierManager;
import com.tng.tntierverwaltung.model.Tier;
import com.tng.tntierverwaltung.test.TestData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class AnimalDetailsController {
    //region Konstanten
    // endregion

    //region Attribute
    @FXML
    private TextField tierartField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField alterField;
    @FXML
    private TextField farbeField;
    @FXML
    private Label errorLabel;

    private Tier selectedTier;

    //endregion

    //region Konstruktoren
    //endregion

    //region Methoden
    public void onVermitteltBtn(ActionEvent actionEvent) {

        if(selectedTier != null){
            TierManager.getInstance().getTiers().remove(selectedTier);
            errorLabel.setText("Tier is vermittelt!");
            cleanUp();
            SceneManager.getInstance().switchScene("AnimalOverview.fxml");
        }
    }
    public void onSpeichernBtn(ActionEvent actionEvent) {

        try {
            if(tierartField.getText().isEmpty() || nameField.getText().isEmpty() || alterField.getText().isEmpty() || farbeField.getText().isEmpty()) {
                errorLabel.setText(String.format("Üngultige Eingaben!%n" +
                        "Alter muss integer," +
                        "%nandere Eingaben String," +
                        "%ndarf nicht leer"));
                cleanUp();
            }else {
                Tier addedTier = new Tier(tierartField.getText(), nameField.getText(), Integer.parseInt(alterField.getText()), farbeField.getText());
                TierManager.getInstance().getTiers().add(addedTier);
                errorLabel.setText("Tier ist gespeichert!");
                SceneManager.getInstance().switchScene("AnimalOverview.fxml");
            }
        } catch (Exception e) {
            System.out.println("Üngultige Eingaben");
        }
    }

    private void cleanUp() {
        tierartField.setText("");
        nameField.setText("");
        alterField.setText("");
        farbeField.setText("");
    }

    public void setSelectedTier(Tier selectedTier) {
        this.selectedTier = selectedTier;
        if(selectedTier == null) return;

        tierartField.setText(selectedTier.getTierart());
        nameField.setText(selectedTier.getName());
        alterField.setText(String.valueOf(selectedTier.getAlter()));
        farbeField.setText(selectedTier.getFarbe());
    }

    public void onZurückBtn(ActionEvent actionEvent) {
        SceneManager.getInstance().switchScene("AnimalOverview.fxml");
    }
    //endregion
}
