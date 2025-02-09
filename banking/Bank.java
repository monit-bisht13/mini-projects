package banking;

import java.util.HashMap;
import java.util.Scanner;

public class Bank {
    private int serial = 0;
    private HashMap<Integer,Account>map = new HashMap<>();
    private Scanner s;

    public Bank(Scanner scanner){
        this.s = scanner;
    }
       

    void create(){
        System.out.println("Please Enter Your Name : ");
        String name = s.next();

        serial++;
        Account acc = new Account(name);
        map.put(serial,acc);
        System.out.println("Account created successfully.\nThanks for choosing XYZ Bank!!");
    }

    void deposit(){
        if(map.isEmpty()){
            System.out.println("No Account Exists. Please create an account first. ");
        }
        else{
        System.out.println("Enter the amount you want to deposit : ");
        double amt = s.nextDouble();
        map.get(serial).balance += amt ;
        System.out.println("Deposit successful."); 
        }
    }

    void withdraw(){
        System.out.println("Enter the amount you want to withdraw : ");
        Double d = s.nextDouble();

        Account acc = map.get(serial); 
        if (d<=acc.balance){
        acc.balance -=  d ;
        System.out.println("Withdrawal successful.");}
        else 
        System.out.println("Not enough balance.");
    }

    void details(){
        if (map.isEmpty()) {
            System.out.println("No account exists. Please create an account first.");
            return;
        }
        
        System.out.println("Account details:");
        System.out.println(map.get(serial)); // Prints account details properly
    }
    }
