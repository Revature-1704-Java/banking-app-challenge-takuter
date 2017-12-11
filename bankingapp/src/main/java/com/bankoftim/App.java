package com.bankoftim;

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Scanner sc = new Scanner(System.in);
    private static String userId;
    private static HashMap<String, ArrayList<Account>> accounts = new HashMap<String, ArrayList<Account>>();

    public static void main(String[] args)
    {
        boolean completed= false;
        ArrayList<Account> user = new ArrayList<Account>();
        loadAccounts();
        boolean account = false;
        while(!completed){
            if(!account){
            System.out.println("Please enter your account ID:");
            userId=Parser.removeEOL(sc.nextLine());
            if (accounts.containsKey(userId)){
                user = accounts.get(userId); 
            }
            else{

                while(user.size()<=0)
                {
                    createAccount();
                }
            }
        } account = true;

        for(int i=0; i <= user.size();i++){
            System.out.println(user.get(i).toString());
        
            }

        System.out.println("Which account would you like to interact with?");
        int input = Integer.parseInt(sc.nextLine());
        int accNum = 0;
        for(int i=0;i<user.size();i++){
            if (user.get(i).getAccountNum() == input) accNum=input;
        }

        if(accNum>0){
        
                completed = Parser.checkCommands(user.get(accNum), sc);
            }
        }

        
    }

    private static void loadAccounts(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("bankaccount"))){
            Object obj = ois.readObject();
            try
            {
                if(obj!=null) accounts = (HashMap<String, ArrayList<Account>>)obj;
                else throw new FileNotFoundException();
            }
            catch(ClassCastException ex){System.out.println("Something went wrong with the database. Please delete it before starting again");}
        } catch (FileNotFoundException ex){
            System.out.println("No bank accounts currently in database.");
        } catch (IOException ex){
            ex.getMessage();
        } catch (ClassNotFoundException ex){
            ex.getMessage();
        }

    }

    public static void createAccount(){
        System.out.println("What kind of account would you like to create? checkings or savings?");
        String type=(Parser.removeEOL(sc.nextLine())).toLowerCase();

        System.out.println("How much would you like to deposit in it?");
        double deposit= Double.parseDouble(sc.nextLine());

        switch(type){
            case "checking" : accounts.get(userId).add(new Checking(deposit, accounts.get(userId).size())); break;
            case "savings" : accounts.get(userId).add(new Savings(deposit, accounts.get(userId).size())); break;
            default : System.out.println("Invalid input, please try again");
        }
    }
}
