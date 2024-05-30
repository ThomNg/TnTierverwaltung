package com.tng.model;

public class Tier {
    //region Konstanten
    // endregion

    //region Attribute
    private String Tierart;
    private String name;
    private int alter;
    private String farbe;
    //endregion

    //region Konstruktoren
    public Tier(String tierart, String name, int alter, String farbe) {
        Tierart = tierart;
        this.name = name;
        this.alter = alter;
        this.farbe = farbe;
    }
    //endregion


    //region Methoden
    public String getTierart() {
        return Tierart;
    }

    public void setTierart(String tierart) {
        Tierart = tierart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    @Override
    public String toString() {
        return "Tier{" +
                "Tierart='" + Tierart + '\'' +
                ", name='" + name + '\'' +
                ", alter=" + alter +
                ", farbe='" + farbe + '\'' +
                '}';
    }
   //endregion
}
