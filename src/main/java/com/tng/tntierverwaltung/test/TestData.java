package com.tng.tntierverwaltung.test;

import com.tng.tntierverwaltung.model.Tier;

import java.util.ArrayList;
import java.util.List;

public class TestData {
    //region Konstanten
    // endregion

    //region Attribute
    //endregion

    //region Konstruktoren
    //endregion

    //region Methoden
    public static List<Tier> getTier(){
        List<Tier> tempList= new ArrayList<>();
        tempList.add(new Tier("Cat", "Mirana", 2, "Grau"));
        tempList.add(new Tier("Tiger", "Pudge", 1, "Weiss"));
        tempList.add(new Tier("Cat", "Zeus", 1, "Rot"));
        tempList.add(new Tier("Dog", "Mome", 2, "Lila"));
        tempList.add(new Tier("Dog", "Komlko", 2, "Gelb"));
        tempList.add(new Tier("Vogel", "Pome", 2, "Tricolore"));
        tempList.add(new Tier("Cat", "Mamul", 2, "Braun"));
        return tempList;
    }
    //endregion
}
