package com.moviereview.MoviesReviewApplication.controller;

import com.moviereview.MoviesReviewApplication.model.Movies;
import com.moviereview.MoviesReviewApplication.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/vi/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/all")
    public List<Movies> allMovies(){
        return  movieService.getAllMovies();
    }

    @GetMapping(value = "/{ImdbId}")
    public Optional<Movies> GetByImdbId(@PathVariable String ImdbId){
        System.out.println(movieService.getMovieById(ImdbId));
        return movieService.getMovieById(ImdbId);
    }
}
