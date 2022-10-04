package dev.tknapp.eatyoursprouts.view;

import javax.sql.DataSource;

import dev.tknapp.eatyoursprouts.account.Account;
import dev.tknapp.eatyoursprouts.controller.HomeController;
import dev.tknapp.eatyoursprouts.inventory.FileInventoryReader;
import dev.tknapp.eatyoursprouts.items.ItemDAO;
import dev.tknapp.eatyoursprouts.items.JDBCItemDAOImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import java.io.FileNotFoundException;

@SpringBootApplication
@ComponentScan(basePackageClasses = HomeController.class)
public class EatYourSproutsApplication extends SpringBootServletInitializer {
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
		System.out.println("Server Started");
		BasicDataSource dataSource = new BasicDataSource();
		
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
}
