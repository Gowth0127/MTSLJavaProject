package bankingProject;

public class BankingOperation extends Thread {
    private BankAccount account;
    private String operation;
    private double amount;

    public BankingOperation(BankAccount account, String operation, double amount) {
        this.account = account;
        this.operation = operation;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            if (operation.equals("deposit")) {
                account.deposit(amount);
            } else if (operation.equals("withdraw")) {
                account.withdraw(amount);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
