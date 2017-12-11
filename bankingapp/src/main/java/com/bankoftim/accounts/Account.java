package com.bankoftim.accounts;

import java.io.Serializable;

public abstract class Account implements Serializable{
    public static final String serialVersionID = "BA01";
    protected double balance;
    protected int accountNum;

    public Account(){
        balance=0;
        this.accountNum=genAccountNum(0);

    }

    public Account(double balance, int accounts){
        this.balance=balance;
        this.accountNum=genAccountNum(accounts);
    }

    public int getAccountNum(){
        return accountNum;
    }
    
    public double getBalance(){
        return balance;
    }

    public void deposit(double deposit){
        this.balance += deposit;
    }

    public abstract void withdrawal(double wd);

    protected abstract int genAccountNum(int accounts);

    public abstract String toString();
}