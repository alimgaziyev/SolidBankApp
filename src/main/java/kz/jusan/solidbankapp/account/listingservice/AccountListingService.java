package kz.jusan.solidbankapp.account.listingservice;

import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.account.types.AccountWithdraw;

import java.util.List;

public interface AccountListingService {
    public Account getClientAccount(String clientID, String accountID);

    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);
    List<Account> getClientAccounts(String clientID);

    List<Account> getClientAccountsByType();
}
