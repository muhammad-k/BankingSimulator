import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.joda.time.DateTime;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bank {
    private Double balance;
    private LocalTime openTime = LocalTime.of(9,0);
    private LocalTime closeTime = LocalTime.of(22,0);
    private List<Patron> customerList = new ArrayList<>();
    private Multimap<UUID, Account> accountListByUUID = ArrayListMultimap.create();


    //Maybe the bank shouldn't take any values and be hard coded in, because the bank
    //would be agnostic of users (maybe?)
    public Bank(){
    }

    public Boolean addAccount(Patron patron, Account account){
        accountListByUUID.put(patron.getPatronID(), account);
        return true;
    }

    public Double getBalance() { return this.balance;}
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
        return true;
    }

    public Boolean customerSearch(String firstName, String lastName, DateTime dob){
        for(int i =0; i<customerList.size(); i++)
        {
           if( (customerList.get(i).getLastName() == lastName) &&
               (customerList.get(i).getFirstName() == firstName) &&
               (customerList.get(i).getDateOfBirth() == dob)
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

    public Boolean customerSearch(String firstName, String lastName){
        for(int i =0; i<customerList.size(); i++)
        {
            if( (customerList.get(i).getLastName() == lastName) &&
                (customerList.get(i).getFirstName() == firstName)
            )
                return true;
        }

        return false;
    }

    public List<Patron> getCustomerList() {
        return customerList;
    }

    //This is what updates a customer's account. Passing variables would look like
    //updateAccountValue(accountListByUUID, Patron.getUID(), savingsAccount, newSavingsAccount)
    public static <K,V> boolean updateAccountValue(Multimap<K,V> map, K key, V oldValue, V newValue) {
        if (map.remove(key, oldValue)) {
            map.put(key, newValue);
            return true;
        }
        return false;
    }

    //Operation Times
    //Days Open


}
