package banking;

import java.util.Scanner;
    
    public class Menu {
       private Bank bank ;
        private Scanner s = new Scanner(System.in);  
    
        public Menu() {	
            this.bank = new Bank(s);
        }
        void menu1() {
            System.out.println("WELCOME TO XYZ BANK.");
            System.out.println("Please select an option:");
            System.out.println("1. Open a New Account");
            System.out.println("2. Log in to an Existing Account");
            System.out.print("Enter your choice: ");
            int userChoice = s.nextInt();
            switch(userChoice) {
                case 1 : 
                    bank.create();//account creating method which stores values in database
                    break;
                case 2 :
                   if (bank.auth()==true){             // authorization function
                   menu2();
                } else 
                System.out.println("Incorrect user id or password.");
                    break;
                default : System.out.println("Invalid input.");
                }
        }
            
        void menu2() {
            while (true) { // Infinite loop which keeps menu running until user chooses to exit
                System.out.println("\nAccount Menu:");
                System.out.println("1. Deposit Funds");
                System.out.println("2. Withdraw Funds");
                System.out.println("3. Account Details");
                System.out.println("4. Change password or mobile number");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int menuOption = s.nextInt();

                switch (menuOption) {
                    case 1:
                        bank.deposit();
                        break;
                    case 2:
                        bank.withdraw();
                        break;
                    case 3:
                        bank.acc_details();
                        break;
                    case 4:
                        bank.passUpdation();
                        break;
                    case 5:
                        System.out.println("Thank you for banking with us!");
                        System.out.println("Have a great day!");
                        return; // Exit menu2() function
                    default:
                        System.out.println("Invalid input.");
                }        
                if (askToContinue()==1) {
                    System.out.println("Thank You For Banking With Us.");
                    System.out.println("Have a great day!");
                    return;}
                }
        }
 
         private int askToContinue() {
                System.out.println("\nWould you like to continue (press 0) or exit the system (press 1)?");
                int choice = s.nextInt();
                return choice; // Returns true if user wants to continue
                }
 }
    

    
 