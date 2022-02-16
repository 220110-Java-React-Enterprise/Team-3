package com.revature.project2.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

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
    private String slug;

    @Column
    private String name;

    @Column
    private String released;

    @Column(name = "background_image")
    private String backgroundImage;

    @Column
    private Integer rating;

    @Column
    private String platforms;

    @Column
    private String genres;

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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
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
                ", slug='" + slug + '\'' +
                ", name='" + name + '\'' +
                ", released='" + released + '\'' +
                ", backgroundImage='" + backgroundImage + '\'' +
                ", rating=" + rating +
                ", platforms='" + platforms + '\'' +
                ", genres='" + genres + '\'' +
                ", esrbRating='" + esrbRating + '\'' +
                ", screenshots='" + screenshots + '\'' +
                '}';
    }
}
