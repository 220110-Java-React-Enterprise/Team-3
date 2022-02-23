package com.revature.project2.controllers;

import com.revature.project2.exceptions.GameNotFoundException;
import com.revature.project2.models.Game;
import com.revature.project2.repo.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @Author Trevor, Jeffrey, CJ
 */
@RestController
@RequestMapping("/games")
public class GameController {
    public final GameRepo gameRepo;

    @Autowired
    GameController(GameRepo gameRepo) {
        this.gameRepo = gameRepo;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void newGame(@RequestBody Game game) {
        gameRepo.save(game);
    }

    @RequestMapping(value = "/{gameId}")
    @ResponseStatus(HttpStatus.OK)
    public Game getGameById(@PathVariable Integer gameId) throws GameNotFoundException {
        Optional<Game> optionalGame = gameRepo.findById(gameId);
        if (optionalGame.isPresent()) {
            return optionalGame.get();
        } else {
            throw new GameNotFoundException("Game " + gameId + " Not Found!");
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateGame(@RequestBody Game game) {
        gameRepo.save(game);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteGame(@RequestBody Game game) {
        Optional<Game> optionalGame = gameRepo.findById(game.getGameId());
        gameRepo.delete(game);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAllGames() {
        return gameRepo.findAll();
    }

    @RequestMapping(value = "/search/{query}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGameByName(@PathVariable String query) throws GameNotFoundException {
       return gameRepo.findByNameContainingIgnoreCase(query);
    }
}