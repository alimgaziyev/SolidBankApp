package configs;

import kz.jusan.solidbankapp.*;
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
