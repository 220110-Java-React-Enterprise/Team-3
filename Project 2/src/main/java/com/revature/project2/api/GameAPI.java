package com.revature.project2.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.revature.project2.models.Data;
import com.revature.project2.models.Game;
import com.revature.project2.models.GameList;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @Author Trevor, Jeffrey, CJ
 * Service class for connecting to the RAWG Video Game Database API
 */
public class GameAPI {

    public static void main(String[] args) throws IOException {
        // Setup the URL
        Scanner scan = new Scanner(new File("src/main/resources/api.properties"));
        String resourceUrl = "https://api.rawg.io/api/games" + scan.nextLine();

        RestTemplate rest = new RestTemplate();
        String response = rest.getForObject(resourceUrl, String.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        Data data = mapper.readValue(response, Data.class);
        for (Game game : data.getResults()[0].getGames()) {
            System.out.println(game);
        }

        //System.out.println(response);

    }
}