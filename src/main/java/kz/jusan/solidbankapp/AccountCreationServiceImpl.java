package kz.jusan.solidbankapp;

public class AccountCreationServiceImpl implements AccountCreationService {
    private AccountDAO accountDAO;

    public AccountCreationServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        accountDAO.createNewAccount(new Account(accountType, Long.toString(accountID), clientID, 0, false));
    }
}
