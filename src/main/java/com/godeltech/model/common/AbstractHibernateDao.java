package com.godeltech.model.common;

import com.google.common.base.Preconditions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class AbstractHibernateDao<T extends Serializable> extends AbstractDao<T> implements IOperations<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    // API

    @Override
    public T findOne(final long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            T t = session.get(clazz, id);
            session.getTransaction().commit();
            session.close();
            return t;
        }
    }

    @Override
    public List<T> findAll() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<T> list = session.createQuery("from " + clazz.getName()).getResultList();
            session.getTransaction().commit();
            session.close();
            return list;
        }
    }

    @Override
    public T create(final T entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Preconditions.checkNotNull(entity);
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
            session.close();
            return entity;
        }
    }

    @Override
    public T update(final T entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Preconditions.checkNotNull(entity);
            T t = (T) session.merge(entity);
            session.getTransaction().commit();
            session.close();
            return t;
        }
    }

    @Override
    public void delete(final T entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Preconditions.checkNotNull(entity);
            session.delete(entity);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void deleteById(final long entityId) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            final T entity = findOne(entityId);
            Preconditions.checkNotNull(entity);
            delete(entity);
            session.getTransaction().commit();
            session.close();
        }
    }
}