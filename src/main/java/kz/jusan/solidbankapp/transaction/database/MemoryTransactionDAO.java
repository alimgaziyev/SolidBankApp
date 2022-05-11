package kz.jusan.solidbankapp.transaction.database;

import kz.jusan.solidbankapp.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MemoryTransactionDAO implements TransactionDOA{
    private List<Transaction> transactions;

    public MemoryTransactionDAO() {
        this.transactions = new ArrayList<Transaction>();
    }

    @Override
    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
