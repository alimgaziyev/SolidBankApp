package kz.jusan.solid.bank.app;

import java.io.IOException;
import java.util.Scanner;

public class MyCLI implements CLIUI {
    private Scanner scanner;

    public MyCLI(Scanner scanner) {
        this.scanner = scanner;

    }

    public AccountType requestAccountType() throws IOException {
        String accountType = scanner.nextLine();
        AccountType typeOfAccount = new AccountType(accountType);
        return typeOfAccount;
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
