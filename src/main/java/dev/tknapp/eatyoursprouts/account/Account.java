package dev.tknapp.eatyoursprouts.account;

import java.math.BigDecimal;

public class Account {
    
    public double getBalance() {
        return balance;
    }
    
    private double balance;
    
    public Account(){
    }
    
    public void addFundsToAccount(double fundsToAdd){
        this.balance += fundsToAdd;
    }
    
    public void withdrawMoneyFromAccount(double fundsToWithdraw){
        this.balance -= fundsToWithdraw;
    }
    
    
}
