package com.kaishengit.action;

import com.kaishengit.pojo.Movie;
import com.kaishengit.service.MovieService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import javax.inject.Inject;
import java.util.List;

@Namespace("/movie")
public class MovieAction {

    @Inject
    private MovieService movieService;

    private List<Movie> movies;
    private Movie movie;
    private Integer id;

    @Action("home")
    public String home() {
        movies = movieService.findAllMovie();
        return "success";
    }

    @Action("add")
    public String add() {
        return "success";
    }

    @Action(value = "save",results = {
            @Result(type = "redirectAction",params = {"actionName","home","namespace","/movie"})
    })
    public String save() {
        movieService.saveNewMovie(movie);
        return "success";
    }

    @Action("edit")
    public String edit() {
        movie = movieService.findMovieById(id);
        return "success";
    }

    @Action(value = "update",results = {
            @Result(type = "redirectAction",params = {"actionName","home","namespace","/movie"})
    })
    public String update() {
        movieService.updateMovie(movie);
        return "success";
    }

    @Action(value = "del",results = {
            @Result(type = "redirectAction",params = {"actionName","home","namespace","/movie"})
    })
    public String del() {
        movieService.delMovie(id);
        return "success";
    }

    //get set


    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
