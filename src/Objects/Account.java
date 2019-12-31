package Objects;

import utils.IdGenerator;

public class Account {
    private final int accountId;
    private double balance;

    public Account() {
        accountId = IdGenerator.generateAccountId();
        this.balance = 0;
    }

    public Account(int balance) {
        accountId = IdGenerator.generateAccountId();
        this.balance = balance;
    }

    public int getId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + accountId +
                ", balance=" + balance +
                '}';
    }
}
