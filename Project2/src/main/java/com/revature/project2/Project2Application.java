package com.revature.project2;

import com.revature.project2.controllers.Test;
import com.revature.project2.utilities.ApplicationContextProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class Project2Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Project2Application.class, args);

		ApplicationContext context = ApplicationContextProvider.getApplicationContext();
		Test t = context.getBean(Test.class);
		t.testMethod();

//		GameRepo gameRepo = context.getBean(GameRepo.class);
//
//		List<Game> list = GameAPI.getAllGames();
//		for(Game game : list) {
//			gameRepo.save(game);
//		}
	}
}
