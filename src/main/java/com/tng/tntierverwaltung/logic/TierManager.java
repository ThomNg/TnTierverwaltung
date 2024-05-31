package com.tng.tntierverwaltung.logic;


import com.tng.tntierverwaltung.model.Tier;
import com.tng.tntierverwaltung.test.TestData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TierManager {
    //region Konstanten
    private static TierManager instance;
    private ObservableList<Tier> tiers;
    // endregion

    //region Attribute
    //endregion

    //region Konstruktoren
    private TierManager() {
        tiers = FXCollections.observableList(TestData.getTier());
    }
    //endregion

    //region Methoden
    public void add(Tier tier){tiers.add(tier);}
    public void remove(Tier tier){tiers.remove(tier);}
    public void replace(Tier tier){tiers.set(tiers.indexOf(tier),tier);}

    public static synchronized TierManager getInstance() {
        if (instance == null) {
            instance = new TierManager();
        }
        return instance;
    }

    public ObservableList<Tier> getTiers(){return  tiers;}
    //endregion
}
