package com.kaishengit.action;

import com.kaishengit.pojo.Movie;
import com.kaishengit.service.MovieService;
import com.kaishengit.util.Page;
import com.kaishengit.util.SearchFilter;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import javax.inject.Inject;
import java.util.List;

@Namespace("/movie")
public class MovieAction extends BaseAction {

    @Inject
    private MovieService movieService;

    private List<Movie> movies;
    private Page<Movie> page;
    private Movie movie;
    private Integer id;
    private String p;

    @Action("home")
    public String home() {
        int pageNo = 1;
        if(StringUtils.isNumeric(p)) {
            pageNo = Integer.parseInt(p);
        }
        List<SearchFilter> searchFilters = SearchFilter.builderSearchFilter(getHttpRequest());

        //movies = movieService.findMoveBySearchFilter(searchFilters);
        page = movieService.findPageBySearchFilterAndPageNo(searchFilters,pageNo);

        //movies = movieService.findAllMovie();
        //page = movieService.findPageByPageNo(pageNo);
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

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public Page<Movie> getPage() {
        return page;
    }

    public void setPage(Page<Movie> page) {
        this.page = page;
    }
}
