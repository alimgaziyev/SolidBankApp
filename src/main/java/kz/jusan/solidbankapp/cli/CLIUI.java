package kz.jusan.solidbankapp.cli;

import kz.jusan.solidbankapp.account.cli.CreateAccountOperationUI;
import kz.jusan.solidbankapp.transaction.cli.WithdrawDepositOperationCLIUI;

public interface CLIUI extends CreateAccountOperationUI, WithdrawDepositOperationCLIUI {
}
