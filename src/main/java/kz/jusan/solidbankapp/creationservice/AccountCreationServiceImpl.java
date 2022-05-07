package kz.jusan.solidbankapp.creationservice;

import kz.jusan.solidbankapp.database.AccountDAO;
import kz.jusan.solidbankapp.account.types.CheckingAccount;
import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.account.AccountType;
import kz.jusan.solidbankapp.account.types.FixedAccount;
import kz.jusan.solidbankapp.account.types.SavingAccount;

public class AccountCreationServiceImpl implements AccountCreationService {
    private AccountDAO accountDAO;

    public AccountCreationServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public boolean create(AccountType accountType, long bankID, String clientID, long accountID) {
        boolean isCreated = false;
        try {
            Account account = switch (accountType) {
                case CHECKING -> new CheckingAccount(accountType, Long.toString(accountID), clientID, 0, true);
                case FIXED -> new FixedAccount(accountType, Long.toString(accountID), clientID, 0, false);
                case SAVING -> new SavingAccount(accountType, Long.toString(accountID), clientID, 0, true);
            };
            accountDAO.createNewAccount(account);
            isCreated = true;
        } catch (Exception e) {

        }
        return isCreated;
    }
}
