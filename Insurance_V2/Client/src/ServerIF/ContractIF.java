package ServerIF;

import Domain.Contract;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public interface ContractIF extends Remote{
    void renewalExpiredAll() throws RemoteException, SQLException;
    ArrayList<Contract> getExpiredContractList() throws RemoteException, SQLException;
    ArrayList<Contract> getContractList() throws RemoteException;
    void updateContract(int beforeContractID, int afterContractID, int insuranceID, int insuranceFee, Date expirationDate, String coverageDetails) throws RemoteException, SQLException;
    void deleteContract(int contractID, int insuranceID, int insuranceFee, Date expirationDate, String coverageDetails) throws RemoteException, SQLException;
    void createContract(int contractID, int insuranceID, int insuranceFee, Date expirationDate, String coverageDetails) throws RemoteException, SQLException;
}