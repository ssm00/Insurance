package ServerIF;

import Domain.Insurance;
import Domain.UW;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UwIF extends Remote {
    UW createUW() throws RemoteException;
    boolean doUnderWriting(UW uw, Insurance insurance) throws RemoteException;
    double reinsuranceProcessSign(UW uw, Insurance insurance) throws RemoteException;
    boolean validateReinsurance(Insurance insurance) throws RemoteException;
    float calculateLossRate(String accidentType, int coverageLimit, int insuranceFee, int paidAmount) throws RemoteException;
}
