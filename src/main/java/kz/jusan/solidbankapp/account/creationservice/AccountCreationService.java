package kz.jusan.solidbankapp.account.creationservice;

import kz.jusan.solidbankapp.account.AccountType;

public interface AccountCreationService {
    public boolean create(AccountType accountType, long bankID, String clientID, long accountID);
}
