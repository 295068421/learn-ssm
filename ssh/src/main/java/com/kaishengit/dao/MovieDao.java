package com.kaishengit.dao;

import com.kaishengit.pojo.Movie;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class MovieDao {

    @Inject
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    public List<Movie> findAll() {
        Criteria criteria = getSession().createCriteria(Movie.class);
        criteria.addOrder(Order.desc("id"));
        criteria.setFirstResult(0);
        criteria.setMaxResults(10);
        return criteria.list();
    }

    public void save(Movie movie) {
        getSession().saveOrUpdate(movie);
    }

    public Movie findById(Integer id) {
        return (Movie) getSession().get(Movie.class,id);
    }

    public void del(Integer id) {
        getSession().delete(findById(id));
    }
}
