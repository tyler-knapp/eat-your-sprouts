package dev.tknapp.eatyoursprouts;

import dev.tknapp.eatyoursprouts.account.Account;
import dev.tknapp.eatyoursprouts.inventory.FileInventoryReader;
import dev.tknapp.eatyoursprouts.items.Items;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    
    private final Account account = new Account();
    private static final Scanner scanner = new Scanner(System.in);
    
    FileInventoryReader fileInventoryReader = new FileInventoryReader();
    
    
     public void showWelcomeMessage(){
         System.out.println();
         System.out.println("*******************************************");
         System.out.println("******  Welcome to Eat Your Sprouts  ******");
         System.out.println("*******************************************");
         System.out.println();
     }
    
    public void run() throws FileNotFoundException {
        showWelcomeMessage();
        menuCLI();
    }
     
     public void menuCLI() throws FileNotFoundException {
        while(true){
    
        displayMainMenuOptions();
        String mainMenuUserOption = getUserInput().toLowerCase();
    
        while(true){
            if(!mainMenuUserOption.equals("a") && !mainMenuUserOption.equals("b") && !mainMenuUserOption.equals("c")){
                System.out.println("Please enter a valid option");
                break;
            }
            if(mainMenuUserOption.equals("a")){
            
                displayInventoryMenuOptions();
                String inventoryMenuUserOption = getUserInput().toLowerCase();
            
                if(!inventoryMenuUserOption.equals("a") && !inventoryMenuUserOption.equals("b")){
                    System.out.println("Please enter a valid option");
                }
                if(inventoryMenuUserOption.equals("a")){
                    displayInventoryList();
                }
                if(inventoryMenuUserOption.equals("b")){
                    break;
                }
            }
            if(mainMenuUserOption.equals("b")){
                displayAccountMenu();
                String accountUserInput = getUserInput().toLowerCase();
                    if(!accountUserInput.equals("a") && !accountUserInput.equals("b") && !accountUserInput.equals("c")){
                        System.out.println("Please enter a valid option");
                    }
                    if(accountUserInput.equals("a")){
                        accountAtAGlance();
                        addMoneyToAccountScreen();
                        try{
                            account.addFundsToAccount(convertUserInputToADouble(getUserInput()));
                        } catch (NumberFormatException e){
                            System.out.println("Invalid amount " + e.getMessage());
                            System.out.println("Please enter a numeric value");
                        }
                    }
                    if(accountUserInput.equals("b")){
                        accountAtAGlance();
                        withdrawMoneyFromAccountScreen();
                        try{
                            account.withdrawMoneyFromAccount(convertUserInputToADouble(getUserInput()));
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
     
     public void addMoneyToAccountScreen(){
         System.out.println("How much money would you like to add to your account?");
         System.out.println();
     }
     
     public void withdrawMoneyFromAccountScreen(){
         System.out.println("How much money would you like to withdraw from your account?");
         System.out.println();
     }
     
     public void accountAtAGlance(){
         System.out.println("Your current balance is " + account.getBalance());
     }
     
     public double convertUserInputToADouble(String inputAsAString){
         return Double.parseDouble(inputAsAString);
     }
     
     public String getUserInput(){
         return scanner.nextLine().toLowerCase();
     }
    
    public String getFilename(){
        return scanner.nextLine();
    }
     
     public void displayMainMenuOptions(){
         System.out.println("Welcome to the Main Menu!");
         System.out.println("Please select an option below to continue");
         System.out.println();
         System.out.println("A.) Inventory Menu");
         System.out.println("B.) Account Menu");
         System.out.println("C.) Exit Application");
         System.out.println();
     }

     public void displayInventoryMenuOptions(){
         System.out.println("Welcome to the Inventory Menu!");
         System.out.println("Please select an option below to continue");
         System.out.println();
         System.out.println("A.) View Inventory");
         System.out.println("B.) Exit to Main Menu");
         System.out.println();
     }
     
     public void displayInventoryList() throws FileNotFoundException {
         System.out.println("To view the inventory list, please provide us with the absolute path of the CSV file: ");
         String fileName = getFilename();
         fileInventoryReader.read(fileName);
         System.out.println();
     }
     
     public void displayAccountMenu(){
         System.out.println("Welcome to your account!");
         System.out.println("You currently have " + account.getBalance() + " dollar(s) in your account");
         System.out.println("Please select an option below to continue");
         System.out.println();
         System.out.println("A.) Add money to your account?");
         System.out.println("B.) Withdraw money from your account?");
         System.out.println("C.) Exit to Main Menu");
         System.out.println();
     }
}
