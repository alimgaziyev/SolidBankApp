package kz.jusan.solidbankapp.transaction;

public class Transaction {
    private String fromID;
    private String toID;
    private double amount;
    private String date;
    private boolean isDone;

    public Transaction(String fromID, String toID, double amount, String date, boolean isDone) {
        this.fromID = fromID;
        this.toID = toID;
        this.amount = amount;
        this.date = date;
        this.isDone = isDone;
    }
}
