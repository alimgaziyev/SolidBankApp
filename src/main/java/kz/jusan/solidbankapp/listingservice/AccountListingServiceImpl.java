package kz.jusan.solidbankapp.listingservice;

import kz.jusan.solidbankapp.database.AccountDAO;
import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.account.types.AccountWithdraw;

import java.util.List;

public class AccountListingServiceImpl implements AccountListingService {
    private AccountDAO accountDAO;

    public AccountListingServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountDAO.getClientAccounts(clientID);
    }






    @Override
    public Account getClientAccount() {
        return null;
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount() {
        return null;
    }



    @Override
    public List<Account> getClientAccountsByType() {
        return null;
    }
}
