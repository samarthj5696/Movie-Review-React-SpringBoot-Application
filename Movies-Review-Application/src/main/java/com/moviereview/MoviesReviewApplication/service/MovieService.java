package com.moviereview.MoviesReviewApplication.service;

import com.moviereview.MoviesReviewApplication.model.Movies;
import com.moviereview.MoviesReviewApplication.repository.MovieRespository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {


    @Autowired
    private MovieRespository movieRespository;

//    public MovieService(MovieRespository movieRespository) {
//        this.movieRespository = movieRespository;
//    }

    public List<Movies> getAllMovies(){
//        System.out.println(movieRespository.findAll());
        System.out.println("getAllmovies Called");
        return movieRespository.findAll();
    }
     public Optional<Movies> getMovieById(String id){
//        List<Movies>AllMovies=movieRespository.findAll();
//        ObjectId Id=AllMovies.get(0).getId();
//        for(int i=0;i<AllMovies.size();i++){
//            if(id==AllMovies.get(i).getImdbId()){
//                Id=AllMovies.get(i).getId();
//            }
//        }
        return movieRespository.findMoviesByImdbId(id);
     }
}
