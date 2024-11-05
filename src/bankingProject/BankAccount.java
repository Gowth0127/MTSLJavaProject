package bankingProject;

public class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Deposit money into the account
    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. Current balance: " + balance);
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    // Withdraw money from the account
    public synchronized void withdraw(double amount) throws IllegalArgumentException {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. Current balance: " + balance);
        } else if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        } else {
            throw new IllegalArgumentException("Insufficient funds.");
        }
    }

    // Get account details
    public synchronized String getAccountDetails() {
        return "Account Holder: " + accountHolder + ", Account Number: " + accountNumber + ", Balance: " + balance;
    }
}
