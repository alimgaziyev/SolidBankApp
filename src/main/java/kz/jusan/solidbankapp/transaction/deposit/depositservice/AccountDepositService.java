package kz.jusan.solidbankapp.transaction.deposit.depositservice;

import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.account.types.AccountWithdraw;

public interface AccountDepositService {
    void deposit(double amount, Account account);
}
