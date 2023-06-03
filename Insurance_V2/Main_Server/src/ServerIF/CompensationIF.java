package ServerIF;

import Domain.Compensation;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface CompensationIF extends Remote {
    Compensation createCompensation(int compensationId, int compensationMoney, int damage, int evaluation)throws RemoteException;
    //Data
    void createCompensation(Compensation compensation) throws RemoteException;
    void updateCompensation(Compensation beforeCompensation, Compensation afterCompensation) throws RemoteException;
    void deleteCompensation(Compensation compensation) throws RemoteException;
    ArrayList<Compensation> retrieveAllCompensation() throws RemoteException;
    Compensation retrieveCompensation(int compensationId) throws RemoteException;
}
