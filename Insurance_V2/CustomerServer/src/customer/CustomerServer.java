package customer;


import Dao.CustomerDao;
import ServerIF.CustomerServerIF;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerServer extends UnicastRemoteObject implements CustomerServerIF {
    CustomerDao dao;
    private static final long serialVersionUID = 1L;
    protected CustomerServer() throws RemoteException{
        super();
        dao = new CustomerDao();
    }
    public static void main(String[] args) {
        try {
            CustomerServer customerServer = new CustomerServer();
            Naming.rebind("//localhost:6060/CustomerServer", customerServer);
            System.out.println("CustomerServer is Ready");
        }catch(RemoteException e){e.printStackTrace();}
        catch (MalformedURLException e){e.printStackTrace();}
    }
    @Override
    public ArrayList<Customer> getCustomerList() throws RemoteException {
        try{
            return dao.retrieveAll();
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateCustomer(int beforeCustomerID, int afterCustomerID, String customerName, String address, int age, String gender, String job) throws RemoteException, SQLException {
        dao.update(beforeCustomerID,new Customer(afterCustomerID,customerName, address, age, gender, job));
    }

    @Override
    public void deleteCustomer(int customerID, String customerName, String address, int age, String gender, String job) throws RemoteException, SQLException {
        dao.delete(new Customer(customerID, customerName, address, age, gender, job));
    }

    @Override
    public void createCustomer(int customerID, String customerName, String address, int age, String gender, String job) throws RemoteException, SQLException {
        dao.create(new Customer(customerID, customerName, address, age, gender, job));
    }
}
