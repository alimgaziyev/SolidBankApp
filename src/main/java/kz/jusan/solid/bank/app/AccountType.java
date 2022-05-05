package kz.jusan.solid.bank.app;

import java.io.IOException;
import java.lang.reflect.Array;

public class AccountType {
    private String type; // Checking, Fixed, Saving

    public AccountType(String type) throws IOException {
        boolean isType = false;
        String[] types = {"CHECKING", "SAVING", "FIXED", "none"};
        for (String tp : types) {
            if (tp.equals(type)) {
                isType = true;
                break;
            }
        }
        if (isType) {
            this.type = type;
        } else {
            throw new IOException("Not correct type, try again");
        }
    }

    public String getType() {
        return type;
    }
}
