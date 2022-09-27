package dev.tknapp.eatyoursprouts;

import dev.tknapp.eatyoursprouts.account.Account;
import dev.tknapp.eatyoursprouts.inventory.FileInventoryReader;
import dev.tknapp.eatyoursprouts.items.ItemDAO;
import org.apache.tomcat.jni.File;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {
    
    private static final Scanner scanner = new Scanner(System.in);
    
     public void showWelcomeMessage(){
         System.out.println();
         System.out.println("*******************************************");
         System.out.println("******  Welcome to Eat Your Sprouts  ******");
         System.out.println("*******************************************");
         System.out.println();
     }
     
     public void addMoneyToAccountScreen(){
         System.out.println("How much money would you like to add to your account?");
         System.out.println();
     }
     
     public void withdrawMoneyFromAccountScreen(){
         System.out.println("How much money would you like to withdraw from your account?");
         System.out.println();
     }
     
     public void accountAtAGlance(Account account){
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
     
     public void displayInventoryList(FileInventoryReader fileInventoryReader) throws FileNotFoundException {
         System.out.println("To view the inventory list, please provide us with the absolute path of the CSV file: ");
         String fileName = getFilename();
         fileInventoryReader.read(fileName);
         System.out.println();
     }
     
     public void displayAccountMenu(Account account){
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
