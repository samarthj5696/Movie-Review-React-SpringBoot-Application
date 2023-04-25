package com.moviereview.MoviesReviewApplication.service;

import com.moviereview.MoviesReviewApplication.model.Movies;
import com.moviereview.MoviesReviewApplication.model.Review;
import com.moviereview.MoviesReviewApplication.repository.ReviewRepositiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepositiory reviewRepositiory;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String ImdbId){
        Review review=reviewRepositiory.insert(new Review(reviewBody));
        mongoTemplate.update(Movies.class)
                .matching(Criteria.where("imdbId").is(ImdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();
        return review;
    }
}
