package kz.jusan.solidbankapp;

import java.util.List;

public interface AccountListingService {
    public Account getClientAccount();
    public AccountWithdraw getClientWithdrawAccount();
    List<Account> getClientAccounts(String clientID);
    List<Account> getClientAccountsByType();
}
