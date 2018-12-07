import org.joda.time.DateTime;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bank {
    Double balance;
    Integer numberOfPatrons;
    Integer numberOfTransactions;
    LocalTime openTime;
    LocalTime closeTime;
    private List<Patron> customerList = new ArrayList<Patron>();

    public Bank(LocalTime openTime, LocalTime closeTime, Double balance){
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.balance = balance;
    }

    public Double getBalance() {
        return this.balance;}
    public LocalTime getOpenTime(){
        return this.openTime;
    }
    public LocalTime getCloseTime(){
        return this.closeTime;
    }

    public Boolean getIsBankOpen(){
        LocalTime currentTime = LocalTime.now();
        return (currentTime.isAfter(this.openTime) && currentTime.isBefore(this.closeTime));
    }

    public Boolean addPatron(Patron newCustomer){
        customerList.add(newCustomer);
        numberOfPatrons++;

        return true;
    }

    public Integer getNumberOfPatrons(){
        return this.numberOfPatrons;
    }

    public Boolean customerSearch(String firstName, String lastName, DateTime dob){
        for(int i =0; i<customerList.size(); i++)
        {
           if( (customerList.get(i).getLastName() == lastName) &&
               (customerList.get(i).getFirstName() == firstName) &&
               (customerList.get(i).getDateofBirth() == dob)
           )
                return true;
        }

        return false;
    }

    public Boolean customerSearch(UUID userUUID){
        for(int i =0; i<customerList.size(); i++)
        {
            if(customerList.get(i).getPatronID() == userUUID)
                return true;
        }

        return false;
    }

    //Operation Times
    //Days Open


}
