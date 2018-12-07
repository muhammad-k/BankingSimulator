import org.joda.time.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {

       /*
        LocalDate todaysDate = new LocalDate();
        DateTime firstDate = new DateTime(1996, 4, 9, 0, 0);
        DateTime secondDate = new DateTime();
        secondDate.getChronology();

        LocalDateTime currentTime = new LocalDateTime();

        Period period = new Period(firstDate, secondDate);
        System.out.println(currentTime);
        System.out.println(secondDate.getDayOfMonth());
        System.out.println(period.getYears());

        */

        String note = "yeeehaw";
       Transactions.Transaction myTransaction = new Transactions.Transaction(55.0, "Hey");
       System.out.println(myTransaction.getNote());
       System.out.println(myTransaction.getAmount());
       System.out.println(myTransaction.getTransactionNumber());
        System.out.println(myTransaction.transactionDate);

        List<Transactions.Transaction> transactionList = new ArrayList();
        transactionList.add(myTransaction);
        System.out.println( transactionList.get(0).getTransactionNumber());

    }
}
