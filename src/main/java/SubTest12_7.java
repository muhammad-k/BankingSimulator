import org.joda.time.DateTime;

import java.time.LocalTime;
import java.util.Scanner;
import java.util.UUID;

public class SubTest12_7 {

    private static LocalTime openTime;
    private static LocalTime closeTime;
    private static Double bankBalance;
    private static Integer choice;


    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        Bank Chase = new Bank(openTime, closeTime, bankBalance);

        //Setting Bank details and current time
        setBankDetails(scanner);

        //Setting patron information
        customerInitialMenu(scanner, Chase);



        while (Chase.getIsBankOpen()) {
            System.out.println("ERRRRR");
        }
    }

    public static void setBankDetails(Scanner scanner) {

        System.out.print("Please enter the hour the bank will open: ");
        Integer openHour = scanner.nextInt();

        System.out.print("Please enter the minute the bank will open: ");
        Integer openMin = scanner.nextInt();
        System.out.println();

        openTime = LocalTime.of(openHour, openMin);

        System.out.print("Please enter the hour the bank will close: ");
        Integer closeHour = scanner.nextInt();

        System.out.print("Please enter the minute the bank will close: ");
        Integer closeMin = scanner.nextInt();
        System.out.println();
        closeTime = LocalTime.of(closeHour, closeMin);

        System.out.print("Enter a Bank Balance: $");
        bankBalance = scanner.nextDouble();
    }

    //Still need to add exceptions
    public static Patron customerInitialMenu(Scanner scanner, Bank Chase) {


        System.out.println("Are you a current customer at Chase? Press 1 for YES, 2 for NO: ");
        choice = scanner.nextInt();

        //Need a do while loop. Maybe a switch
        //do{ } while ((!(choice == 1)) || (!(choice == 2)));

        if (choice == 1)
            System.out.print("This is a current customer");
        else if (choice == 0)
            return addCustomer(scanner, Chase);
        else {
            System.out.println("You have entered an incorrect input, please try again");
        }

        //Need a do while loop. Maybe a switch
        //do{ } while ((!(choice == 1)) || (!(choice == 2)));

        //Return for the sake of returning
        DateTime currentTime = DateTime.now();
        Patron bob = new Patron("Test", "Ignore", currentTime, 50.0);
        return bob;
    }


    public static Patron addCustomer(Scanner scanner, Bank Chase) {

        //Taking in the name
        System.out.print("Please enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Please enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.println();

        //Taking in and setting up the DOB
        System.out.print("Please enter your birth month: ");
        Integer birthMonth = scanner.nextInt();
        System.out.println("Please enter your birth day: ");
        Integer birthDay = scanner.nextInt();
        System.out.println("Please enter your birth year: ");
        Integer birthYear = scanner.nextInt();

        DateTime dob = new DateTime(birthYear, birthMonth, birthDay, 0, 0);

        //Taking a balance(?)
        System.out.println("How much cash you carrying?");
        Double inWallet = scanner.nextDouble();

        Patron newCustomer = new Patron(firstName, lastName, dob, inWallet);
        Chase.addPatron(newCustomer);
        return newCustomer;
    }

    public static Boolean searchCustomer(Scanner scanner, Bank Chase, String firstName, String lastName, DateTime dob) {
        return Chase.customerSearch(firstName, lastName, dob);
    }

    public static Boolean searchCustomerbyID(Scanner scanner, Bank Chase, UUID userID){
        return Chase.customerSearch(userID);
    }

}