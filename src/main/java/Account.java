import Transactions.TransactionList;
import org.joda.time.LocalDateTime;

import java.util.UUID;

public interface Account {


    public UUID getAccountNumber();
    public Double getBalance();
}
