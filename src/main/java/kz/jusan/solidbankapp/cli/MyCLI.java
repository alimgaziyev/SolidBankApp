package kz.jusan.solidbankapp.cli;

import kz.jusan.solidbankapp.account.AccountType;
import kz.jusan.solidbankapp.cli.CLIUI;

import java.util.IllegalFormatException;
import java.util.InputMismatchException;
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
        double amount = 0.0;
        String amountSTR = scanner.nextLine();
        try {
            amount = Double.parseDouble(amountSTR);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return amount;
    }

    public String requestClientAccountNumber() {
        String accountNumber = scanner.nextLine();
        return accountNumber;
    }

}
