package kz.jusan.solidbankapp.listingservice;

import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.account.types.AccountWithdraw;

import java.util.List;

public interface AccountListingService {
    public Account getClientAccount();
    public AccountWithdraw getClientWithdrawAccount();
    List<Account> getClientAccounts(String clientID);
    List<Account> getClientAccountsByType();
}
