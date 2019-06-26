package com.godeltech.model.dao;

import com.godeltech.model.common.AbstractHibernateDao;
import com.godeltech.model.dto.Company;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDao extends AbstractHibernateDao<Company> {

    public CompanyDao() {
        super();
        setClazz(Company.class);
    }
}