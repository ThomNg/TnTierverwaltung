package com.tng.tntierverwaltung.listview;

import com.tng.tntierverwaltung.model.Tier;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;


public class TierCellFactory implements Callback<ListView<Tier>, ListCell<Tier>> {
    @Override
    public ListCell<Tier> call(ListView<Tier> tierListView) {
        return new TierCell();
    }
}
