package com.dependenciestest;

import org.springframework.stereotype.Component;

@Component
public class Account {
    private int accountNumber = 1234567;
    private String accountType = "checking";
    private int balance = 45000 ;

    public String getAccountDetails(){
        return ""+this.accountType+""+this.accountNumber+""+this.balance;
    }
}
