package kz.jusan.solidbankapp.account.cli;

import kz.jusan.solidbankapp.account.AccountType;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public interface CreateAccountOperationUI {
    public AccountType requestAccountType();
}
