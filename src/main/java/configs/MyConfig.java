package configs;

import kz.jusan.solid.bank.app.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
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
    public Account getAccount() throws IOException {
        return new Account(getAccountType(), "id", "clientID", 0, false);
    }

    @Bean
    public AccountType getAccountType() throws IOException {
        return new AccountType("none");
    }


}
