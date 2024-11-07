package Bank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactionHistory;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> displayTransactionHistory() {
        return transactionHistory;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setTransactionHistory(List<Transaction> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            Date date = new Date();
            Transaction deposit = new Transaction(date,"deposit", amount);
            transactionHistory.add(deposit);
            balance += amount;
        }
    }

    public void withdrawal(double amount) {
        if (amount <= balance) {
            Date date = new Date();
            Transaction withdrawal = new Transaction(date,"withdrawal", amount);
            transactionHistory.add(withdrawal);
            balance -= amount;
        }
    }
}
