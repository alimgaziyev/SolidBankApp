package kz.jusan.solidbankapp.account.database;

import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.account.AccountType;
import kz.jusan.solidbankapp.account.types.AccountWithdraw;

import java.util.ArrayList;
import java.util.List;

public class MemoryAccountDAO implements AccountDAO {
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
    public AccountWithdraw getClientWithDrawAccount(String clientID, String accountID) {
        for (Account account : accountList) {
            if (account.getAccountId().equals(accountID) && account.isWithdrawAllowed()) {
                return (AccountWithdraw) account;
            }
        }
        return null;
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        for (Account account : accountList) {
            String accountNumber = String.format("%03d%06d", 1, Integer.parseInt(account.getId()));
            if (accountNumber.equals(accountID)) {
                return account;
            }
        }
        return null;
    }



    @Override
    public void updateAccount(Account account, double amount) throws IllegalArgumentException {
        if (account.getBalance() + amount >= 0) {
            account.setBalance(account.getBalance() + amount);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return null;
    }




}
