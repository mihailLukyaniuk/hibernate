package com.godeltech.model.dao;

import com.godeltech.model.common.AbstractHibernateDao;
import com.godeltech.model.dto.Location;
import org.springframework.stereotype.Repository;

@Repository
public class LocationDao extends AbstractHibernateDao<Location> {

    public LocationDao() {
        super();
        setClazz(Location.class);
    }
}