package com.revature.project2;

import com.revature.project2.api.GameAPI;
import com.revature.project2.models.Game;
import com.revature.project2.repo.GameRepo;
import com.revature.project2.utilities.ApplicationContextProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class Project2Application {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Project2Application.class, args);
//		ApplicationContext context = ApplicationContextProvider.getApplicationContext();
//		GameRepo gameRepo = context.getBean(GameRepo.class);
//
//		List<Game> list = GameAPI.getAllGames();
//		for(Game game : list) {
//			gameRepo.save(game);
//		}
	}


}
