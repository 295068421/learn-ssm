package com.kaishengit.action;

import com.kaishengit.pojo.Movie;
import com.kaishengit.service.MovieService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import javax.inject.Inject;
import java.util.List;

@Namespace("/movie")
public class MovieAction {

    @Inject
    private MovieService movieService;

    private List<Movie> movies;

    @Action("home")
    public String home() {
        movies = movieService.findAllMovie();
        return "success";
    }

    //get set


    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
