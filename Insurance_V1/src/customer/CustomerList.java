package Domain;

import java.util.ArrayList;

public interface CustomerList {

    public boolean add(Customer customer);

    public boolean delete(Customer customer);

    public ArrayList<Customer> retrieve();

    public boolean update();

}
