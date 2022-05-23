package kz.jusan.solidbankapp.transaction.cli;

import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.account.listingservice.AccountListingService;
import kz.jusan.solidbankapp.transaction.cli.WithdrawDepositOperationCLIUI;
import kz.jusan.solidbankapp.transaction.deposit.TransactionDeposit;
import org.springframework.stereotype.Component;

@Component
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
        System.out.println("Type account ID");
        String accountNumber = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        Account account = accountListing.getClientAccount(clientID, accountNumber);
        if (account == null) {
            System.out.println("Not found account");
            return;
        }

        System.out.println("Type Amount of money");
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        if (amount <= 0) {
            System.out.println("illegal amount value");
            return;
        }

        if (transactionDeposit.execute(account, amount)) {
            System.out.printf("%.2f$ transferred to %s account\n", amount, accountNumber);
        } else {
            System.out.println("operation failed, please try again");
        }
    }
}
