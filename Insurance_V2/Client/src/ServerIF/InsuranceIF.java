package ServerIF;

import Domain.Insurance;
import Domain.PremiumRate;
import utils.ConnectErrorException;
import utils.EmptyValueException;
import utils.InvalidInputException;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InsuranceIF extends Remote,PremiumRateIF{
    Insurance createInsurance(int insuranceID, String insuranceName, int coverageAmount, String coverageEvent, int coveragePeriod, String coverageTarget, int insuranceFee) throws RemoteException;
    boolean authorize(Insurance insurance) throws InvalidInputException, ConnectErrorException, EmptyValueException, IOException, RemoteException;
    float calculateRate(Insurance insurance) throws RemoteException;
    void setInsuranceName(String insuranceName, Insurance insurance) throws RemoteException;
    PremiumRate getPremiumRate(Insurance insurance) throws RemoteException;

    //Data
    void createInsurance(Insurance insurance) throws RemoteException;
    void updateInsurance(Insurance beforeInsurance, Insurance afterInsurance) throws RemoteException;
    void deleteInsurance(Insurance insurance) throws RemoteException;
    ArrayList<Insurance> retrieveAllInsurance() throws RemoteException;
}
