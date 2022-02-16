package com.revature.project2.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class EsrbRating {
    private Integer id;
    private String slug;
    private String name;

    public EsrbRating() {
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

    @Override
    public String toString() {
        return "EsrbRating{" +
                "\nid=" + id +
                ", \nslug='" + slug + '\'' +
                ", \nname='" + name + '\'' +
                "}\n";
    }
}