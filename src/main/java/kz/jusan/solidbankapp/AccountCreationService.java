package kz.jusan.solidbankapp;

public interface AccountCreationService {
    public void create(AccountType accountType, long bankID, String clientID, long accountID);
}