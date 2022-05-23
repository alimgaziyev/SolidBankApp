package kz.jusan.solidbankapp.transaction.database;

import kz.jusan.solidbankapp.transaction.Transaction;
import org.springframework.stereotype.Repository;
import org.w3c.dom.ls.LSException;

import java.util.List;

@Repository
public interface TransactionDOA {
    List<Transaction> getTransactions();
    void addTransaction(Transaction transaction);
}
