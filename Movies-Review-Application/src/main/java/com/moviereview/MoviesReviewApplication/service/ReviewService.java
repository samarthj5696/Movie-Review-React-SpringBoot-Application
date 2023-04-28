package com.moviereview.MoviesReviewApplication.service;

import com.moviereview.MoviesReviewApplication.model.Movies;
import com.moviereview.MoviesReviewApplication.model.Review;
import com.moviereview.MoviesReviewApplication.repository.ReviewRepositiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import java.time.LocalDateTime;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepositiory repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId) {
        Review review = repository.insert(new Review(reviewBody, LocalDateTime.now(), LocalDateTime.now()));

        mongoTemplate.update(Movies.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviews").value(review))
                .first();

        return review;
    }
}
