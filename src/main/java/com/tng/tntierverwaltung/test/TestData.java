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
        tempList.add(new Tier("Cat", "Pudge", 1, "Weiss"));
        tempList.add(new Tier("Cat", "Zeus", 1, "Rot"));
        tempList.add(new Tier("Cat", "Momo", 2, "Tricolore"));
        return tempList;
    }
    //endregion
}
