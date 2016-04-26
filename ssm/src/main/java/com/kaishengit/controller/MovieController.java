package com.kaishengit.controller;

import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.Actor;
import com.kaishengit.pojo.Movie;
import com.kaishengit.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Inject
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<Movie> movieList = movieService.findAllMovie();
        model.addAttribute("movieList",movieList);
        return "movie/list";
    }

    @RequestMapping(value = "/{id:\\d+}",method = RequestMethod.GET)
    public String viewMovie(@PathVariable Integer id,Model model) {

        Movie movie = movieService.findMovieById(id);
        if(movie == null) {
            throw new NotFoundException();
        }

        List<Actor> actorList = movieService.findActorByMovieId(id);
        model.addAttribute("movie",movie);
        model.addAttribute("actorList",actorList);
        return "movie/show";
    }


    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String newMovie() {
        return "movie/new";
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String newMovie(Movie movie, String actors, RedirectAttributes redirectAttributes) {
        movieService.newMovie(movie,actors);
        redirectAttributes.addFlashAttribute("message","新增成功");
        return "redirect:/movie";
    }

    @RequestMapping(value = "/del/{id:\\d+}",method = RequestMethod.GET)
    public String delMovie(@PathVariable Integer id,RedirectAttributes redirectAttributes) {
        movieService.delMovieById(id);
        redirectAttributes.addFlashAttribute("message","删除成功");
        return "redirect:/movie";
    }

    @RequestMapping(value = "/edit/{id:\\d+}",method = RequestMethod.GET)
    public String editMovie(@PathVariable Integer id,Model model) {
        Movie movie = movieService.findMovieById(id);
        if(movie == null) {
            throw new NotFoundException();
        }

        List<Actor> actorList = movieService.findActorByMovieId(id);
        StringBuilder actorNames = new StringBuilder();
        for(Actor actor : actorList) {
            actorNames.append(actor.getName()).append(",");
        }
        String str = actorNames.toString();
        if(str.endsWith(",")) {
            str = str.substring(0,str.length()-1);
        }

        model.addAttribute("movie",movie);
        model.addAttribute("actorList",str);
        return "movie/edit";
    }

    @RequestMapping(value = "/edit/{id:\\d+}",method = RequestMethod.POST)
    public String editMovie(Movie movie,String actors,RedirectAttributes redirectAttributes) {
        movieService.editMovie(movie,actors);

        redirectAttributes.addFlashAttribute("message","编辑成功");
        return "redirect:/movie/"+movie.getId();
    }



}
