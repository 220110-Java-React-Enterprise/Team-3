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
    private Integer gameId;

    @Column
    private String name;

    @Column
    private LocalDate released;

    @Column(name = "background_image")
    private String backgroundImage;

    @Column(name = "meta_critic")
    private Integer metacritic;

    @Column
    private String platforms;

    @Column
    private String genres;

    @Column
    private String tags;

    @Column(name = "esrb_rating")
    private String esrbRating;

    @Column
    private String screenshots;

    public Game(){}

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
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

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(String esrbRating) {
        this.esrbRating = esrbRating;
    }

    public String getScreenshots() {
        return screenshots;
    }

    public void setScreenshots(String screenshots) {
        this.screenshots = screenshots;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", name='" + name + '\'' +
                ", released=" + released +
                ", backgroundImage='" + backgroundImage + '\'' +
                ", metacritic=" + metacritic +
                ", platforms='" + platforms + '\'' +
                ", genres='" + genres + '\'' +
                ", tags='" + tags + '\'' +
                ", esrbRating='" + esrbRating + '\'' +
                ", screenshots='" + screenshots + '\'' +
                '}';
    }
}
