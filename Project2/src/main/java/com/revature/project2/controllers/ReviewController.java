package com.revature.project2.controllers;

import com.revature.project2.exceptions.GameNotFoundException;
import com.revature.project2.exceptions.ReviewNotFoundException;
import com.revature.project2.models.Game;
import com.revature.project2.models.Review;
import com.revature.project2.repo.GameRepo;
import com.revature.project2.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @Author Jason, Shabana
 */
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewRepo reviewRepo;
    private final GameRepo gameRepo;

    @Autowired
    public ReviewController(ReviewRepo reviewRepo, GameRepo gameRepo) {
        this.reviewRepo = reviewRepo;
        this.gameRepo = gameRepo;
    }

    @RequestMapping(value = "/{reviewId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Review getReviewsById(@PathVariable Integer ref_id) throws ReviewNotFoundException {
        Review result = null;
        Optional<Review> optionalReview = reviewRepo.findById(ref_id);
        if(optionalReview.isPresent()) {
            result = optionalReview.get();
        } else {
            throw new ReviewNotFoundException("Review " + ref_id + " Not Found!");
        }
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

    @RequestMapping(value = "/game/{gameId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Review> getReviewsByGameId(@PathVariable Integer gameId) throws GameNotFoundException {
        List<Review> gameReviews;
        Optional<Game> optionalGame = gameRepo.findById(gameId);
        if(optionalGame.isPresent()) {
            Game game = optionalGame.get();
            gameReviews = reviewRepo.findByGameId(game);
        } else {
            throw new GameNotFoundException("Game " + gameId + " Not Found!");
        }
        return gameReviews;
    }
}





