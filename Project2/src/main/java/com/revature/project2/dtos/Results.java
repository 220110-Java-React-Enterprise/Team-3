package com.revature.project2.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Results {
    private Integer id;
    private String slug;
    private String name;
    private String released;
    private Boolean tba;
    private String background_image;
    private Integer rating;
    private Integer rating_top;
    private Integer metacritic;
    private Parent_Platforms[] parent_platforms;
    private Genre[] genres;
    private EsrbRating esrb_rating;
    private Screenshots[] short_screenshots;

    public Results() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getTba() {
        return tba;
    }

    public void setTba(Boolean tba) {
        this.tba = tba;
    }

    public String getBackground_image() {
        return background_image;
    }

    public void setBackground_image(String background_image) {
        this.background_image = background_image;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getRating_top() {
        return rating_top;
    }

    public void setRating_top(Integer rating_top) {
        this.rating_top = rating_top;
    }

    public Integer getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(Integer metacritic) {
        this.metacritic = metacritic;
    }

    public Parent_Platforms[] getParent_platforms() {
        return parent_platforms;
    }

    public void setParent_platforms(Parent_Platforms[] parent_platforms) {
        this.parent_platforms = parent_platforms;
    }

    public Genre[] getGenres() {
        return genres;
    }

    public void setGenres(Genre[] genres) {
        this.genres = genres;
    }

    public EsrbRating getEsrb_rating() {
        return esrb_rating;
    }

    public void setEsrb_rating(EsrbRating esrb_rating) {
        this.esrb_rating = esrb_rating;
    }

    public Screenshots[] getShort_screenshots() {
        return short_screenshots;
    }

    public void setShort_screenshots(Screenshots[] short_screenshots) {
        this.short_screenshots = short_screenshots;
    }

    @Override
    public String toString() {
        return "Results{" +
                "id=" + id +
                ", slug='" + slug + '\'' +
                ", name='" + name + '\'' +
                ", released='" + released + '\'' +
                ", tba=" + tba +
                ", background_image='" + background_image + '\'' +
                ", rating=" + rating +
                ", rating_top=" + rating_top +
                ", metacritic=" + metacritic +
                ", parent_platforms=" + Arrays.toString(parent_platforms) +
                ", genres=" + Arrays.toString(genres) +
                ", esrb_rating=" + esrb_rating +
                ", short_screenshots=" + Arrays.toString(short_screenshots) +
                '}';
    }
}