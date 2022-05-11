package kz.jusan.solidbankapp.transaction.withdraw.withdrawservice;

import kz.jusan.solidbankapp.account.database.AccountDAO;
import kz.jusan.solidbankapp.account.types.AccountWithdraw;

public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    private AccountDAO accountDAO;

    public AccountWithdrawServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void withdraw(double amount, AccountWithdraw accountWithdraw) {
        if (accountWithdraw != null && accountWithdraw.isWithdrawAllowed()) {
            if (accountWithdraw.getBalance() >= amount && amount > 0) {
                accountWithdraw.setBalance(accountWithdraw.getBalance() - amount);
            }
        }
    }
}
