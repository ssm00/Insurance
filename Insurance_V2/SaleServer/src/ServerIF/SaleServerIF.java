package ServerIF;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Date;


public interface SaleServerIF extends Remote {
    void createSale(int customerID, String employeeID, int insuranceID, Date salesDate) throws RemoteException, SQLException;
}