package kz.jusan.solidbankapp.transaction.deposit;

import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.transaction.Transaction;
import kz.jusan.solidbankapp.transaction.database.MemoryTransactionDAO;
import kz.jusan.solidbankapp.transaction.database.TransactionDOA;
import kz.jusan.solidbankapp.transaction.deposit.depositservice.AccountDepositService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionDeposit {
    private AccountDepositService accountDepositService;
    private TransactionDOA  transactionDOA;

    public TransactionDeposit(AccountDepositService accountDepositService, TransactionDOA transactionDOA) {
        this.accountDepositService = accountDepositService;
        this.transactionDOA = transactionDOA;
    }

    public void execute(Account account, double amount) {
        accountDepositService.deposit(amount, account);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);

        transactionDOA.addTransaction(new Transaction("", "", amount, date, true));
    }
}
