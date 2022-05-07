package kz.jusan.solidbankapp;

import configs.MyConfig;
import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.cli.AccountBasicCLI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class SOLIDBankApp {
    public static void main(String[] args) throws IOException {
        String help =
                "1 - show accounts\n" +
                "2 - create account\n" +
                "3 - deposit\n" +
                "4 - withdraw\n" +
                "5 - transfer\n" +
                "6 - this message\n" +
                "7 - exit\n";

        ApplicationContext  context = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.print("Welcome to CLI Bank service\nPlease enter operation number:\n");
        System.out.print(help);

        Scanner scanner = context.getBean(Scanner.class);
        AccountBasicCLI accountBasicCLI = context.getBean(AccountBasicCLI.class);

loop:   while (true) {
            String operationNumber = scanner.nextLine();
            switch (operationNumber) {
                case "1" -> {
                    List<Account> accounts = accountBasicCLI.getAccounts("1");
                    if (accounts.isEmpty()) {
                        System.out.println("No one account");
                    } else {
                        System.out.println(accounts);
                    }
                }
                case "2" -> {
                    System.out.println("Choose account type\n[CHECKING, SAVING, FIXED]");
                    if (accountBasicCLI.createAccountRequest("1")) {
                        System.out.println("Bank account created");
                    }
                }
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
