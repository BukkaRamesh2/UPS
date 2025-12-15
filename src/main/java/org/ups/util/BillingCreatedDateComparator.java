package org.ups.util;

import java.util.Comparator;
import org.ups.model.Billing;

public class BillingCreatedDateComparator implements Comparator<Billing> {

    @Override
    public int compare(Billing b1, Billing b2) {
        if (b1.getCreatedDate() == null || b2.getCreatedDate() == null) {
            return 0;
        }
        // Strings like "2025-11-27" compare correctly in lexicographical order
        return b1.getCreatedDate().compareTo(b2.getCreatedDate());
    }
}
