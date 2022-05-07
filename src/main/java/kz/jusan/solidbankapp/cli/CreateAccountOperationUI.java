package kz.jusan.solidbankapp.cli;

import kz.jusan.solidbankapp.account.AccountType;

import java.io.IOException;

public interface CreateAccountOperationUI {
    public AccountType requestAccountType() throws IOException;
}
