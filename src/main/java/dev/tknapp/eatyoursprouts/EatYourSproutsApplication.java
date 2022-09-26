package dev.tknapp.eatyoursprouts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class EatYourSproutsApplication {
	
	static Menu menu = new Menu();

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(EatYourSproutsApplication.class, args);
		menu.run();
	}

}
