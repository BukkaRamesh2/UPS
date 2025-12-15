package org.ups.util;

import java.util.Comparator;
import org.ups.model.Billing;

public class BillingAmountComparator implements Comparator<Billing> {

    @Override
    public int compare(Billing b1, Billing b2) {
        return Double.compare(b1.getBillingAmount(), b2.getBillingAmount());
    }
}
