package ServerIF;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Date;


public interface SaleIF extends Remote {
    void createSale(int customerID, String employeeID, int insuranceID) throws RemoteException, SQLException;
}