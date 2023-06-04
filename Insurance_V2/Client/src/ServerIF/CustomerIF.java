package ServerIF;

import Domain.Customer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerIF extends Remote{
    ArrayList<Customer> getCustomerList() throws RemoteException;
    void updateCustomer(int beforeCustomerID, int afterCustomerID, String customerName, String address, int age, String gender, String job) throws RemoteException, SQLException;
    void deleteCustomer(int customerID, String customerName, String address, int age, String gender, String job) throws RemoteException, SQLException;
    void createCustomer(int customerID, String customerName, String address, int age, String gender, String job) throws RemoteException, SQLException;
}