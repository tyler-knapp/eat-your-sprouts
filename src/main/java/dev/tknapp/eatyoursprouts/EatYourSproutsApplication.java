package dev.tknapp.eatyoursprouts;

import javax.sql.DataSource;

import dev.tknapp.eatyoursprouts.account.Account;
import dev.tknapp.eatyoursprouts.inventory.FileInventoryReader;
import dev.tknapp.eatyoursprouts.items.ItemDAO;
import dev.tknapp.eatyoursprouts.items.JDBCItemDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.*;

@SpringBootApplication
public class EatYourSproutsApplication{
	private Account account;
	
	private FileInventoryReader fileInventoryReader;
	
	private ItemDAO itemDAO;
	
	private Menu menu;
	
	public EatYourSproutsApplication(DataSource datasource){
		itemDAO = new JDBCItemDAOImpl(datasource);
		this.menu = new Menu();
		this.fileInventoryReader = new FileInventoryReader();
		this.account = new Account();
	}

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(EatYourSproutsApplication.class, args);
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5433/eatyoursprouts");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		EatYourSproutsApplication application = new EatYourSproutsApplication(dataSource);
		application.run();
	}
	
	public void run() throws FileNotFoundException {
		menu.showWelcomeMessage();
		while(true){
			
			menu.displayMainMenuOptions();
			String mainMenuUserOption = menu.getUserInput().toLowerCase();
			
			while(true){
				if(!mainMenuUserOption.equals("a") && !mainMenuUserOption.equals("b") && !mainMenuUserOption.equals("c")){
					System.out.println("Please enter a valid option");
					break;
				}
				if(mainMenuUserOption.equals("a")){
					
					menu.displayInventoryMenuOptions();
					String inventoryMenuUserOption = menu.getUserInput().toLowerCase();
					
					if(!inventoryMenuUserOption.equals("a") && !inventoryMenuUserOption.equals("b")){
						System.out.println("Please enter a valid option");
					}
					if(inventoryMenuUserOption.equals("a")){
						menu.displayInventoryList(fileInventoryReader);
					}
					if(inventoryMenuUserOption.equals("b")){
						break;
					}
				}
				if(mainMenuUserOption.equals("b")){
					menu.displayAccountMenu(account);
					String accountUserInput = menu.getUserInput().toLowerCase();
					if(!accountUserInput.equals("a") && !accountUserInput.equals("b") && !accountUserInput.equals("c")){
						System.out.println("Please enter a valid option");
					}
					if(accountUserInput.equals("a")){
						menu.accountAtAGlance(account);
						menu.addMoneyToAccountScreen();
						try{
							account.addFundsToAccount(menu.convertUserInputToADouble(menu.getUserInput()));
						} catch (NumberFormatException e){
							System.out.println("Invalid amount " + e.getMessage());
							System.out.println("Please enter a numeric value");
						}
					}
					if(accountUserInput.equals("b")){
						menu.accountAtAGlance(account);
						menu.withdrawMoneyFromAccountScreen();
						try{
							account.withdrawMoneyFromAccount(menu.convertUserInputToADouble(menu.getUserInput()));
						} catch (NumberFormatException e){
							System.out.println("Invalid amount " + e.getMessage());
							System.out.println("Please enter a numeric value");
						}
					}
					if(accountUserInput.equals("c")){
						break;
					}
				}
				if(mainMenuUserOption.equals("c")){
					System.exit(0);
				}
			}
		}
	}
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
//		menu.run();


	
//	@Override
//	public void run(String... args) throws Exception {
//		String sql = "INSERT INTO items(name, code, type, price, quantity) " +
//				"VALUES('Asparagus', 'S4', 'S', 1.79, 50)";
//				int rows = jdbcTemplate.update(sql);
//		if(rows > 0){
//			System.out.println("A new row has been inserted");
//		}
//
//	}
}
