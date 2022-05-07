package kz.jusan.solidbankapp.cli;

import kz.jusan.solidbankapp.account.AccountType;
import kz.jusan.solidbankapp.cli.CLIUI;

import java.util.Scanner;

public class MyCLI implements CLIUI {
    private Scanner scanner;

    public MyCLI(Scanner scanner) {
        this.scanner = scanner;
    }

    public AccountType requestAccountType() throws IllegalArgumentException{
        String accountType = scanner.nextLine();
        return AccountType.valueOf(accountType);
    }

    /*
    public double requestClientAmount() {
        return 0;
    }

    public String requestClientAccountNumber(Account account) {
        return String.format("%03d%06d", 1, account.getID());
    }
    */
}
