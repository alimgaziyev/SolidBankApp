package kz.jusan.solidbankapp.account.database;

import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.account.AccountType;
import kz.jusan.solidbankapp.account.types.AccountWithdraw;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDAO {
    public List<Account> getClientAccounts(String clientID);
    public void createNewAccount(Account account);
    public void updateAccount(Account account, double amount) throws IllegalArgumentException;
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType);
    public AccountWithdraw getClientWithDrawAccount(String clientID, String accountID);
    public Account getClientAccount(String clientID, String accountID);

}
