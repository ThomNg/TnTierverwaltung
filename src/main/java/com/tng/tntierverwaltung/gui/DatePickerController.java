package com.tng.tntierverwaltung.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DatePickerController {



    @FXML
    private DatePicker datePickerH;
    //region Konstanten
    // endregion
    @FXML
    private TextField datePickerOutput;

    //region Attribute
    //endregion

    //region Konstruktoren
    //endregion

    //region Methoden

    public void onActionPick(ActionEvent actionEvent) {
        LocalDate ld = datePickerH.getValue();
        System.out.println(ld.getDayOfMonth()+" "+ld.getMonth()+" "+ld.getYear());
        datePickerOutput.setText(ld.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }
    //endregion
}
