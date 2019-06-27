package com.godeltech.model.dao;

import com.godeltech.model.common.AbstractHibernateDao;
import com.godeltech.model.dto.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class CarDao extends AbstractHibernateDao<Car> {

    @Autowired
    SessionFactory sessionFactory;

    public CarDao() {
        super();
        setClazz(Car.class);
    }

    public List<Car> findCarByLocationAndDate(String countryCode, String city, LocalDate startDate, LocalDate endDate) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Query query = session.createSQLQuery(
                    "SELECT * FROM CAR as c LEFT JOIN RENTAL as r " +
                            "on c.ID = r.CAR_ID LEFT JOIN COMPANY c2 " +
                            "on c.COMPANY_ID = c2.ID LEFT JOIN LOCATION L " +
                            "on c2.LOCATION_ID = L.ID " +
                            "where (L.COUNTRYCODE = :countryCode " +
                            "and L.CITY = :city and (r.CAR_ID is NULL " +
                            "or r.STARTDATETIME >= :endDate " +
                            "or r.ENDDATETIME <= :startDate)) ")
                    .setParameter("countryCode", countryCode)
                    .setParameter("city", city)
                    .setParameter("endDate", endDate)
                    .setParameter("startDate", startDate)
                    .addEntity(Car.class);

            final List<Car> list = query.list();
            session.getTransaction().commit();
            session.close();
            return list;
        }
    }

    public List<Car> findCarByCompanyNameAndDate(String companyName, LocalDate startDate, LocalDate endDate) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Query query = session.createSQLQuery(
                    "SELECT * FROM CAR as c LEFT JOIN RENTAL as r " +
                            "on c.ID = r.CAR_ID LEFT JOIN COMPANY c2 " +
                            "on c.COMPANY_ID = c2.ID " +
                            "where (c2.NAME = :companyName and " +
                            "(r.CAR_ID is NULL or r.STARTDATETIME >= :endDate " +
                            "or r.ENDDATETIME <= :startDate)) ")
                    .setParameter("companyName", companyName)
                    .setParameter("endDate", endDate)
                    .setParameter("startDate", startDate)
                    .addEntity(Car.class);

            final List<Car> list = query.list();
            session.getTransaction().commit();
            session.close();
            return list;
        }
    }
}