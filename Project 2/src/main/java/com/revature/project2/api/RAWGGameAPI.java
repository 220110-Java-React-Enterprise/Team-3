package com.revature.project2.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RAWGGameAPI {

    public static void main(String[] args) throws JsonProcessingException {
        RestTemplate rest = new RestTemplate();
        String resourceUrl = "";
        ResponseEntity<String> response = rest.getForEntity(resourceUrl, String.class);
//        ObjectMapper mapper = new ObjectMapper();
//        GameList list = mapper.readValue(response.toString(), GameList.class);
//        for (Game game : list.getResults()) {
//            System.out.println(game);
//        }
        System.out.println(response.toString());

    }
}