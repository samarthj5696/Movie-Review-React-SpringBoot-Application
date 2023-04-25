package com.moviereview.MoviesReviewApplication.repository;

import com.moviereview.MoviesReviewApplication.model.Movies;
import com.moviereview.MoviesReviewApplication.model.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepositiory extends MongoRepository<Review, ObjectId> {
}
