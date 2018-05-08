package org.ufox.rubik.optimus.kernel.business.customer.service.impl;

import com.github.ooknight.rubik.core.kernel.DBContext;
import org.ufox.rubik.optimus.archer.business.customer.entity.Customer;
import org.ufox.rubik.optimus.archer.business.customer.entity.query.QCustomer;
import org.ufox.rubik.optimus.archer.business.customer.service.BusinessService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Resource
    private DBContext db;

    @Override
    public void create(Customer customer) {
        db.insert(customer);
    }

    @Override
    public void update(Customer customer) {
        db.update(customer);
    }

    @Override
    public QCustomer createCustomerQuery() {
        return db.createQuery(QCustomer.class);
    }
}
