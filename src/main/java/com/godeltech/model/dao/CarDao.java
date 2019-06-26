package com.godeltech.model.dao;

import com.godeltech.model.common.AbstractHibernateDao;
import com.godeltech.model.dto.Car;
import org.springframework.stereotype.Repository;

@Repository
public class CarDao extends AbstractHibernateDao<Car>{

    public CarDao() {
        super();
        setClazz(Car.class);
    }
}