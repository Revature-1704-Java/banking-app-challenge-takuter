package com.bankoftim.io;

import java.util.Scanner;
import com.bankoftim.accounts.*;


public class Parser{

    public static boolean checkCommands(Account user , Scanner sc){
        boolean commanded=false;
        while(!commanded){
            System.out.println("What would you like to do?\ndeposit, withdrawal, back, quit");
            String action = removeEOL(sc.nextLine()).toLowerCase();
            double amount;
            switch(action){
                case "deposit" : System.out.println("How much would you like to deposit"); amount = Double.parseDouble(sc.nextLine()); user.deposit(amount); break;
                case "withdrawal" : System.out.println("How much would you like to withdrawal"); amount = Double.parseDouble(sc.nextLine()); user.withdrawal(amount);break;
                case "back" : commanded = true; break;
                case "quit" :  return true;
                default : System.out.println("Invalid command, please enter again");
            }
        }

        return false;
    }

    public static String removeEOL(String input){
        return input.replaceAll("(\\r|\\n)", "");
    }
}