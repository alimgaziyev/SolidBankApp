package kz.jusan.solidbankapp.transaction.withdraw.withdrawservice;

import kz.jusan.solidbankapp.account.types.AccountWithdraw;

public interface AccountWithdrawService {
    void withdraw(double amount, AccountWithdraw accountWithdraw);
}
