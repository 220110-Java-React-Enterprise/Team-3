package com.revature.project2.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Author Trevor, Jeffrey, CJ
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameList {

    private Game[] results;

    public GameList() {
    }

    public GameList(Game[] results) {
        this.results = results;
    }

    public Game[] getResults() {
        return results;
    }

    public void setResults(Game[] results) {
        this.results = results;
    }
}
