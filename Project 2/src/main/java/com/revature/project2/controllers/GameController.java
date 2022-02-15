package com.revature.project2.controllers;

import com.revature.project2.models.Game;
import com.revature.project2.repo.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public Game getGameById(@PathVariable Integer gameId) throws Exception {
        Optional<Game> optionalGame = gameRepo.findById(gameId);
        if (optionalGame.isPresent()) {
            return optionalGame.get();
        } else {
            throw new Exception("Game " + gameId + " Not Found!");
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
}
