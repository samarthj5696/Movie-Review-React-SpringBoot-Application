package com.moviereview.MoviesReviewApplication.controller;

import com.moviereview.MoviesReviewApplication.model.Review;
import com.moviereview.MoviesReviewApplication.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/vi/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public Review createReview(@RequestBody Map<String,String> payload){
        return reviewService.createReview(payload.get("reviewBody"),payload.get("imdbId"));
    }
}
