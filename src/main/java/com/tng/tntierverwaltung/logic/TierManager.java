package com.tng.tntierverwaltung.logic;


import com.tng.tntierverwaltung.model.Tier;
import com.tng.tntierverwaltung.test.TestData;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.util.Callback;

import java.util.function.Predicate;

public class TierManager {
    //region Konstanten
    private static TierManager instance;
    private ObservableList<Tier> tiers;
    // endregion

    //region Attribute
    //endregion

    //region Konstruktoren
    private TierManager() {
        // change list to observable list, but this doesn't recognizable if we change one of the attributes
        // we want all the attributes changes is also observable (i.e if you change the age, color, etc)
        // therefore we need to use the callback and then add the listener
        tiers = FXCollections.observableList(TestData.getTier(), tier -> new Observable[]{
          tier.tierartProperty(), tier.nameProperty(), tier.alterProperty(), tier.farbeProperty(), tier.dateProperty(),
        });


        tiers.addListener(new ListChangeListener<Tier>() {
            @Override
            public void onChanged(Change<? extends Tier> change) {
                //System.out.println("Änderung: "+ change);
                    while(change.next()){
                        if(change.wasUpdated()) {
                            System.out.println("Updated "+ change.wasUpdated());
                        }
                        else if(change.wasAdded()){
                            System.out.println("added "+ change.getFrom());
                        }else if(change.wasRemoved()){
                            System.out.println("removed "+ change.getRemoved());
                        }
                    }
                }
        });
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

    public ObservableList<Tier> filterBy(String s){
        return tiers.filtered(tier -> tier.getTierart().contains(s)
                || tier.getName().contains(s)
                || String.valueOf(tier.getAlter()).contains(s)
                || tier.getFarbe().contains(s)
                || tier.getDate().toString().contains(s));
    }

    public ObservableList<Tier> getTiers(){return  tiers;}
    //endregion
}
