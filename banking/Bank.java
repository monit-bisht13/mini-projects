    package banking;
  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

    public class Bank{
        private Scanner s;
        private String name;
        private int Id = 100; // Default start value
        private double balance = 0;
        private  String password;
        private String account_number;
        private String mobile_number;
        private int id_verify ;
        private Random r = new Random();


        Bank(Scanner scanner){
            this.s=scanner;
        }

        void create(){

            //name
        	s.nextLine();
            System.out.println("Enter your name : ");
            name = s.nextLine();

            //account number
            int[] arr = new int[14] ;
            for(int i = 0; i<14; i++){
                arr[i]=r.nextInt(9);
            }
            StringBuilder acc = new StringBuilder();
            for(int a : arr){
                acc.append(a);
            }
            account_number = acc.toString();

            //password 
            System.out.println("Create a password : ");
            password = s.nextLine();
            
            //mobile number
            System.out.println("Enter your Mobile NUmber : ");
            mobile_number = s.nextLine();
            
            
            //inserting values in database 
            try (Connection connection = Jdbc.getConnection()) {

                String query = "SELECT MAX(id) FROM account_details";
                PreparedStatement getMaxIdStmt = connection.prepareStatement(query);
                ResultSet rs = getMaxIdStmt.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    Id = rs.getInt(1) + 1; // Increment the max ID
                }

                String query1 = "INSERT INTO account_details (id,name , account_number,balance,password,mobile_number) VALUES (?,?,?,?,?,?)";
                PreparedStatement p = connection.prepareStatement(query1);
                p.setInt(1, Id);
                p.setString(2, name);
                p.setString(3, account_number);
                p.setDouble(4, balance);
                p.setString(5, password);
                p.setString(6, mobile_number);
               
                int rowsInserted = p.executeUpdate();
                if (rowsInserted > 0) { 
                    System.out.println("Your account has been successfully created! and your Customer ID is : " + Id);
                    System.out.println("Thank You for choosing XYZ Bank!");
                } else {
                    System.out.println("Account creation failed. Please try again.");
                }
            }catch (SQLException e) {
            	System.out.println("An error occurred while processing your request. Please try again later.");
                }
        }

        boolean auth(){
            boolean res = false;
            System.out.println("Please enter your Customer Id : ");
            id_verify = s.nextInt();
            System.out.println("Please enter your Password : ");
            s.nextLine();
            String pass = s.nextLine();
            
         
            String query = "SELECT * FROM account_details where id = ?";
            try(Connection connection = Jdbc.getConnection()){
                PreparedStatement p = connection.prepareStatement(query);
                p.setInt(1, id_verify);
                ResultSet rs = p.executeQuery();

                if(rs.next()){
                    String storedPassword = rs.getString("password");
                    if(storedPassword.equals(pass)){
                        res = true;
                    }
                }
            }catch (SQLException e){
            	System.out.println("An error occurred while processing your request. Please try again later.");
            }   
            return res;
        }
        void deposit() {
            System.out.println("Enter the amount you want to deposit: ");
            double depositAmount = s.nextDouble();
            if (depositAmount <= 0) {
                System.out.println("Invalid amount. Please enter a positive value.");
                return;
            }
            
            try (Connection connection = Jdbc.getConnection()) {
                // Fetch the latest balance
                String fetchQuery = "SELECT balance FROM account_details WHERE id = ?";
                PreparedStatement fetchStmt = connection.prepareStatement(fetchQuery);
                fetchStmt.setInt(1, id_verify);
                ResultSet rs = fetchStmt.executeQuery();
                
                double currentBalance = 0;
                if (rs.next()) {
                    currentBalance = rs.getDouble("balance");
                } else {
                    System.out.println("Error: Account not found.");
                    return;
                }

                // Update balance after adding depositAmount
                double newBalance = currentBalance + depositAmount;
                String updateQuery = "UPDATE account_details SET balance = ? WHERE id = ?";
                PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
                updateStmt.setDouble(1, newBalance);
                updateStmt.setInt(2, id_verify);
                int rowsAffected = updateStmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Deposit successful. New balance: " + newBalance);
                } else {
                    System.out.println("Error: Balance update failed.");
                }
            } catch (SQLException e) {
            	System.out.println("An error occurred while processing your request. Please try again later.");
            }
        }

        void withdraw() {
            System.out.println("Enter the amount you want to withdraw: ");
            double bal = s.nextDouble();

            try (Connection connection = Jdbc.getConnection()) {
                // Fetch current balance
                String fetchQuery = "SELECT balance FROM account_details WHERE id = ?";
                PreparedStatement fetchStmt = connection.prepareStatement(fetchQuery);
                fetchStmt.setInt(1, id_verify);
                ResultSet rs = fetchStmt.executeQuery();

                if (rs.next()) {
                    double currentBalance = rs.getDouble("balance");

                    if (bal <= currentBalance) { // Ensure sufficient funds
                        double newBalance = currentBalance - bal;

                        // Update balance in database
                        String updateQuery = "UPDATE account_details SET balance = ? WHERE id = ?";
                        PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
                        updateStmt.setDouble(1, newBalance);
                        updateStmt.setInt(2, id_verify);

                        int rowsAffected = updateStmt.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Withdrawal successful. New balance: " + newBalance);
                        } else {
                            System.out.println("Error: Account not found or balance update failed.");
                        }
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                } else {
                    System.out.println("Account not found.");
                }
            } catch (SQLException e) {
            	System.out.println("An error occurred while processing your request. Please try again later.");
            }
        }

        void acc_details(){
            try (Connection connection = Jdbc.getConnection()){
                String query = "SELECT * FROM account_details WHERE id = ?";
                PreparedStatement p = connection.prepareStatement(query);
                p.setInt(1, id_verify);
                ResultSet rs = p.executeQuery();

                while ((rs.next())) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String account_number = rs.getString("account_number");
                    double balance = rs.getDouble("balance");
                    String mobile_number = rs.getString("mobile_number");

                    System.out.println("ID : " + id + "\nNAME : " + name + "\nACCOUNT NUMBER : " + account_number + "\nBALANCE : " + balance + "\nMOBILE NUMBER : " + mobile_number);
                }
            } catch (SQLException e) {
                System.out.println("Couldn't fetch details , please try again later. ");
            }
        }
        
        void passUpdation() {
        	System.out.println("What would you like to change ?");
        	System.out.println("1.Password");
        	System.out.println("2.Mobile Number");
        	System.out.println("Please enter your choice : ");
        	int choice = s.nextInt();
        	s.nextLine();
        	switch (choice) {
			case 1: {
				System.out.println("Enter new password : ");
				String pass = s.nextLine();
				try {
					Connection connection = Jdbc.getConnection();
					String query = "UPDATE account_details SET password = ? where id = ?";
					PreparedStatement p = connection.prepareStatement(query);
					p.setString(1, pass);
					p.setInt(2, id_verify);
					int rowsAffected = p.executeUpdate();
					if(rowsAffected>0) {
						System.out.println("Password updated successfully.");
					}
					else {
						System.out.println("Error: Account not found or password update failed.");
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			}
			case 2 :{
				System.out.println("Enter new mobile number : ");
				String mob = s.nextLine();
				try {
					Connection connection = Jdbc.getConnection();
					String query = "UPDATE account_details SET mobile_number = ? where id = ?";
					PreparedStatement p = connection.prepareStatement(query);
					p.setString(1, mob);
					p.setInt(2, id_verify);
					int rowsAffected = p.executeUpdate();
					if(rowsAffected>0) {
						System.out.println("Mobile Number updated successfully.");
					}
					else {
						System.out.println("Error: Account not found or updation failed.");
					}
					
				} catch (SQLException e) {
					System.out.println("An error occurred while processing your request. Please try again later.");
				}
				break;
			}
				
			default:
				System.out.println("Unexpected value");
			}
        }
    }