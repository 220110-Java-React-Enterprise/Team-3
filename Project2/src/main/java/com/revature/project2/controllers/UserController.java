package com.revature.project2.controllers;

import com.revature.project2.exceptions.UserNotFoundException;
import com.revature.project2.models.Review;
import com.revature.project2.models.User;
import com.revature.project2.repo.ReviewRepo;
import com.revature.project2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.caseSensitive;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

/**
 * @Author Jason, Shabana
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepo userRepo;
    private final ReviewRepo reviewRepo;

    @Autowired
    public UserController(UserRepo userRepo, ReviewRepo reviewRepo) {
        this.userRepo = userRepo;
        this.reviewRepo = reviewRepo;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void newUser(@RequestBody User user){
        userRepo.save(user);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable Integer userId) throws UserNotFoundException {
        User result = null;
        Optional<User> optionalUser = userRepo.findById(userId);
        if(optionalUser.isPresent()) {
            result = optionalUser.get();
        } else {
            throw new UserNotFoundException("User " + userId + " Not Found!");
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateUser(@RequestBody User user) {
        userRepo.save(user);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@RequestBody User user) {
        Optional<User> optionalUser = userRepo.findById(user.getUserId());
        userRepo.delete(user);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public User validateUser(@RequestBody User user) {
        ExampleMatcher em = ExampleMatcher.matching().withIgnorePaths("user_id")
                .withMatcher("username", ignoreCase()).withMatcher("password", caseSensitive());
        Example<User> example = Example.of(user, em);
        boolean exists = userRepo.exists(example);

        if(exists) {
            Optional<User> optionalUser = userRepo.findOne(example);
            return optionalUser.get();
        }
        return user;
    }

    @RequestMapping(value = "/friends/{userId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<User> getFriends(@PathVariable Integer userId) throws UserNotFoundException {
        List<User> result = new LinkedList<>();
        User user;
        Optional<User> optionalUser = userRepo.findById(userId);
        if(optionalUser.isPresent()) {
            user = optionalUser.get();
            result = user.getFriends();
        }
        else {
            throw new UserNotFoundException("User " + userId + " Not Found!");
        }
        return result;
    }

    @RequestMapping(value = "/friends/{userId}/{friendId}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean addFriend(@PathVariable Integer userId, @PathVariable Integer friendId) throws UserNotFoundException {
        List<User> friends = new LinkedList<>();
        User user, friend;
        Optional<User> optionalUser = userRepo.findById(userId);
        Optional<User> optionalFriend = userRepo.findById(friendId);
        if(optionalUser.isPresent() && optionalFriend.isPresent()) {
            user = optionalUser.get();
            friend = optionalFriend.get();
            friends = user.getFriends();
        }
        else {
            throw new UserNotFoundException("User " + userId + " Not Found!");
        }

        if(friends.contains(friend)) {
            return false;
        }
        friends.add(friend);
        user.setFriends(friends);
        userRepo.save(user);
        return true;
    }

    @RequestMapping(value = "/reviews/{userId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Review> getUserReviews(@PathVariable Integer userId) throws UserNotFoundException {
        List<Review> result;
        User user;
        Optional<User> optionalUser = userRepo.findById(userId);
        if(optionalUser.isPresent()) {
            user = optionalUser.get();
            result = user.getReviews();
        } else {
            throw new UserNotFoundException("User " + userId + " Not Found!");
        }
        return result;
    }

    @RequestMapping(value = "/reviews/{userId}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void newUserReview(@PathVariable Integer userId, @RequestBody Review review) throws UserNotFoundException {
        User user = null;
        Optional<User> optionalUser = userRepo.findById(userId);
        if(optionalUser.isPresent()) {
            user = optionalUser.get();
            user.getReviews().add(reviewRepo.save(review));
            userRepo.save(user);
        } else {
            throw new UserNotFoundException("User " + userId + " Not Found!");
        }
    }
}
