package com.bankoftim.accounts;


public class Savings extends Account{
    public int withdrawals;

    public Savings(){
        super();
        withdrawals=5;
    }

    public Savings(double balance, int accounts){
        super(balance, accounts);
    }

    public int getAccountNum(){
        return accountNum;
    }

    @Override
    public void withdrawal(double wd){
        if(balance - wd > (double) 20 & withdrawals>0)
        {
            System.out.println("Withdrawing $" + wd );
            balance-=wd;
            withdrawals--;
        }
        else if(withdrawals>0){
            System.out.println("You do not have any withdrawals left. Please wait until you get more next month");
        }
        else if(balance - wd <= (double)20){
            System.out.println("You are trying to withdraw too large a sum. Please make sure you leave 20 in the account.");
        }

        System.out.println(this.toString());
    }

    protected int genAccountNum(int accounts){
        return 101+accounts*10;   
    }
    
    public String toString(){
        return "The " + this.accountNum + " savings account has "+ balance + "and " + withdrawals + " withdrawals remaning.";
    }
}