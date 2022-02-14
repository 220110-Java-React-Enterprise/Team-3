package com.revature.project2.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project2.Project2Application;
import com.revature.project2.models.Game;
import com.revature.project2.models.GameList;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RAWGGameAPI {

    public static void main(String[] args) throws JsonProcessingException {
        RestTemplate rest = new RestTemplate();
        String resourceUrl = "https://api.rawg.io/api/games?key=2a14caa2fcd34ff3bc75643080973f91";
        ResponseEntity<String> response = rest.getForEntity(resourceUrl, String.class);
//        ObjectMapper mapper = new ObjectMapper();
//        GameList list = mapper.readValue(response.toString(), GameList.class);
//        for (Game game : list.getResults()) {
//            System.out.println(game);
//        }
        System.out.println(response.toString());

    }
}