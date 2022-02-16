package com.revature.project2.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project2.dtos.*;
import com.revature.project2.models.Game;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringJoiner;

/**
 * @Author Trevor, Jeffrey, CJ
 * Service class for connecting to the RAWG Video Game Database API
 */
public class GameAPI {

    public static void main(String[] args) throws IOException {
        getAllGames();
    }

    public static List<Game> getAllGames() throws IOException {
        List<Game> gameList = new ArrayList<>();

        // Read key and build url
        Properties props = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream input = loader.getResourceAsStream("api-key.properties");
        props.load(input);
        props.getProperty("api-key");

        StringBuilder sb = new StringBuilder("https://api.rawg.io/api/games");
        sb.append("?key=").append(props.getProperty("api-key"))
                .append("&page_size=100");
        String url = sb.toString();

        // Loop through all pages or first 25 pages
        int page = 0;
        while(url != null && page < 25) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            // Make API call and map results
            Response response = client.newCall(request).execute();
            ObjectMapper mapper = new ObjectMapper();
            ApiResponse apiResponse = mapper.readValue(response.body().string(), ApiResponse.class);
            List<Results> results = apiResponse.getResults();

            // Set next page
            url = apiResponse.getNext();

            // Convert DTOs into Game Objects for repository
            for(Results result : results) {
                Game game = new Game();

                game.setGameId(result.getId());
                game.setSlug(result.getSlug());
                game.setName(result.getName());
                game.setReleased(result.getReleased());
                game.setBackgroundImage(result.getBackground_image());
                game.setRating(result.getMetacritic());

                if(result.getEsrb_rating() != null) {
                    game.setEsrbRating(result.getEsrb_rating().getName());
                }

                StringJoiner sj = new StringJoiner(", ");
                for(Parent_Platforms p : result.getParent_platforms()) {
                    sj.add(p.getPlatform().getName());
                }
                game.setPlatforms(sj.toString());

                sj = new StringJoiner(", ");
                for(Genre g : result.getGenres()) {
                    sj.add(g.getName());
                }
                game.setGenres(sj.toString());

                sj = new StringJoiner(", ");
                for(Screenshots s : result.getShort_screenshots()) {
                    sj.add(s.getImage());
                }
                game.setScreenshots(sj.toString());

                gameList.add(game);
                System.out.println(game);
            }
            page++;
        }
        
        return gameList;
    }
}
