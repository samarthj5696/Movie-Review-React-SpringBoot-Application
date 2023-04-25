package com.moviereview.MoviesReviewApplication.repository;

import com.moviereview.MoviesReviewApplication.model.Movies;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRespository extends MongoRepository<Movies, ObjectId> {
    Optional<Movies> findMoviesByImdbId(String imdbId);
}
