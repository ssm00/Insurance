package Domain;


import Dao.ContractDao;
import ServerIF.ContractIF;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ContractServer extends UnicastRemoteObject implements ContractIF {
    ContractDao dao;
    private static final long serialVersionUID = 1L;
    protected ContractServer() throws RemoteException{
        super();
        dao = new ContractDao();
    }
    public static void main(String[] args) {
        try {
            ContractServer server = new ContractServer();
            Naming.rebind("//localhost:8080/ContractServer", server);
            System.out.println("ContractServer is Ready");
        }catch(RemoteException e){e.printStackTrace();}
        catch (MalformedURLException e){e.printStackTrace();}
    }

    @Override
    public void renewalExpiredAll() throws RemoteException, SQLException {
        dao.renewalExpiredAll();
    }

    @Override
    public ArrayList<Contract> getExpiredContractList() throws RemoteException, SQLException {
        return dao.retrieveExpired();
    }

    @Override
    public ArrayList<Contract> getContractList() throws RemoteException {
        try{
            return dao.retrieveAll();
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void updateContract(int beforeContractID, int afterContractID, int insuranceID, int insuranceFee, Date expirationDate, String coverageDetails) throws RemoteException, SQLException {
        dao.update(beforeContractID, new Contract(afterContractID, insuranceID, insuranceFee, expirationDate, coverageDetails));
    }
    @Override
    public void deleteContract(int contractID, int insuranceID, int insuranceFee, Date expirationDate, String coverageDetails) throws RemoteException, SQLException {
        dao.delete(new Contract(contractID, insuranceID, insuranceFee, expirationDate, coverageDetails));
    }
    @Override
    public void createContract(int contractID, int insuranceID, int insuranceFee, Date expirationDate, String coverageDetails) throws RemoteException, SQLException {
        dao.create(new Contract(contractID, insuranceID, insuranceFee, expirationDate, coverageDetails));
    }
}
