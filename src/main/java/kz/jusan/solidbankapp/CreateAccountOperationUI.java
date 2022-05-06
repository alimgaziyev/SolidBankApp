package kz.jusan.solidbankapp;

import java.io.IOException;

public interface CreateAccountOperationUI {
    public AccountType requestAccountType() throws IOException;
}
