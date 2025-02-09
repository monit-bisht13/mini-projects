package banking;

import java.util.Random;


public class Account {
    private int[] accNumber = new int[14];
    private String name;
    protected double balance = 0;
    Account(String name){
    //getting name
        this.name = name;
    //generating account number 
        Random r = new Random();
        for(int i = 0;i<14;i++){
            accNumber[i] = r.nextInt(10);
        }
    }
    public String toString() {
        StringBuilder accNumStr = new StringBuilder();
        for (int num : accNumber) {
            accNumStr.append(num);
        }
        return "Account Holder: " + name + 
               "\nAccount Number: " + accNumStr + 
               "\nBalance: $" + balance;
    }    
}
