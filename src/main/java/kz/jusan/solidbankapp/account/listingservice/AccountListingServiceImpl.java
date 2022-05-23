package kz.jusan.solidbankapp.account.listingservice;

import kz.jusan.solidbankapp.account.database.AccountDAO;
import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.account.types.AccountWithdraw;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountListingServiceImpl implements AccountListingService {
    private AccountDAO accountDAO;

    public AccountListingServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountDAO.getClientAccounts(clientID);
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        return accountDAO.getClientWithDrawAccount(clientID, accountID);
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        return accountDAO.getClientAccount(clientID, accountID);
    }





    @Override
    public List<Account> getClientAccountsByType() {
        return null;
    }
}
