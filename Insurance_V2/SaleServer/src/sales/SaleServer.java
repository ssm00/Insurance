package sales;

import Dao.SaleDao;
import ServerIF.SaleServerIF;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.Date;

public class SaleServer extends UnicastRemoteObject implements SaleServerIF {
    SaleDao dao;
    private static final long serialVersionUID = 1L;
    protected SaleServer() throws RemoteException {
        super();
        dao = new SaleDao();
    }
    public static void main(String[] args) {
        try {
            SaleServer saleServer = new SaleServer();
            Naming.rebind("//localhost:9090/SaleServer", saleServer);
            System.out.println("SaleServer is Ready");
        }catch(RemoteException e){e.printStackTrace();}
        catch (MalformedURLException e){e.printStackTrace();}
    }
    @Override
    public void createSale(int customerID, String employeeID, int insuranceID, Date salesDate) throws RemoteException, SQLException {
        dao.create(new Sale(customerID, employeeID, insuranceID, salesDate));
    }
}