package kz.jusan.solidbankapp.transaction.database;

import kz.jusan.solidbankapp.transaction.Transaction;
import org.w3c.dom.ls.LSException;

import java.util.List;

public interface TransactionDOA {
    List<Transaction> getTransactions();
    void addTransaction(Transaction transaction);
}
