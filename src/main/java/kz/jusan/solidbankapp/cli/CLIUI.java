package kz.jusan.solidbankapp.cli;

import kz.jusan.solidbankapp.account.cli.CreateAccountOperationUI;
import kz.jusan.solidbankapp.transaction.cli.WithdrawDepositOperationCLIUI;
import org.springframework.stereotype.Component;

@Component
public interface CLIUI extends CreateAccountOperationUI, WithdrawDepositOperationCLIUI {
}
