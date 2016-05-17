package com.kaishengit.dao;

import com.kaishengit.pojo.Movie;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
        return criteria.list();
    }

}
