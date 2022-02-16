package com.revature.project2.models;

import javax.persistence.*;

/**
 * @Author Jason, Shabana
 * Review POJO
 */
@Entity
public class Review {

    @Id
    @Column(name = "ref_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer refId;

    @ManyToOne
    @JoinColumn(name="game_id")
    private Game gameId;

    @Column
    private String review;

    @Column
    private Integer rating;

    public Review() {
    }

    public Integer getRefId() {
        return refId;
    }

    public void setRefId(Integer refId) {
        this.refId = refId;
    }

    public Game getGameId() {
        return gameId;
    }

    public void setGameId(Game gameId) {
        this.gameId = gameId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
