
# Banking System Project

## Overview
This project is a **Banking System** built using **Java** and **MySQL**. It simulates real-world banking operations such as creating new accounts, user authentication, depositing and withdrawing funds, viewing account details, and updating personal information. The system interacts with a MySQL database for storing and retrieving account-related data.

## Features

- **Account Management**:
  - Create new accounts with personal details.
  - Generate a unique account number for each user.
  - Store account information securely in a MySQL database.
  
- **Authentication**:
  - Log in with a customer ID and password.
  - Authenticate user credentials against the database.

- **Banking Operations**:
  - Deposit funds into a user's account.
  - Withdraw funds from a user's account with balance validation.
  - View current account balance and transaction history.

- **Account Information**:
  - View account details including name, account number, balance, and mobile number.

- **Account Updates**:
  - Change account password or mobile number.

- **Database Integration**:
  - Uses JDBC for seamless integration with a MySQL database.
  - Stores user account data, transactions, and authentication credentials in the `account_details` table.

## Technologies Used

- **Java**: Object-oriented programming language used for implementing the core logic.
- **JDBC (Java Database Connectivity)**: Enables interaction with the MySQL database for CRUD operations.
- **MySQL**: Database management system used to store and manage account data.

## Usage

1. **Open a New Account**:
   - Choose the option to create a new account.
   - Provide your name, create a password, enter a mobile number, and the system will generate a unique account number for you.

2. **Log in to an Existing Account**:
   - Enter your customer ID and password to log in.
   - Once authenticated, you can access various banking features, including depositing funds, withdrawing funds, and viewing your account details.

3. **Banking Operations**:
   - Deposit and withdraw funds by entering the desired amount.
   - View your account details or update your password or mobile number.

4. **Exit the System**:
   - You can exit the system after completing your operations.

## File Structure

- **Main.java**: The entry point of the application that runs the menu and starts the system.
- **Menu.java**: Manages user interaction and displays the main and account menus.
- **Bank.java**: Handles banking operations such as creating accounts, depositing, withdrawing, and updating account details.
- **Jdbc.java**: Manages the database connection and performs CRUD operations.

## Future Enhancements

- **Fund Transfer**: Implement a feature to transfer funds between accounts.
- **Interest Calculation**: Add functionality to calculate and apply interest to account balances.
- **Mobile Application**: Extend the system by integrating it with a mobile app for remote banking.
- **Security Features**: Implement enhanced security measures such as password encryption and multi-factor authentication.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Thanks to the open-source community for providing the JDBC driver for MySQL.
- Special thanks to all contributors who helped with ideas and bug fixes.
