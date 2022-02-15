package controllers;

import models.Review;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import repo.ReviewRepo;
import repo.UserRepo;

import java.util.List;
import java.util.Optional;

/**
 * @Author Jason, Shabana
 */
//class needs exception handling
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



    @RequestMapping(value = "/{userId}",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void newReviewOfGameForUser(@RequestBody Review review){
        reviewRepo.save(review);


    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Review> getAllReviewsForUser(@PathVariable int user_id){
        List<Review> result = null;
        Optional<Review> optionalReview = reviewRepo.findById(user_id);
        //ask around about how this one is supposed to
        //maybe some kind of while statement?
        if(optionalReview.isPresent())
            result.add(optionalReview.get());

        return result;
    }

    @RequestMapping(value = "/{accountId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateReview(@RequestBody Review review, @PathVariable int ref_id){
        reviewRepo.save(review);
    }

    @RequestMapping(value = "/{accountId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteReview(@PathVariable int ref_id, Review review){

            Optional<Review> optionalReview = reviewRepo.findById(review.getRef_id());
            reviewRepo.delete(review);
        }

    }



