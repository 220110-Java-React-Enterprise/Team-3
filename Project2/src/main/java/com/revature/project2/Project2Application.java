package com.revature.project2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class Project2Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Project2Application.class, args);
//		test();
//		ApplicationContext context = ApplicationContextProvider.getApplicationContext();
//		GameRepo gameRepo = context.getBean(GameRepo.class);
//
//		List<Game> list = GameAPI.getAllGames();
//		for(Game game : list) {
//			gameRepo.save(game);
//		}
	}

	public static void test() throws FileNotFoundException {
		throw new FileNotFoundException();
	}

}
