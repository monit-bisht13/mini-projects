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
        s.nextLine();
        String name = s.nextLine();

        serial++;
        Account acc = new Account(name);
        map.put(serial,acc);
        System.out.println("Account created successfully.\nThanks for choosing XYZ Bank!!");
        System.out.println("Your Account Number: " + acc.getAccountNumber());
        System.out.println("Your Account Balance:" + acc.balance);
    }

    void deposit(){
        if(map.isEmpty()){
            System.out.println("No Account Exists. Please create an account first. ");
        }
        else
        System.out.println("Enter your account number: ");
        String accNumber = s.next();

        Account acc = findAccount(accNumber);
        if (acc != null) {
            System.out.println("Enter the amount you want to deposit: ");
            double amt = s.nextDouble();
            acc.balance += amt;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid account number.");
        }
    }

    void withdraw(){
    	if (map.isEmpty()) {
            System.out.println("No Account Exists. Please create an account first.");
            return;
        }

        System.out.println("Enter your account number: ");
        String accNumber = s.next();

        Account acc = findAccount(accNumber);
        if (acc != null) {
            System.out.println("Enter the amount you want to withdraw: ");
            double d = s.nextDouble();

            if (d <= acc.balance) {
                acc.balance -= d;
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Not enough balance.");
            }
        } else {
            System.out.println("Invalid account number.");
        }    }

    void details(){
        if (map.isEmpty()) {
            System.out.println("No account exists. Please create an account first.");
            return;
        }
        System.out.println("Enter your account number: ");
        String accNumber = s.next();

        Account acc = findAccount(accNumber);
        if (acc != null) {
            System.out.println(acc.toString());  // Display account details
        } else {
            System.out.println("Invalid account number.");}
        }
  

    private Account findAccount(String accNum) {
        for (Account acc : map.values()) {
            if (acc.getAccountNumber().equals(accNum)) {
                return acc;
            }
        }
        return null;  // Account not found
    }
    
    }
