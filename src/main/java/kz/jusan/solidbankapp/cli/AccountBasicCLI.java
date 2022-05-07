package kz.jusan.solidbankapp.cli;

import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.account.AccountType;
import kz.jusan.solidbankapp.listingservice.AccountListingService;
import kz.jusan.solidbankapp.bank.BankCore;

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

    public boolean createAccountRequest(String clientID) throws IOException {
        boolean isCreated = false;
        AccountType accountType = null;
        while (!isCreated) {
            try {
                accountType = createAccountOperationUI.requestAccountType();
                isCreated = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Not correct enter");
            }
        }
        return bankCore.createNewAccount(accountType, clientID);
    }
    public List<Account> getAccounts(String clientID) {
        return accountListing.getClientAccounts(clientID);
    }
}
