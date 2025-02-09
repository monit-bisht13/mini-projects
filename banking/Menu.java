package banking;

import java.util.Scanner;

public class Menu {
	private Bank b ;
	private Scanner s = new Scanner(System.in);  

    public Menu() {
        this.b = new Bank(s);
    }
    void menu() {
		System.out.println("WELCOME TO XYZ BANK.");
		System.out.println("We offer the following services :");
		System.out.println("1. Open a new account.");
		System.out.println("2. Deposit an amount.");
		System.out.println("3. Withdraw an amount.");
		System.out.println("4. Check your balance.");
		System.out.println("5.Exit the system.");
		System.out.print("Please Enter Your Choice : ");
		int x = s.nextInt();
		switch(x) {
		case 1 : 
			b.create();
			menu();
			break;
		case 2 :
		    b.deposit();
			menu();
			break;
		case 3 :
		    b.withdraw();
			menu();
			break;
		case 4 :
		   b.details();
		   menu();
		   break;
		case 5 :
		    System.out.println("Exited successfully.");
		    break;
		default : System.out.println("Invalid input.");
		}
		s.close();
		
	}
    
}
