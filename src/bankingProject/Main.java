package bankingProject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        // Create some sample accounts
        bank.createAccount(1001, "Gowtham", 500.00);
        bank.createAccount(1002, "Shivani", 1000.00);

        System.out.println("Welcome to the Banking System!");
        boolean running = true;

        while (running) {
        	
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit money");
            System.out.println("2. Withdraw money");
            System.out.println("3. View account details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            int accountNumber;
            BankAccount account;
            double amount;

            switch (choice) {
                case 1: // Deposit
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextInt();
                    account = bank.getAccount(accountNumber);
                    if (account != null) {
                        System.out.print("Enter amount to deposit: ");
                        amount = scanner.nextDouble();
                        BankingOperation depositOperation = new BankingOperation(account, "deposit", amount);
                        depositOperation.start();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 2: // Withdraw
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextInt();
                    account = bank.getAccount(accountNumber);
                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ");
                        amount = scanner.nextDouble();
                        BankingOperation withdrawOperation = new BankingOperation(account, "withdraw", amount);
                        withdrawOperation.start();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3: // View account details
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextInt();
                    account = bank.getAccount(accountNumber);
                    if (account != null) {
                        System.out.println(account.getAccountDetails());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4: // Exit
                    running = false;
                    System.out.println("Exiting the banking system.");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }

            // Wait for any ongoing operations to finish
            try {
                Thread.sleep(1000); // Pause for 1 second before the next operation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}
