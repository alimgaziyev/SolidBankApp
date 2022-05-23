package kz.jusan.solidbankapp.account.creationservice;

import kz.jusan.solidbankapp.account.AccountType;
import org.springframework.stereotype.Service;

@Service
public interface AccountCreationService {
    public boolean create(AccountType accountType, long bankID, String clientID, long accountID);
}
