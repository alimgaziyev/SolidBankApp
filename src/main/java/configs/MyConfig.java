package configs;

import kz.jusan.solidbankapp.bank.BankCore;
import kz.jusan.solidbankapp.cli.AccountBasicCLI;
import kz.jusan.solidbankapp.cli.MyCLI;
import kz.jusan.solidbankapp.creationservice.AccountCreationServiceImpl;
import kz.jusan.solidbankapp.database.MemoryAccountDAO;
import kz.jusan.solidbankapp.listingservice.AccountListingServiceImpl;
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


}
