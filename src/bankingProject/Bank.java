package bankingProject;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, BankAccount> accounts = new HashMap<>();

    // Create a new account
    public void createAccount(int accountNumber, String accountHolder, double initialDeposit) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account with this number already exists.");
        } else {
            BankAccount account = new BankAccount(accountNumber, accountHolder, initialDeposit);
            accounts.put(accountNumber, account);
            System.out.println("Account created for " + accountHolder);
        }
    }

    // Get an account by account number
    public BankAccount getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }
}
