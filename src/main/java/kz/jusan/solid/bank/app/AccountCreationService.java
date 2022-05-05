package kz.jusan.solid.bank.app;

public interface AccountCreationService {
    public void create(AccountType accountType, long bankID, String clientID, long accountID);
}
