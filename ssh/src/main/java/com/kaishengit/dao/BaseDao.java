package com.kaishengit.dao;

import com.kaishengit.util.Page;
import com.kaishengit.util.SearchFilter;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
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

    public List<T> findByPage(Integer start,Integer end) {
        Criteria criteria = getSession().createCriteria(clazz);
        criteria.setFirstResult(start);
        criteria.setMaxResults(end);
        return criteria.list();
    }

    public Page<T> findPage(Integer pageNo,Integer pageSize) {
        int count = count().intValue();
        Page<T> page = new Page<T>(pageNo.toString(),count,pageSize);
        page.setItems(findByPage(page.getStart(),page.getSize()));
        return page;
    }

    public List<T> findBySearchFilter(List<SearchFilter> searchFilters) {
        Criteria criteria = getSession().createCriteria(clazz);
        for(SearchFilter searchFilter : searchFilters) {
            if("eq".equalsIgnoreCase(searchFilter.getEqualType())) {
                criteria.add(Restrictions.eq(searchFilter.getPropertyName(),searchFilter.getValue()));
            } else if("like".equalsIgnoreCase(searchFilter.getEqualType())) {
                criteria.add(Restrictions.like(searchFilter.getPropertyName(),searchFilter.getValue().toString(), MatchMode.ANYWHERE));
            } else if("gt".equals(searchFilter.getEqualType())) {
                criteria.add(Restrictions.gt(searchFilter.getPropertyName(),searchFilter.getValue()));
            } else if("lt".equals(searchFilter.getEqualType())) {
                criteria.add(Restrictions.lt(searchFilter.getPropertyName(),searchFilter.getValue()));
            } else if("ge".equals(searchFilter.getEqualType())) {
                criteria.add(Restrictions.ge(searchFilter.getPropertyName(),searchFilter.getValue()));
            } else if("le".equals(searchFilter.getEqualType())) {
                criteria.add(Restrictions.le(searchFilter.getPropertyName(),searchFilter.getValue()));
            }
        }
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

    public Long count() {
        Criteria criteria = getSession().createCriteria(clazz);
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }


}
