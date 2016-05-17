package com.kaishengit.service;

import com.kaishengit.dao.MovieDao;
import com.kaishengit.pojo.Movie;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Transactional
public class MovieService {
    @Inject
    private MovieDao movieDao;

    @Transactional(readOnly = true)
    public List<Movie> findAllMovie() {
        return movieDao.findAll();
    }

}
