package com.kaishengit.service;

import com.kaishengit.dao.MovieDao;
import com.kaishengit.pojo.Movie;
import com.kaishengit.util.Page;
import com.kaishengit.util.SearchFilter;
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

    public Page<Movie> findPageByPageNo(Integer pageNo) {
        return movieDao.findPage(pageNo,10);
    }

    public List<Movie> findMoveBySearchFilter(List<SearchFilter> searchFilters) {
        return movieDao.findBySearchFilter(searchFilters);
    }
}
