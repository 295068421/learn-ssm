package com.kaishengit.dao;

import net.sf.ehcache.search.expression.Or;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.inject.Inject;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseDao<T,PK extends Serializable> {

    @Inject
    private SessionFactory sessionFactory;
    private Class<?> clazz;

    public BaseDao() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<?>) type.getActualTypeArguments()[0];
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(T entity) {
        getSession().saveOrUpdate(entity);
    }

    public T findById(PK id) {
        return (T) getSession().get(clazz,id);
    }

    public void del(PK id) {
        getSession().delete(findById(id));
    }

    public void del(T entity) {
        getSession().delete(entity);
    }

    public List<T> findAll() {
        Criteria criteria = getSession().createCriteria(clazz);
        return criteria.list();
    }

    public List<T> findAllOrder(String orderPropertyName,String orderType) {
        Criteria criteria = getSession().createCriteria(clazz);
        if("desc".equalsIgnoreCase(orderType)) {
            criteria.addOrder(Order.desc(orderPropertyName));
        } else {
            criteria.addOrder(Order.asc(orderPropertyName));
        }
        return criteria.list();
    }

    public T findByProperty(String propertyName,Object value) {
        Criteria criteria = getSession().createCriteria(clazz);
        criteria.add(Restrictions.eq(propertyName,value));
        return (T) criteria.uniqueResult();
    }

    public List<T> findListByProperty(String propertyName,Object value) {
        Criteria criteria = getSession().createCriteria(clazz);
        criteria.add(Restrictions.eq(propertyName,value));
        return criteria.list();
    }


}
