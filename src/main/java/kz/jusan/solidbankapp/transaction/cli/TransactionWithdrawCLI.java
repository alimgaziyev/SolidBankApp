package kz.jusan.solidbankapp.transaction.cli;

import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.account.listingservice.AccountListingService;
import kz.jusan.solidbankapp.account.types.AccountWithdraw;
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
        System.out.println("Type account ID");
        String accountNumber = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        AccountWithdraw account = accountListing.getClientWithdrawAccount(clientID, accountNumber);
        if (account == null) {
            System.out.println("Not found account or withdraw not allowed with this account");
            return;
        }

        System.out.println("Type Amount of money for withdraw");
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        if (amount <= 0) {
            System.out.println("illegal amount value");
            return;
        }

        if (transactionWithdraw.execute(account, amount)) {
            System.out.printf("%.2f$ transferred to %s account\n", amount, accountNumber);
        } else {
            System.out.println("operation failed, please try again");
        }
    }
}
