package com.revature.project2.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Author Trevor, Jeffrey, CJ
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameList {

    private Game[] games;

    public GameList() {
    }

    public Game[] getGames() {
        return games;
    }

    public void setGames(Game[] games) {
        this.games = games;
    }
}
