import configs.MyConfig;
import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.account.cli.AccountBasicCLI;
import kz.jusan.solidbankapp.transaction.Transaction;
import kz.jusan.solidbankapp.transaction.cli.TransactionDepositCLI;
import kz.jusan.solidbankapp.transaction.cli.TransactionWithdrawCLI;
import kz.jusan.solidbankapp.transaction.database.MemoryTransactionDAO;
import kz.jusan.solidbankapp.transaction.database.TransactionDOA;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.awt.*;
import java.util.Scanner;


public class SOLIDBankApp {
    public static void main(String[] args) {
        String help =
                "1 - show accounts\n" +
                "2 - create account\n" +
                "3 - deposit\n" +
                "4 - withdraw\n" +
                "5 - transfer\n" +
                "6 - this message\n" +
                "7 - exit\n";

        System.out.print("Welcome to CLI Bank service\nPlease enter operation number:\n");
        System.out.print(help);

        //annotation
        ApplicationContext  context = new AnnotationConfigApplicationContext(MyConfig.class);

        //beans
        Scanner scanner = context.getBean(Scanner.class);
        AccountBasicCLI accountBasicCLI = context.getBean(AccountBasicCLI.class);
        TransactionWithdrawCLI transactionWithdrawCLI = context.getBean(TransactionWithdrawCLI.class);
        TransactionDepositCLI transactionDepositCLI = context.getBean(TransactionDepositCLI.class);
        MemoryTransactionDAO transactionDOA = context.getBean(MemoryTransactionDAO.class);

loop:   while (true) {
            String operationNumber = scanner.nextLine();
            switch (operationNumber) {
                case "1" -> accountBasicCLI.getAccounts("1").forEach(System.out::println);
                // get client accounts in DOA, by listingService from AccountBasicCLI
                case "2" -> accountBasicCLI.createAccountRequest("1");
                // create new account accountBasicCLI -> BankCore -> CreationService -> add to DOA
                case "3" -> transactionDepositCLI.depositMoney("1");
                // deposit to all type accounts
                case "4" -> transactionWithdrawCLI.withdrawMoney("1");
                // withdraw from !Fixed accounts
                case "5" -> transactionDOA.getTransactions().forEach(System.out::println);
                // all transaction-operations
                case "6" -> System.out.println(help);
                // print all operations
                case "7" -> {
                    System.out.println("Application closed");
                    break loop;
                }
                default -> System.out.println("Not correct entry");
            }
            System.out.println("next operation ...");
        }

    }
}
