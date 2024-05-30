package com.tng.tntierverwaltung.listview;

import com.tng.tntierverwaltung.model.Tier;
import javafx.scene.control.ListCell;
import javafx.scene.text.Font;

public class TierCell extends ListCell<Tier> {
    @Override
    protected void updateItem(Tier tier, boolean isEmpty) {
        super.updateItem(tier, isEmpty);
        if(isEmpty && tier == null){
            setText(null);
            setGraphic(null);
        }else{
            setText(String.format(("%-15s %-15s %5d %15s"),tier.getTierart(), tier.getName(),tier.getAlter(),tier.getFarbe()));
            setFont(Font.font("Consolas"));
        }
    }
}
