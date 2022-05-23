package kz.jusan.solidbankapp.account.cli;

import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.account.AccountType;
import kz.jusan.solidbankapp.account.listingservice.AccountListingService;
import kz.jusan.solidbankapp.bank.BankCore;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountBasicCLI {
    private CreateAccountOperationUI createAccountOperationUI;
    private BankCore bankCore;
    private AccountListingService accountListing;

    public AccountBasicCLI(CreateAccountOperationUI createAccountOperationUI,
                           BankCore bankCore,
                           AccountListingService accountListing) {
        this.createAccountOperationUI = createAccountOperationUI;
        this.bankCore = bankCore;
        this.accountListing = accountListing;
    }

    public boolean createAccountRequest(String clientID) {
        boolean isCreated = false;
        AccountType accountType = null;
        while (!isCreated) {
            System.out.println("Choose account type\n[CHECKING, SAVING, FIXED]");
            try {
                accountType = createAccountOperationUI.requestAccountType();
                isCreated = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Not correct enter");
            }
        }
        isCreated = bankCore.createNewAccount(accountType, clientID);
        System.out.println("Bank account created");
        return isCreated;
    }
    public List<Account> getAccounts(String clientID) {
        return accountListing.getClientAccounts(clientID);
    }
}
