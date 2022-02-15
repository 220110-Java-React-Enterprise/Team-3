package com.revature.project2.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    private GameList[] results;

    public Data() {
    }

    public GameList[] getResults() {
        return results;
    }

    public void setResults(GameList[] results) {
        this.results = results;
    }
}
