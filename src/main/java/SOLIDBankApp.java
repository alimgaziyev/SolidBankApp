import configs.MyConfig;
import kz.jusan.solidbankapp.AccountBasicCLI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;


public class SOLIDBankApp {
    public static void main(String[] args) {
        ApplicationContext  context = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.print("Welcome to CLI Bank service\nPlease enter operation number:\n");
        System.out.print(
                "1 - show accounts\n" +
                "2 - create account\n" +
                "3 - deposit\n" +
                "4 - withdraw\n" +
                "5 - transfer\n" +
                "6 - this message\n" +
                "7 - exit\n");

        Scanner scanner = context.getBean(Scanner.class);
        AccountBasicCLI accountBasicCLI = context.getBean(AccountBasicCLI.class);

loop:   while (true) {
            String operationNumber = scanner.nextLine();
            switch (operationNumber) {
                case ("1") :
                    accountBasicCLI.getAccounts("1");
                    break;
                case ("2") :
                    accountBasicCLI.createAccountRequest("1");
                    break;
                case ("7") :
                    System.out.println("Application closed");
                    break loop;
                default:
                    System.out.println("Not correct entry");
            }
            System.out.println("next operation ...");
        }
    }
}
