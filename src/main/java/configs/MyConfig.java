package configs;

import kz.jusan.solidbankapp.bank.BankCore;
import kz.jusan.solidbankapp.account.cli.AccountBasicCLI;
import kz.jusan.solidbankapp.cli.MyCLI;
import kz.jusan.solidbankapp.account.creationservice.AccountCreationServiceImpl;
import kz.jusan.solidbankapp.account.database.MemoryAccountDAO;
import kz.jusan.solidbankapp.account.listingservice.AccountListingServiceImpl;
import kz.jusan.solidbankapp.transaction.cli.TransactionDepositCLI;
import kz.jusan.solidbankapp.transaction.cli.TransactionWithdrawCLI;
import kz.jusan.solidbankapp.transaction.database.MemoryTransactionDAO;
import kz.jusan.solidbankapp.transaction.deposit.TransactionDeposit;
import kz.jusan.solidbankapp.transaction.deposit.depositservice.AccountDepositServiceImpl;
import kz.jusan.solidbankapp.transaction.withdraw.TransactionWithdraw;
import kz.jusan.solidbankapp.transaction.withdraw.withdrawservice.AccountWithdrawServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class MyConfig {
    @Bean
    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    @Bean
    public MyCLI getMyCLI() {
        return new MyCLI(getScanner());
    }

    @Bean
    public AccountBasicCLI getAccountBasicCLI() {
        return new AccountBasicCLI(getMyCLI(), getBankCore(), getAccountListingServiceImpl());
    }

    @Bean
    public AccountListingServiceImpl getAccountListingServiceImpl() {
        return new AccountListingServiceImpl(getMemoryAccountDAO());
    }

    @Bean
    public BankCore getBankCore() {
        return new BankCore(getAccountCreationServiceImpl());
    }

    @Bean
    public AccountCreationServiceImpl getAccountCreationServiceImpl() {
        return new AccountCreationServiceImpl(getMemoryAccountDAO());
    }

    @Bean
    public MemoryAccountDAO getMemoryAccountDAO() {
        return new MemoryAccountDAO();
    }

    @Bean
    public AccountWithdrawServiceImpl getAccountWithdrawService() {
        return new AccountWithdrawServiceImpl(getMemoryAccountDAO());
    }

    @Bean
    public AccountDepositServiceImpl getAccountDepositService() {
        return new AccountDepositServiceImpl(getMemoryAccountDAO());
    }

    @Bean
    public MemoryTransactionDAO getTransactionDAO() {
        return new MemoryTransactionDAO();
    }
    @Bean
    public TransactionWithdraw getTransactionWithdraw() {
        return new TransactionWithdraw(getAccountWithdrawService(), getTransactionDAO());
    }

    @Bean
    public TransactionDeposit getTransactionDeposit() {
        return new TransactionDeposit(getAccountDepositService(), getTransactionDAO());
    }

    @Bean
    public TransactionWithdrawCLI getTransactionWithdrawCLI() {
        return new TransactionWithdrawCLI(getTransactionWithdraw(), getMyCLI(), getAccountListingServiceImpl());
    }

    @Bean
    public TransactionDepositCLI getTransactionDepositCLI() {
        return new TransactionDepositCLI(getTransactionDeposit(), getMyCLI(), getAccountListingServiceImpl());
    }
}
