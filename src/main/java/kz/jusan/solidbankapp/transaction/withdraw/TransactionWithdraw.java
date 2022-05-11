package kz.jusan.solidbankapp.transaction.withdraw;

import kz.jusan.solidbankapp.account.types.AccountWithdraw;
import kz.jusan.solidbankapp.transaction.Transaction;
import kz.jusan.solidbankapp.transaction.database.MemoryTransactionDAO;
import kz.jusan.solidbankapp.transaction.database.TransactionDOA;
import kz.jusan.solidbankapp.transaction.withdraw.withdrawservice.AccountWithdrawService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionWithdraw {
    private AccountWithdrawService accountWithdrawService;
    private TransactionDOA transactionDOA;

    public TransactionWithdraw(AccountWithdrawService accountWithdrawService, TransactionDOA transactionDOA) {
        this.accountWithdrawService = accountWithdrawService;
        this.transactionDOA = transactionDOA;
    }

    public void execute(AccountWithdraw account, double amount) {
        accountWithdrawService.withdraw(amount, account);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);

        transactionDOA.addTransaction(new Transaction("", "", amount, date, true));
    }
}
