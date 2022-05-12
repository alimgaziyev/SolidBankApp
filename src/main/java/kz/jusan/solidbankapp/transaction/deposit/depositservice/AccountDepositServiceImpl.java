package kz.jusan.solidbankapp.transaction.deposit.depositservice;

import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.account.database.AccountDAO;
import kz.jusan.solidbankapp.account.types.AccountWithdraw;

public class AccountDepositServiceImpl implements AccountDepositService {
    private AccountDAO accountDAO;

    public AccountDepositServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void deposit(double amount, Account account) {
        accountDAO.updateAccount(account, amount);
    }
}
