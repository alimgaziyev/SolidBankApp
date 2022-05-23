import configs.MyConfig;
import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.account.cli.AccountBasicCLI;
import kz.jusan.solidbankapp.cli.MyCLI;
import kz.jusan.solidbankapp.transaction.Transaction;
import kz.jusan.solidbankapp.transaction.cli.TransactionDepositCLI;
import kz.jusan.solidbankapp.transaction.cli.TransactionWithdrawCLI;
import kz.jusan.solidbankapp.transaction.database.MemoryTransactionDAO;
import kz.jusan.solidbankapp.transaction.database.TransactionDOA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.awt.*;
import java.util.Scanner;

@SpringBootApplication
public class SOLIDBankApp implements CommandLineRunner {
    @Autowired
    private ApplicationContext context;
    public static void main(String[] args) { SpringApplication.run(SOLIDBankApp.class); }

    @Override
    public void run(String... args) throws Exception {

        boolean running = true;

        String help =
                        "1 - show accounts\n" +
                        "2 - create account\n" +
                        "3 - deposit\n" +
                        "4 - withdraw\n" +
                        "5 - transactions\n" +
                        "6 - this message\n" +
                        "7 - exit\n";

        System.out.println("Welcome to CLI Bank service");

        MyCLI myCLI = context.getBean(MyCLI.class);
        AccountBasicCLI accountBasicCLI = context.getBean(AccountBasicCLI.class);
        TransactionWithdrawCLI transactionWithdrawCLI  = context.getBean(TransactionWithdrawCLI.class);
        TransactionDepositCLI transactionDepositCLI = context.getBean(TransactionDepositCLI.class);

        loop:   while (running) {
            System.out.print(help);
            System.out.println("Please enter operation number:");
            String operationNumber = myCLI.getScanner().nextLine();
            switch (operationNumber) {
                case "1" -> accountBasicCLI.getAccounts("1").forEach(System.out::println);
                // get client accounts in DOA, by listingService from AccountBasicCLI
                case "2" -> accountBasicCLI.createAccountRequest("1");
                // create new account accountBasicCLI -> BankCore -> CreationService -> add to DOA
                case "3" -> transactionDepositCLI.depositMoney("1");
                // deposit to all type accounts
                case "4" -> transactionWithdrawCLI.withdrawMoney("1");
                // withdraw from !Fixed accounts
                //case "5" -> transactionDOA.getTransactions().forEach(System.out::println);
                // all transaction-operations
                case "6" -> System.out.println(help);
                // print all operations
                case "7" -> {
                    System.out.println("Application closed");
                    running = false;
                }
                default -> System.out.println("Not correct entry");
            }
            System.out.println("next operation ...");
        }
    }
}
