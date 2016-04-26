package com.kaishengit.mapper;

import com.kaishengit.pojo.Actor;

import java.util.List;

public interface ActorMapper {

    List<Actor> findByMovieId(Integer movieId);

    Actor findByName(String actorName);

    void save(Actor actor);
}
