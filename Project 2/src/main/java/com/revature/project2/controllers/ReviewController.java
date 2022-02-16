package com.revature.project2.controllers;

import com.revature.project2.models.Review;
import com.revature.project2.repo.ReviewRepo;
import com.revature.project2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        //should I be writing logic checks in here?

    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Review> getAllReviewsForUser(@PathVariable int user_id) {
        List<Review> result = null;
        //code to get all reviews

        return result;
    }

    @RequestMapping(value = "/{accountId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateReview(@RequestBody Review review, @PathVariable int ref_id) {

        //code to update account

    }

    @RequestMapping(value = "/{accountId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteReview(@PathVariable int ref_id) {

        //code to delete account

    }
    
}



