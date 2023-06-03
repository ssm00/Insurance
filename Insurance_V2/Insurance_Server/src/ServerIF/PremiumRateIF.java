package ServerIF;

import Domain.PremiumRate;
import utils.InvalidInputException;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface PremiumRateIF extends Remote {
     PremiumRate createPremiumRate(int premiumRateID, int coverageAmount, String coverageEvent, int coveragePeriod, String coverageTarget, int insuranceFee) throws RemoteException;
     float calculate(PremiumRate premiumRate) throws RemoteException;
     boolean update(float accidentRate, float expectedProfitRate) throws RemoteException, InvalidInputException,RemoteException;

     //Data
     void createPremiumRate(PremiumRate premiumRate) throws RemoteException;
     void updatePremiumRate(PremiumRate beforePremiumRate, PremiumRate afterPremiumRate) throws RemoteException;
     void deletePremiumRate(PremiumRate premiumRate) throws RemoteException;
     ArrayList<PremiumRate> retrieveAllPremiumRate() throws RemoteException;
}
