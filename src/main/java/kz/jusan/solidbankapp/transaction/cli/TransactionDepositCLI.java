package kz.jusan.solidbankapp.transaction.cli;

import kz.jusan.solidbankapp.account.listingservice.AccountListingService;
import kz.jusan.solidbankapp.transaction.cli.WithdrawDepositOperationCLIUI;
import kz.jusan.solidbankapp.transaction.deposit.TransactionDeposit;

public class TransactionDepositCLI {
    private TransactionDeposit transactionDeposit;
    private WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private AccountListingService accountListing;

    public TransactionDepositCLI(TransactionDeposit transactionDeposit,
                                 WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI,
                                 AccountListingService accountListing) {
        this.transactionDeposit = transactionDeposit;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListing = accountListing;
    }

    public void depositMoney(String clientID) {
        try {
            System.out.println("Type account ID");
            String accountNumber = withdrawDepositOperationCLIUI.requestClientAccountNumber();
            System.out.println("Type Amount of money");
            double amount = withdrawDepositOperationCLIUI.requestClientAmount();
            transactionDeposit.execute(accountListing.getClientAccount(clientID, accountNumber), amount);
            System.out.println("");
        } catch (IllegalArgumentException e) {
            System.out.println("");
        } catch (NullPointerException e) {

        }
    }
}
