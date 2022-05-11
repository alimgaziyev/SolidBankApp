package kz.jusan.solidbankapp.cli;

import kz.jusan.solidbankapp.account.AccountType;
import kz.jusan.solidbankapp.cli.CLIUI;

import java.util.Scanner;

public class MyCLI implements CLIUI {
    private Scanner scanner;

    public MyCLI(Scanner scanner) {
        this.scanner = scanner;
    }

//    public MyCLI() {
//        this.scanner = new Scanner(System.in);
//    }

    public AccountType requestAccountType() throws IllegalArgumentException{
        String accountType = scanner.nextLine();
        return AccountType.valueOf(accountType);
    }


    public double requestClientAmount() {
        String amount = scanner.nextLine();
        return Double.parseDouble(amount);
    }

    public String requestClientAccountNumber() {
        String accountNumber = scanner.nextLine();
        return accountNumber;
    }

}
