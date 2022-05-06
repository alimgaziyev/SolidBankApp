package kz.jusan.solidbankapp;

public class BankCore {
    private static long id = 1;
    private long lastAccountNumber = 1;
    private AccountCreationService accountCreation;
    public BankCore(AccountCreationService accountCreation) {
        this.accountCreation = accountCreation;
    }
    public void createNewAccount(AccountType accountType, String clientID) {
        accountCreation.create(accountType, id, clientID, lastAccountNumber);
        incrementLastAccountNumber();
    }
    private void incrementLastAccountNumber() {
        lastAccountNumber++;
    }
}
