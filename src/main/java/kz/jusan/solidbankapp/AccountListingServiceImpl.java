package kz.jusan.solidbankapp;

import java.util.List;

public class AccountListingServiceImpl implements AccountListingService{
    private AccountDAO accountDAO;

    public AccountListingServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public AccountListingServiceImpl() {

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
    public List<Account> getClientAccounts(String clientID) {
        return accountDAO.getClientAccounts(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType() {
        return null;
    }
}
