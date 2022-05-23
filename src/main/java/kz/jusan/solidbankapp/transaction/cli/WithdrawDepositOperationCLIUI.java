package kz.jusan.solidbankapp.transaction.cli;

import org.springframework.stereotype.Component;

@Component
public interface WithdrawDepositOperationCLIUI {
    double requestClientAmount();
    String requestClientAccountNumber();
}
