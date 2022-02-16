package com.revature.project2.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Screenshots {
    private Integer id;
    private String image;

    public Screenshots() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Screenshots{" +
                "id=" + id +
                ", image='" + image + '\'' +
                '}';
    }
}
