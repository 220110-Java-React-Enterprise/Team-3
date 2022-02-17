package com.revature.project2.models;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Jason, Shabana
 * User POJO
 */
@Entity
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column
    private String username;

    @Column
    private String password;

    @Column(name = "is_admin")
    private Boolean isAdmin;

    @Column
    @OneToMany
    private List<Review> reviews = new LinkedList<>();;

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}
