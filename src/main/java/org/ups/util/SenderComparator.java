package org.ups.util;

import org.ups.model.Package;
import java.util.Comparator;

public class SenderComparator implements Comparator<Package> {

    @Override
    public int compare(Package p1, Package p2) {
        return p1.getOrderId().compareTo(p2.getOrderId());
    }
}
