package com.tng.tntierverwaltung.gui;

import com.tng.tntierverwaltung.logic.TierManager;
import com.tng.tntierverwaltung.model.Tier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class AnimalDetailsController {
    public Button vermitteltBtn;
    public Button editBtn;
    public Button speicherBtn;
    public DatePicker datumField;
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

    @FXML
    private void onVermitteltBtn(ActionEvent actionEvent) {
        Alert vermittelnAlert = new Alert(Alert.AlertType.CONFIRMATION);
        vermittelnAlert.setTitle("Bestätigung");
        vermittelnAlert.setHeaderText(String.format("%s vermitteln?%n",selectedTier));

        Optional<ButtonType> optional = vermittelnAlert.showAndWait();

        if(optional.isPresent() && optional.get() == ButtonType.OK){
            TierManager.getInstance().remove(selectedTier);
            errorLabel.setText("Tier is vermittelt!");
            cleanUp();
            SceneManager.getInstance().switchScene("AnimalOverview.fxml");
        }
    }
    @FXML
    private void onSpeichernBtn(ActionEvent actionEvent) {

        try {
            String tierArtFieldText = tierartField.getText();
            String nameFieldText = nameField.getText();
            String farbeFieldText = farbeField.getText();
            int alterField = Integer.parseInt(this.alterField.getText());
            LocalDate date = datumField.getValue();

            if(tierArtFieldText.isEmpty() || nameFieldText.isEmpty() ||
                    alterField == 0 || farbeFieldText.isEmpty()) {
                errorLabel.setText(String.format("Üngultige Eingaben!%n" +
                        "Alter muss integer," +
                        " alle Feldern sind mandatory"));
                cleanUp();
            }
            if (selectedTier == null ){
                Tier addedTier = new Tier(
                        tierArtFieldText,
                        nameFieldText,
                        alterField,
                        farbeFieldText, date);
                TierManager.getInstance().add(addedTier);
                errorLabel.setText("Tier ist gespeichert!");
                SceneManager.getInstance().switchScene("AnimalOverview.fxml");
            }else{
                if(!tierArtFieldText.equals(selectedTier.getTierart())) selectedTier.setTierart(tierArtFieldText);
                if(!nameFieldText.equals(selectedTier.getName())) selectedTier.setName(nameFieldText);
                if(alterField != selectedTier.getAlter()) selectedTier.setAlter(alterField);
                if(!farbeFieldText.equals(selectedTier.getFarbe())) selectedTier.setFarbe(farbeFieldText);
                if(date != null) selectedTier.setDate(date);

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

        vermitteltBtn.setDisable(false);

        tierartField.setText(selectedTier.getTierart());
        nameField.setText(selectedTier.getName());
        alterField.setText(String.valueOf(selectedTier.getAlter()));
        farbeField.setText(selectedTier.getFarbe());
        datumField.setValue(selectedTier.getDate());
        setDisableTextField(true);
        speicherBtn.setDisable(true);
    }

    private void setDisableTextField(boolean b) {
        tierartField.setDisable(b);
        farbeField.setDisable(b);
        alterField.setDisable(b);
        nameField.setDisable(b);
        datumField.setDisable(b);
    }

    public void toAnimalOverviewPage(ActionEvent actionEvent) {
        SceneManager.getInstance().switchScene("AnimalOverview.fxml");
    }

    public void onEditBtn(ActionEvent actionEvent) {
        if(selectedTier!=null){
            setDisableTextField(false);
            vermitteltBtn.setDisable(true);
            speicherBtn.setDisable(false);
        }
    }

    public void onDatumSelected(ActionEvent actionEvent) {
    }
    //endregion
}
