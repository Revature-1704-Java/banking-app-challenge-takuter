package com.bankoftim;

public class Checking extends Account{

    public Checking(){
        super();
    }

    public Checking(double balance, int accounts){
        super(balance, accounts);
    }

    @Override
    public void withdrawal(double wd){
        System.out.println("Withdrawing $" + wd );
        balance-=wd;
        System.out.println(this.toString());
    }

    protected int genAccountNum(int accounts){
        return 110+accounts;   
    }

    public String toString(){
        return "The " + this.accountNum + " checking account has "+ balance + ".";
    }

}