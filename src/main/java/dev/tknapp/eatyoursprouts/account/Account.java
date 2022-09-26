package dev.tknapp.eatyoursprouts.account;

import java.math.BigDecimal;

public class Account {
    
    private double balance;
    
    public Account(){
    }
    
    public void addFundsToAccount(double fundsToAdd) throws NumberFormatException{
            if(fundsToAdd >= 0 ){
                this.balance += fundsToAdd;
            }
            if(fundsToAdd < 0){
                System.out.println("Cannot be a negative amount");
            }
    }
    
    public void withdrawMoneyFromAccount(double fundsToWithdraw) throws NumberFormatException{
        if(fundsToWithdraw > this.balance){
            System.out.println("You cannot withdraw more than your current balance");
        }
        if(fundsToWithdraw < 0){
            System.out.println("You cannot withdraw a negative amount");
        }
        if(fundsToWithdraw >= 0 && fundsToWithdraw <= this.balance){
            this.balance -= fundsToWithdraw;
        }
    }
    
    public double getBalance() {
        return balance;
    }
    
}
