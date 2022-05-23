package kz.jusan.solidbankapp.transaction.withdraw.withdrawservice;

import kz.jusan.solidbankapp.account.types.AccountWithdraw;
import org.springframework.stereotype.Service;

@Service
public interface AccountWithdrawService {
    void withdraw(double amount, AccountWithdraw accountWithdraw) throws IllegalArgumentException;
}
