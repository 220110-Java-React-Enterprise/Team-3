package controllers;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import repo.ReviewRepo;
import repo.UserRepo;
import java.util.Optional;

/**
 * @Author Jason, Shabana
 */

@RestController
@RequestMapping("/User")
public class UserController {
    private final UserRepo userRepo;
    private final ReviewRepo reviewRepo;


    @Autowired
    public UserController(UserRepo userRepo, ReviewRepo reviewRepo) {
        this.userRepo = userRepo;
        this.reviewRepo = reviewRepo;
    }


    @RequestMapping(value = "/{userId}",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void newUser(@RequestBody User user){
        userRepo.save(user);
    }

    @RequestMapping(value = "/{userId}")
    public User getUserById(@PathVariable Integer userId){
        Optional<User> optionalUser = userRepo.findById(userId);
            return optionalUser.get();
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateUser(@RequestBody User user) {
        userRepo.save(user);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@RequestBody User user) {
        Optional<User> optionalUser = userRepo.findById(user.getUser_id());
        userRepo.delete(user);
        //add in code to delete all reviews this person has
    }

    //add in exception handling logging stuff

}
