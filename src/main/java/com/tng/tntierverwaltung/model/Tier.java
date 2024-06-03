package com.tng.tntierverwaltung.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Tier {
    //region Konstanten
    // endregion

    //region Attribute
    private StringProperty tierart;
    private StringProperty name;
    private IntegerProperty alter;
    private StringProperty farbe;
    //endregion

    //region Konstruktoren
    public Tier(String tierart, String name, int alter, String farbe) {
        this.tierart = new SimpleStringProperty(tierart);
        this.name = new SimpleStringProperty(name);
        this.alter = new SimpleIntegerProperty(alter);
        this.farbe = new SimpleStringProperty(farbe);
    }
    //endregion

    //region Methoden


    public String getTierart() {
        return tierart.get();
    }

    public StringProperty tierartProperty() {
        return tierart;
    }

    public void setTierart(String tierart) {
        this.tierart.set(tierart);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getAlter() {
        return alter.get();
    }

    public IntegerProperty alterProperty() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter.set(alter);
    }

    public String getFarbe() {
        return farbe.get();
    }

    public StringProperty farbeProperty() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe.set(farbe);
    }

    @Override
    public String toString() {
        return "Tier{" +
                "Tierart='" + tierart.get() + '\'' +
                ", name='" + name.get() + '\'' +
                ", alter=" + alter.get() +
                ", farbe='" + farbe.get() + '\'' +
                '}';
    }
   //endregion
}
