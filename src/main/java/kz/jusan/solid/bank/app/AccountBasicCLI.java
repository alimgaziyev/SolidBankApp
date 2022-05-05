package kz.jusan.solid.bank.app;

import java.io.IOException;
import java.util.List;

public class AccountBasicCLI {
    private CreateAccountOperationUI createAccountOperationUI;
    private BankCore bankCore;
    private AccountListingService accountListing;

    public AccountBasicCLI(CreateAccountOperationUI createAccountOperationUI, BankCore bankCore, AccountListingService accountListing) {
        this.createAccountOperationUI = createAccountOperationUI;
        this.bankCore = bankCore;
        this.accountListing = accountListing;
    }

    public void createAccountRequest(String clientID) {
        System.out.println("Choose account type\n[CHECKING, SAVING, FIXED]");
        boolean isCreated = false;
        AccountType accountType = null;
        while (!isCreated) {
            try {
                accountType = createAccountOperationUI.requestAccountType();
                isCreated = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        bankCore.createNewAccount(accountType, clientID);
        System.out.println("Bank account created");
    }
    public void getAccounts(String clientID) {
        List<Account> accounts = accountListing.getClientAccounts(clientID);
        System.out.println(accounts);
    }
}
