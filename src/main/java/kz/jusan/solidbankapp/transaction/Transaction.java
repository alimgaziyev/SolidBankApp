package kz.jusan.solidbankapp.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Data
public class Transaction {
    private String fromID;
    private String toID;
    private double amount;
    private String date;
    private boolean isDone;
    @Override
    public String toString() {
        return String.format("%.2f$ | from %s to %s | at %s | isTransferred = %s", amount, fromID, toID, date, isDone);
    }
}
