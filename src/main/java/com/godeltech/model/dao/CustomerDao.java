package com.godeltech.model.dao;

import com.godeltech.model.common.AbstractHibernateDao;
import com.godeltech.model.dto.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao extends AbstractHibernateDao<Customer> {
    public CustomerDao() {
        super();
        setClazz(Customer.class);
    }
}