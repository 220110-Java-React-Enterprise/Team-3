package com.revature.project2.controllers;

import com.revature.project2.exceptions.ReviewNotFoundException;
import com.revature.project2.models.Review;
import com.revature.project2.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @Author Jason, Shabana
 */
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewRepo reviewRepo;

    @Autowired
    public ReviewController(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @RequestMapping(value = "/{reviewId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Review getReviewsById(@PathVariable int ref_id) throws ReviewNotFoundException {
        Review result = null;
        Optional<Review> optionalReview = reviewRepo.findById(ref_id);
        if (optionalReview.isPresent())
            result = optionalReview.get();
        else
            throw new ReviewNotFoundException("Review " + ref_id + " Not Found!");

        return result;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    @RequestMapping(value = "/{reviewId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateReview(@RequestBody Review review, @PathVariable int ref_id) {
        reviewRepo.save(review);
    }

    @RequestMapping(value = "/{reviewId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteReview(@PathVariable Review review) {
            Optional<Review> optionalReview = reviewRepo.findById(review.getRefId());
            reviewRepo.delete(review);
    }
}





