package com.kaishengit.service;

import com.kaishengit.mapper.ActorMapper;
import com.kaishengit.mapper.MovieMapper;
import com.kaishengit.pojo.Actor;
import com.kaishengit.pojo.Movie;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Transactional
public class MovieService {

    @Inject
    private MovieMapper movieMapper;
    @Inject
    private ActorMapper actorMapper;

    @Transactional(readOnly = true)
    public List<Movie> findAllMovie() {
        return movieMapper.findAll();
    }
    @Transactional(readOnly = true)
    public Movie findMovieById(Integer id) {
        return movieMapper.findById(id);
    }
    @Transactional(readOnly = true)
    public List<Actor> findActorByMovieId(Integer id) {
        return actorMapper.findByMovieId(id);
    }

    public void newMovie(Movie movie, String actors) {
        //保存电影
        movieMapper.save(movie);

        actors = actors.replace("，",",");
        String[] actorNames = actors.split(",");
        for(String actorName : actorNames) {
            Actor actor = actorMapper.findByName(actorName);
            if(actor == null) {
                actor = new Actor();
                actor.setName(actorName);
                actorMapper.save(actor);
            }
            //保存电影和演员的关系
            movieMapper.saveMovieAndActor(movie,actor);
        }
    }

    public void delMovieById(Integer id) {
        movieMapper.del(id);
    }

    public void editMovie(Movie movie, String actors) {
        movieMapper.update(movie);

        //删除原有的电影和演员的关系，然后重建关系
        movieMapper.delMovieActor(movie);

        actors = actors.replace("，",",");
        String[] actorNames = actors.split(",");
        for(String actorName : actorNames) {
            Actor actor = actorMapper.findByName(actorName);
            if(actor == null) {
                actor = new Actor();
                actor.setName(actorName);
                actorMapper.save(actor);
            }
            //保存电影和演员的关系
            movieMapper.saveMovieAndActor(movie,actor);
        }
    }
}
