import com.sun.org.apache.xpath.internal.operations.Bool;
import org.joda.time.DateTime;
import org.joda.time.Period;

import java.io.IOException;
import java.util.UUID;

public class Patron {
    private String firstName;
    private String lastName;
    private DateTime dateOfBirth;
    private Boolean isMinor;
    private Double inWallet;
    private UUID patronID;

    public Patron(String firstName, String lastName, DateTime dateOfBirth, Double inWallet ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.isMinor = setIsUnder18(dateOfBirth);
        this.inWallet = inWallet;
        patronID = UUID.randomUUID();
    }

    public String checkCharString(String name) throws IOException{
        if(checkOnlyCharacters(firstName))
            return firstName;
        else
            throw new IOException(){};
    }

    public DateTime setDateOfBirth(Integer year, Integer month, Integer day) {
        DateTime dateOfBirth = new DateTime(year, month, day, 0,0 );
        setIsUnder18(dateOfBirth);
        return dateOfBirth;
    }

    private Boolean setIsUnder18(DateTime dateOfBirth){
        //Setting time and checking the difference in years
        DateTime currentDate = new DateTime();
        currentDate.getChronology();
        Period period = new Period(dateOfBirth, currentDate);

        //Basing availability of accounts on age
        if(period.getYears() > 18)
            return false;
        else
            return true;

    }

    Double getInWallet(){return this.inWallet;}

    UUID getPatronID(){
        return this.patronID;
    }

    DateTime getDateOfBirth(){
        return this.dateOfBirth;
    }

    Boolean getIsMinor(){
        return isMinor;
    }

    String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){return this.lastName;}

    //Sanitizing user input -- returns false is !characters only
    private Boolean checkOnlyCharacters(String name){
            char[] chars = name.toCharArray();

            for (char c : chars) {
                if(!Character.isLetter(c)) {
                    return false;
                }
            }
            return true;
        }

    public void postDepositInWalletBalance(Double balance){
        this.inWallet -= balance;
    }

    public void postWithdrawalInWalletBalance(Double balance){
        this.inWallet += balance;
    }


    //Adding a new customer


    // public Boolean isTellerFree(){}
    // public void currentBalance(){}
    // public Boolean makeDeposit()
    //public Boolean requestBalance(){ }
}




