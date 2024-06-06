package com.tng.tntierverwaltung.test;

import com.tng.tntierverwaltung.model.Tier;

import java.time.LocalDate;
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
        tempList.add(new Tier("Cat", "Mirana", 2, "Grau", LocalDate.of(2023,1,5)));
        tempList.add(new Tier("Tiger", "Pudge", 1, "Weiss", LocalDate.of(2098, 1, 5)));
        tempList.add(new Tier("Cat", "Zeus", 1, "Rot", LocalDate.of(1923, 1, 5)));
        tempList.add(new Tier("Dog", "Mome", 2, "Lila", LocalDate.of(1023, 1, 5)));
        tempList.add(new Tier("Dog", "Komlko", 2, "Gelb", LocalDate.of(1077, 1, 5)));
        tempList.add(new Tier("Vogel", "Pome", 2, "Tricolore", LocalDate.of(1000, 1, 5)));
        tempList.add(new Tier("Cat", "Mamul", 2, "Braun", LocalDate.of(2132, 1, 5)));
        return tempList;
    }
    //endregion
}
