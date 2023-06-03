package ServerIF;

import Domain.Demand;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DemandIF extends Remote {
    ArrayList<Demand> getDemandList() throws RemoteException, SQLException;
    void updateDemand(String beforeDemandId, String afterDemandId, int accidentDate, String accidentType,
                      int copyofIdentification, String details, String diagnosis,
                      int documentaryEvidence, String treatmentHospital,
                      String customerName, String accountNumber, String bank,
                      String information) throws RemoteException;
    void deleteDemand(String demandId, int accidentDate, String accidentType,
                      int copyofIdentification, String details, String diagnosis,
                      int documentaryEvidence, String treatmentHospital,
                      String customerName, String accountNumber, String bank,
                      String information) throws RemoteException, SQLException;
    void createDemand(String demandId, int accidentDate, String accidentType,
                      int copyofIdentification, String details, String diagnosis,
                      int documentaryEvidence, String treatmentHospital,
                      String customerName, String accountNumber, String bank,
                      String information) throws RemoteException, SQLException;
}
