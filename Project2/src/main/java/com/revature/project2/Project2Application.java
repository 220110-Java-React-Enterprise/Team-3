package com.revature.project2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Project2Application {

	public static void main(String[] args) throws Exception {
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
