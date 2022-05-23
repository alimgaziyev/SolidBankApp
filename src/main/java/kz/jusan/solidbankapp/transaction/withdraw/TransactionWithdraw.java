package kz.jusan.solidbankapp.transaction.withdraw;

import kz.jusan.solidbankapp.account.types.AccountWithdraw;
import kz.jusan.solidbankapp.transaction.Transaction;
import kz.jusan.solidbankapp.transaction.database.MemoryTransactionDAO;
import kz.jusan.solidbankapp.transaction.database.TransactionDOA;
import kz.jusan.solidbankapp.transaction.withdraw.withdrawservice.AccountWithdrawService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TransactionWithdraw {
    private AccountWithdrawService accountWithdrawService;
    private TransactionDOA transactionDOA;

    public TransactionWithdraw(AccountWithdrawService accountWithdrawService, TransactionDOA transactionDOA) {
        this.accountWithdrawService = accountWithdrawService;
        this.transactionDOA = transactionDOA;
    }

    public boolean execute(AccountWithdraw account, double amount) {
        boolean isTransferred = false;
        try {
            accountWithdrawService.withdraw(amount, account);
            isTransferred = true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);

        transactionDOA.addTransaction(new Transaction("out", account.getAccountId(), amount, date, isTransferred));
        return isTransferred;
    }
}
