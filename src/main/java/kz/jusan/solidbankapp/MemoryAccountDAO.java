package kz.jusan.solidbankapp;

import java.util.ArrayList;
import java.util.List;

public class MemoryAccountDAO implements AccountDAO{
    private List<Account> accountList;

    public MemoryAccountDAO() {
        this.accountList = new ArrayList<Account>();
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountList;
    }

    @Override
    public void createNewAccount(Account account) {
        accountList.add(account);
    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return null;
    }

    @Override
    public AccountWithdraw getClientWithDrawAccount(String clientID, String accountID) {
        return null;
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        return null;
    }
}