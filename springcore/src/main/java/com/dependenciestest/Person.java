package com.dependenciestest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
@Autowired
    private Account a;
@Autowired
    private Address b;


//    public Person(Account a, Address b) {
//        this.a = a;
//        this.b = b;
//    }
//@Autowired
//    public void setA(Account a) {
//        this.a = a;
//    }
//@Autowired
//    public void setB(Address b) {
//        this.b = b;
//    }

    public String getPersonDetails(){
        return a.getAccountDetails()+" "+b.getAddress();
    }




}
