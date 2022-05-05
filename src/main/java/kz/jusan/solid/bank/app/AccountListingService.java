package kz.jusan.solid.bank.app;

import java.util.List;

public interface AccountListingService {
    public Account getClientAccount();
    public AccountWithdraw getClientWithdrawAccount();
    List<Account> getClientAccounts(String clientID);
    List<Account> getClientAccountsByType();
}
