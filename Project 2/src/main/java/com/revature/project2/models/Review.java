package com.revature.project2.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @Author Jason, Shabana
 */
@Entity
public class Review {

    @Id
    private int ref_id;

    @OneToOne
    private int game_id;

    @OneToOne
    private int user_id;

    @Column
    private String review;

    @Column
    private int rating;

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public int getRef_id() {
        return ref_id;
    }

    public void setRef_id(int ref_id) {
        this.ref_id = ref_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Review() {
    }

    public Review(int game_id, int ref_id, int user_id, String review, int rating) {
        this.game_id = game_id;
        this.ref_id = ref_id;
        this.user_id = user_id;
        this.review = review;
        this.rating = rating;
    }
}
