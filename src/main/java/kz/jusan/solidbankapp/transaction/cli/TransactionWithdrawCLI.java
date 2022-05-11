package kz.jusan.solidbankapp.transaction.cli;

import kz.jusan.solidbankapp.account.listingservice.AccountListingService;
import kz.jusan.solidbankapp.transaction.cli.WithdrawDepositOperationCLIUI;
import kz.jusan.solidbankapp.transaction.withdraw.TransactionWithdraw;

public class TransactionWithdrawCLI {
    private TransactionWithdraw transactionWithdraw;
    private WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListing;

    public TransactionWithdrawCLI(TransactionWithdraw transactionWithdraw,
                                  WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI,
                                  AccountListingService accountListing) {
        this.transactionWithdraw = transactionWithdraw;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListing = accountListing;
    }

    public void withdrawMoney(String clientID) {
        String accountNumber = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        transactionWithdraw.execute(accountListing.getClientWithdrawAccount(clientID, accountNumber), amount);

    }
}
