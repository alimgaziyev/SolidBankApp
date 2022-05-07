package kz.jusan.solidbankapp.bank;

import kz.jusan.solidbankapp.account.AccountType;
import kz.jusan.solidbankapp.creationservice.AccountCreationService;

public class BankCore {
    private static long id = 1;
    private long lastAccountNumber = 1;
    private AccountCreationService accountCreation;
    public BankCore(AccountCreationService accountCreation) {
        this.accountCreation = accountCreation;
    }
    public boolean createNewAccount(AccountType accountType, String clientID) {
        boolean isCreated = accountCreation.create(accountType, id, clientID, lastAccountNumber);
        if (isCreated) incrementLastAccountNumber();
        return isCreated;
    }
    private void incrementLastAccountNumber() {
        lastAccountNumber++;
    }
}
