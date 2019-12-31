package Objects;

import utils.IdGenerator;
import utils.Rank;

import java.util.Objects;

public abstract class Client {
   private final int clientId;
   private String clientName;
   private double balance;
   protected Rank rank;
   private Account[] accounts;
   protected double commisionRate;
   protected double interestRate;

   final static int maxAccounts = 4;
   private boolean validIndex(int index){
       if(index >= 0 && index < 5){
           return true;
       }
       else {
           return false;
       }
   }

    public Client(String clientName) {
        this.clientId = IdGenerator.generateClientId();
        this.clientName = clientName;
        this.balance = 0;
        this.accounts = new Account[maxAccounts];
    }

    public Client(String clientName, double balance) {
        this.clientId = IdGenerator.generateClientId();
        this.clientName = clientName;
        this.balance = balance;
        this.accounts = new Account[maxAccounts];
    }

    public void removeAccount(int accountID){
        for (int i = 0; i < maxAccounts ; i++) {
            if(accounts[i].getId() == accountID){
                this.balance += accounts[i].getBalance();
                accounts[i] = null;
            }
        }

    }

    public Account getAccount(int index){
        if(validIndex(index) && accounts[index]!= null){
            return accounts[index];
        }
        else{
            return null;
        }
    }

    public void addAccount(Account account){
        boolean canAdd = false;
        int index = -1;
        for (int i = 0; i < maxAccounts ; i++) {
            if (accounts[i] == null){
                index = i;
                canAdd = true;
                break;
            }
        }
        if (canAdd){
            accounts[index] = account;
        }
        else{
            System.out.println("Cannot add more accounts");
        }
    }

    public double getFortune(){
       double sum = 0;
        for (Account total:accounts) {
            sum += total.getBalance();
        }
        sum += this.getBalance();
        return sum;
    }

    public void autoUpdateAccounts(){
        for (int i = 0; i < maxAccounts ; i++) {
            if (accounts[i] == null){
                continue;
            }
            accounts[i].setBalance(accounts[i].getBalance() + (accounts[i].getBalance()* interestRate));
        }
    }

    public void withdrawal(double withdrawaling){
       Bank.addComission(withdrawaling);
       this.balance -= withdrawaling + (withdrawaling*commisionRate);
    }

    public void deposite(double depositing){
       this.balance += depositing;
    }

    //Getters & Setters

    public int getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public double getBalance() {
        return balance;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return clientId == client.clientId;
    }

}
