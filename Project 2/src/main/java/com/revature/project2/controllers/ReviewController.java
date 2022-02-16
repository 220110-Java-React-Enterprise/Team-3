package com.revature.project2.controllers;

import com.revature.project2.models.Review;
import com.revature.project2.repo.ReviewRepo;
import com.revature.project2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @Author Jason, Shabana
 */
@RestController
@RequestMapping("/Review")
public class ReviewController {
    private final UserRepo userRepo;
    private final ReviewRepo reviewRepo;

    @Autowired
    public ReviewController(UserRepo userRepo, ReviewRepo reviewRepo) {
        this.userRepo = userRepo;
        this.reviewRepo = reviewRepo;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void newReviewOfGameForUser(@RequestBody Review review) {
        reviewRepo.save(review);


    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Review getReviewsById(@PathVariable int ref_id) throws Exception {
        Review result = null;
        Optional<Review> optionalReview = reviewRepo.findById(ref_id);
        if (optionalReview.isPresent())
            result = optionalReview.get();
        else
            throw new Exception("Review " + ref_id + " Not Found!");

        return result;
    }

    @RequestMapping(value = "/{accountId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public List<Review> getAllReviews(){
        List<Review> result=null;
        result = reviewRepo.findAll();
        return result;
    }

    @RequestMapping(value = "/{accountId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateReview(@RequestBody Review review, @PathVariable int ref_id) {
        reviewRepo.save(review);
    }
    @RequestMapping(value = "/{accountId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteReview(@PathVariable Review review){
            Optional<Review> optionalReview = reviewRepo.findById(review.getRefId());
            reviewRepo.delete(review);
        }
}





