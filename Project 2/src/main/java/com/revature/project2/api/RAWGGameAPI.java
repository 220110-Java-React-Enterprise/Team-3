package com.revature.project2.api;

import com.revature.project2.Project2Application;
import com.revature.project2.models.Game;
import org.springframework.boot.SpringApplication;
import org.springframework.web.client.RestTemplate;

public class RAWGGameAPI {

    public static void main(String[] args) {
        RestTemplate rest = new RestTemplate();
        String resourceUrl = "";
        Game model = rest.getForObject(resourceUrl + "/1", Game.class);
        System.out.println(model);
    }
}