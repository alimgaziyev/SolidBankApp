import configs.MyConfig;
import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.account.cli.AccountBasicCLI;
import kz.jusan.solidbankapp.transaction.cli.TransactionDepositCLI;
import kz.jusan.solidbankapp.transaction.cli.TransactionWithdrawCLI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
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

        ApplicationContext  context = new AnnotationConfigApplicationContext(MyConfig.class);
        //ApplicationContext  context = new ClassPathXmlApplicationContext("configXml.xml");
        System.out.print("Welcome to CLI Bank service\nPlease enter operation number:\n");
        System.out.print(help);

        Scanner scanner = context.getBean(Scanner.class);
        //Scanner scanner = new Scanner(System.in);
        AccountBasicCLI accountBasicCLI = context.getBean(AccountBasicCLI.class);
        TransactionWithdrawCLI transactionWithdrawCLI = context.getBean(TransactionWithdrawCLI.class);
        TransactionDepositCLI transactionDepositCLI = context.getBean(TransactionDepositCLI.class);

loop:   while (true) {
            String operationNumber = scanner.nextLine();
            switch (operationNumber) {
                case "1" -> System.out.println(accountBasicCLI.getAccounts("1"));
                // get client accounts in DOA, by listingService from AccountBasicCLI
                case "2" -> accountBasicCLI.createAccountRequest("1");
                // create new account accountBasicCLI -> BankCore -> CreationService -> add to DOA
                case "3" -> transactionDepositCLI.depositMoney("1");
                //
                case "4" -> transactionWithdrawCLI.withdrawMoney("1");
                //
                case "6" -> System.out.println(help);
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
