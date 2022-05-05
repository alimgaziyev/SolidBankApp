package kz.jusan.solid.bank.app;

public class Account {
    private AccountType accountType;
    private int bankID = 1;
    private String id;
    private String clientID;
    private double balance;
    private boolean withdrawAllowed;

    public Account(AccountType accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        this.accountType = accountType;
        //this.bankID = 1;
        this.id = id;
        this.clientID = clientID;
        this.balance = balance;
        this.withdrawAllowed = withdrawAllowed;
    }

    @Override
    public String toString() {
        return String.format("Account{%s, id = %03d%06d, clientID = %s, balance = %.2f}", accountType.getType(), bankID, Integer.parseInt(id), clientID, balance);
    }

    public double getBalance() {
        return balance;
    }

    public String getClientID() {
        return clientID;
    }

    public String getID() {
        return id;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public void setWithdrawAllowed(boolean withdrawAllowed) {
        this.withdrawAllowed = withdrawAllowed;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isWithdrawAllowed() {
        return withdrawAllowed;
    };

}
