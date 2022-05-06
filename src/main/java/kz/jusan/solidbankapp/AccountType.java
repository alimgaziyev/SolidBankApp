package kz.jusan.solidbankapp;

import java.io.IOException;
import java.lang.reflect.Array;

public class AccountType {
    private String type; // Checking, Fixed, Saving

    public AccountType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
}
