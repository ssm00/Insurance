package Domain;

import Domain.Contract;

import java.util.ArrayList;

public class CustomerListImpl implements CustomerList{
    private ArrayList<Customer> customerList;

    public CustomerListImpl(){
        customerList = new ArrayList<Customer>();
    }


    public boolean add(Customer customer){
        customerList.add(customer);
        return true;
    }

    public boolean delete(Customer customer){
        customerList.remove(customer);
        return true;
    }

    public ArrayList<Customer> retrieve(){
        return customerList;
    }

    public boolean update(){
        return false;
    }

}
