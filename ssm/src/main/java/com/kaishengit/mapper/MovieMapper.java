package com.kaishengit.mapper;

import com.kaishengit.pojo.Actor;
import com.kaishengit.pojo.Movie;

import java.util.List;

public interface MovieMapper {

    List<Movie> findAll();

    Movie findById(Integer id);

    void save(Movie movie);

    void saveMovieAndActor(Movie movie, Actor actor);

    void del(Integer id);

    void update(Movie movie);

    void delMovieActor(Movie movie);
}
