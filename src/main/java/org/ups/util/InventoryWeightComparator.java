package org.ups.util;

import org.ups.model.Inventory;
import java.util.Comparator;

public class InventoryWeightComparator implements Comparator<Inventory> {

    @Override
    public int compare(Inventory o1, Inventory o2) {
        return Double.compare(o1.getWeight(), o2.getWeight());
    }
}