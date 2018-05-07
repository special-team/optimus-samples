package org.ufox.rubik.optimus.archer.business.customer.service;

import org.ufox.rubik.optimus.archer.business.customer.entity.Customer;
import org.ufox.rubik.optimus.archer.business.customer.entity.query.QCustomer;

public interface BusinessService {

    void create(Customer customer);

    void update(Customer customer);

    QCustomer createCustomerQuery();
}
