package kz.jusan.solidbankapp.account.listingservice;

import kz.jusan.solidbankapp.account.Account;
import kz.jusan.solidbankapp.account.types.AccountWithdraw;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountListingService {
    public Account getClientAccount(String clientID, String accountID);

    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);
    List<Account> getClientAccounts(String clientID);

    List<Account> getClientAccountsByType();
}
