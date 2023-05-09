package customer;

import java.util.ArrayList;

public interface CustomerList {

    public boolean add();

    public boolean delete();

    public ArrayList<Customer> retrieve();

    public boolean update();

}
