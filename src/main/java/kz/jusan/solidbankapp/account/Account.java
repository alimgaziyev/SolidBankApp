package kz.jusan.solidbankapp.account;

import jdk.jfr.DataAmount;
import lombok.Data;

@Data
public abstract class Account {
    private AccountType accountType;
    private int bankID;
    private String id;
    private String clientID;
    private double balance;
    private boolean withdrawAllowed;

    public Account(AccountType accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        this.accountType = accountType;
        this.bankID = 1;
        this.id = id;
        this.clientID = clientID;
        this.balance = 0.0;
        this.withdrawAllowed = withdrawAllowed;
    }

    @Override
    public String toString() {
        return String.format("Account{%s, id = %03d%06d, clientID = %s, balance = %.2f}",
                accountType,
                bankID, Integer.parseInt(id),
                clientID,
                balance);
    }
}
