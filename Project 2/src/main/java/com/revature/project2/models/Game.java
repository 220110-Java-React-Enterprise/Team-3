package com.revature.project2.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * @Author Trevor, Jeffrey, CJ
 * Game POJO
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Game {

    @Id
    @Column(name = "game_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gameID;

    @Column
    private String name;

    @Column
    private LocalDate released;

    @Column(name = "background_image")
    private String backgroundImage;

    @Column(name = "meta_critic")
    private Integer metacritic;

    @Column
    private List<String> platforms;

    @Column
    private List<String> genres;

    @Column
    private List<String> tags;

    @Column(name = "esrb_rating")
    private String esrbRating;

    @Column
    private List<String> screenshots;

    public Game(){}

    public Game(Integer gameID, String name, LocalDate released, String backgroundImage, Integer metacritic, List<String> platforms, List<String> genres, List<String> tags, String esrbRating, List<String> screenshots) {
        this.gameID = gameID;
        this.name = name;
        this.released = released;
        this.backgroundImage = backgroundImage;
        this.metacritic = metacritic;
        this.platforms = platforms;
        this.genres = genres;
        this.tags = tags;
        this.esrbRating = esrbRating;
        this.screenshots = screenshots;
    }

    public Integer getGameID() {
        return gameID;
    }

    public void setGameID(Integer gameID) {
        this.gameID = gameID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getReleased() {
        return released;
    }

    public void setReleased(LocalDate released) {
        this.released = released;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public Integer getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(Integer metacritic) {
        this.metacritic = metacritic;
    }

    public List<String> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<String> platforms) {
        this.platforms = platforms;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(String esrbRating) {
        this.esrbRating = esrbRating;
    }

    public List<String> getScreenshots() {
        return screenshots;
    }

    public void setScreenshots(List<String> screenshots) {
        this.screenshots = screenshots;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameID=" + gameID +
                ", name='" + name + '\'' +
                ", released=" + released +
                ", backgroundImage='" + backgroundImage + '\'' +
                ", metacritic=" + metacritic +
                ", platforms=" + platforms +
                ", genres=" + genres +
                ", tags=" + tags +
                ", esrbRating='" + esrbRating + '\'' +
                ", screenshots=" + screenshots +
                '}';
    }
}
