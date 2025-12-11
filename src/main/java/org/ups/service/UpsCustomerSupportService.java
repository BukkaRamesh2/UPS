package org.ups.service;

import org.ups.model.UpsCustomerSupport;

public interface UpsCustomerSupportService {

    UpsCustomerSupport createCustomerSupport(UpsCustomerSupport support);

    UpsCustomerSupport getCustomerSupportById(int id);

    UpsCustomerSupport updateCustomerSupport(UpsCustomerSupport support);

    boolean deleteCustomerSupport(int id);
}
