package kz.jusan.solid.bank.app;

import java.io.IOException;

public interface CreateAccountOperationUI {
    public AccountType requestAccountType() throws IOException;
}
