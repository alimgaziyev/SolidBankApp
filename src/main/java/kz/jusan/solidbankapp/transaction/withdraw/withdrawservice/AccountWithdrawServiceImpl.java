package kz.jusan.solidbankapp.transaction.withdraw.withdrawservice;

import kz.jusan.solidbankapp.account.database.AccountDAO;
import kz.jusan.solidbankapp.account.types.AccountWithdraw;

public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    private AccountDAO accountDAO;

    public AccountWithdrawServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void withdraw(double amount, AccountWithdraw accountWithdraw) throws IllegalArgumentException {
        if (amount > 0.0) {
            accountDAO.updateAccount(accountWithdraw, -amount);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
