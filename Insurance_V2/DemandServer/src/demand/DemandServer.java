package demand;

import Dao.DemandDao;
import ServerIF.DemandServerIF;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

public class DemandServer extends UnicastRemoteObject implements DemandServerIF {

    DemandDao dao;
    private static final long serialVersionUID = 1L;
    protected DemandServer() throws RemoteException {
        super();
        dao = new DemandDao();
    }
    public static void main(String[] args) {
        try {
            DemandServer demandServer = new DemandServer();
            Naming.rebind("//localhost:5050/DemandServer", demandServer);
            System.out.println("DemandServer is Ready");
        }catch(RemoteException | MalformedURLException e){e.printStackTrace();}
    }
    @Override
    public ArrayList<Demand> getDemandList() throws RemoteException, SQLException {
        return dao.retrieveAll();
    }

    @Override
    public void updateDemand(String beforeDemandId, String afterDemandId, int accidentDate, String accidentType, int copyofIdentification, String details, String diagnosis, int documentaryEvidence, String treatmentHospital, String customerName, String accountNumber, String bank, String information) throws RemoteException {
    }

    @Override
    public void deleteDemand(String demandId, int accidentDate, String accidentType, int copyofIdentification, String details, String diagnosis, int documentaryEvidence, String treatmentHospital, String customerName, String accountNumber, String bank, String information) throws RemoteException, SQLException {
        dao.delete(new Demand(demandId, accidentDate, accidentType, copyofIdentification, details, diagnosis, documentaryEvidence, treatmentHospital, customerName, accountNumber, bank, information));
    }

    @Override
    public void createDemand(String demandId, int accidentDate, String accidentType, int copyofIdentification, String details, String diagnosis, int documentaryEvidence, String treatmentHospital, String customerName, String accountNumber, String bank, String information) throws RemoteException, SQLException {
        dao.create(new Demand(demandId, accidentDate, accidentType, copyofIdentification, details, diagnosis, documentaryEvidence, treatmentHospital, customerName, accountNumber, bank, information));
    }
}
