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
        return movieDao.findAllOrder("id","desc");
    }

    public void saveNewMovie(Movie movie) {
        movieDao.save(movie);
    }

    public Movie findMovieById(Integer id) {
        return movieDao.findById(id);
    }

    public void updateMovie(Movie movie) {
        movieDao.save(movie);
    }

    public void delMovie(Integer id) {
        movieDao.del(id);
    }
}
