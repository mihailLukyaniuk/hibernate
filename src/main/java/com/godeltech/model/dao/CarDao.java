package com.godeltech.model.dao;

import com.godeltech.model.dto.Car;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CarDao implements Dao<Car, Long> {

//    @Autowired
//    private Session sessionFactory;


    @Override
    public void persist(Car entity) {
//        try (Session session = sessionFactory.getSessionFactory().openSession()) {
//            Transaction transaction = session.beginTransaction();
//            session.saveOrUpdate(entity);
//           transaction.commit();
//        }
    }

    @Override
    public void update(Car entity) {
    }

    @Override
    public Car findById(Long id) {
        return null;
    }

    @Override
    public void delete(Car entity) {
    }

    @Override
    public List<Car> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {
    }


}
