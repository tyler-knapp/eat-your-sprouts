package dev.tknapp.eatyoursprouts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.*;

@SpringBootApplication
//@ComponentScan
public class EatYourSproutsApplication implements CommandLineRunner {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	static Menu menu = new Menu();

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(EatYourSproutsApplication.class, args);
//		String jdbcURL = "jdbc:postgresql://localhost:5433/eatyoursprouts";
//		String username = "postgres";
//		String password = "postgres1";
		
//		try{
//			Connection conn = DriverManager.getConnection(jdbcURL, username, password);
//			System.out.println("Connected to PostgresSQL server");
//
////			String sql = "INSERT INTO items(name, type, price, code, quantity)"
////					+ " VALUES(? , ? , ? , ? , ?)";
////
////			PreparedStatement statement = conn.prepareStatement(sql);
////			statement.setString(1, "Broccoli");
////			statement.setString(2, "S");
////			statement.setBigDecimal(3, BigDecimal.valueOf(1.50));
////			statement.setString(4, "S2");
////			statement.setInt(5, 50);
////
////			int rows = statement.executeUpdate();
////
////			if(rows > 0){
////				System.out.println("A new item has been inserted");
////			}
//
//			String sql = "SELECT * FROM items";
//
//			Statement statement = conn.createStatement();
//
//			ResultSet result = statement.executeQuery(sql);
//
//			while(result.next()){
//				int id = result.getInt("id");
//				String name = result.getString("name");
//				String type = result.getString("type");
//				double price = result.getDouble("price");
//				String code = result.getString("code");
//				int quantity = result.getInt("quantity");
//
//				System.out.printf("%d - %s - %s - %s - %,.2f - %d\n", id, name, code, type, price, quantity);
//			}
//			conn.close();
//		} catch (SQLException e){
//			System.out.println("Error in connecting to PostgresSQL server");
//			e.printStackTrace();
//		}
		menu.run();
	}
	
	@Override
	public void run(String... args) throws Exception {
		String sql = "INSERT INTO items(name, code, type, price, quantity) " +
				"VALUES('Asparagus', 'S4', 'S', 1.79, 50)";
				int rows = jdbcTemplate.update(sql);
		if(rows > 0){
			System.out.println("A new row has been inserted");
		}
		
	}
}
