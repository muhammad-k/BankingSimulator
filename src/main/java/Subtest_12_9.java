import org.joda.time.DateTime;

public class Subtest_12_9 {

    static Bank Chase = new Bank();

    //This test shows the add patron and the handling of balances.
    /*
    * TRANSACTION
    * TRANSACTION LIST
    * SAVINGS ACCOUNTS
    * TELLER
    *
    * These three classes need to be fleshed out.
    *
    * REPORT
    * */

    public static void main(String args[]) {

        if (Chase.getIsBankOpen()) {

            DateTime dob = new DateTime(2010, 4, 9, 0, 0);
            Patron Bobby = new Patron("Bobby", "Khalil", dob, 5000.0);

            Chase.addPatron(Bobby);

            System.out.println(Bobby.getIsMinor());

            if (Bobby.getIsMinor()) {
                Account juniorAccount = new JuniorAccount(Bobby.getInWallet());
                System.out.println(Bobby.getInWallet());
                Bobby.postDepositInWalletBalance(juniorAccount.getBalance());
                System.out.println(Bobby.getInWallet());
                Chase.addAccount(Bobby, juniorAccount);
                System.out.println("UESSSSSSSSSS");
            }

        } else
            System.out.println("BANK CLOSED");
    }
}
