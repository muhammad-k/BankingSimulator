import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.List;

public class Teller {

    String Name;
    Boolean isAvailable;
    List<Patron> customerList = new ArrayList<Patron>();


    public Teller (){
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Account createNewJuniorAccount(Patron customer){
            Account newJuniorAccount = new JuniorAccount(calculateInitialBalanace(customer.getInWallet()));
            return newJuniorAccount;
        }

    public Double calculateInitialBalanace(Double customerAmountInWallet){
        return customerAmountInWallet*.8;
    }
    public void recieveCustomerList(List customerList){
        this.customerList = customerList;
    }


    /*
    public Boolean createNewCheckingAccount(Patron customer, Multimap customerList){
        if(customer.getInWallet()< 500)
            return false;
        else {
            calculateInitialBalanace(customer.getInWallet());
            CheckingAccount newCheckingAccount = new
            return true;
        }
    }
*/
}
