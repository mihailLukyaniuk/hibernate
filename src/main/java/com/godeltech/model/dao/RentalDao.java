package com.godeltech.model.dao;

import com.godeltech.model.common.AbstractHibernateDao;
import com.godeltech.model.dto.Rental;
import org.springframework.stereotype.Repository;

@Repository
public class RentalDao extends AbstractHibernateDao<Rental> {

    public RentalDao() {
        super();
        setClazz(Rental.class);
    }
}