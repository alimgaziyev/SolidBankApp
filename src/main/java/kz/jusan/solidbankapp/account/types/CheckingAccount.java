package kz.jusan.solidbankapp.account.types;

import kz.jusan.solidbankapp.account.AccountType;
import kz.jusan.solidbankapp.account.types.AccountWithdraw;

public class CheckingAccount extends AccountWithdraw {
    public CheckingAccount(AccountType accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }
}
