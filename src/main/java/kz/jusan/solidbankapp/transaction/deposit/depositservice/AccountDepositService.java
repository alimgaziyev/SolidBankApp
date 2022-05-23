package kz.jusan.solidbankapp.transaction.deposit.depositservice;

import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.account.types.AccountWithdraw;
import org.springframework.stereotype.Service;

@Service
public interface AccountDepositService {
    void deposit(double amount, Account account);
}
