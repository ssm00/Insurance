import Dao.InsuranceDao;
import Dao.PremiumRateDao;
import Domain.Insurance;
import Domain.PremiumRate;
import ServerIF.InsuranceIF;
import ServerIF.PremiumRateIF;
import utils.ConnectErrorException;
import utils.EmptyValueException;
import utils.InvalidInputException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class InsuranceServer extends UnicastRemoteObject implements InsuranceIF, PremiumRateIF {
    private static final long serialVersionUID = 1L;
    private InsuranceDao insuranceDao;
    private PremiumRateDao premiumRateDao;

    protected InsuranceServer() throws RemoteException {
        super();
    }

    public static void main(String[] args) throws NotBoundException {
        try {
            InsuranceServer insuranceServer = new InsuranceServer();
            Naming.rebind("InsuranceServer", insuranceServer);
            System.out.println("InsuranceServer is ready !!");
            insuranceServer.insuranceDao = new InsuranceDao();
            insuranceServer.premiumRateDao = new PremiumRateDao();
        }
        catch(RemoteException e) {
            e.printStackTrace();
        }catch(MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Insurance createInsurance(int insuranceID, String insuranceName, int coverageAmount, String coverageEvent, int coveragePeriod, String coverageTarget, int insuranceFee) throws RemoteException {
        Insurance insurance = new Insurance(insuranceID, insuranceName, coverageAmount, coverageEvent, coveragePeriod, coverageTarget, insuranceFee);
        insurance.calculateRate();
        return insurance;
    }

    @Override
    public boolean authorize(Insurance insurance) throws InvalidInputException, ConnectErrorException, EmptyValueException, IOException {
        if (insurance != null) {
            insurance.setAuthorizeState(true);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public float calculateRate(Insurance insurance) {
        float rate = insurance.calculateRate();
        return rate;
    }

    @Override
    public void setInsuranceName(String insuranceName, Insurance insurance) {
        insurance.setInsuranceName(insuranceName);
    }

    @Override
    public PremiumRate getPremiumRate(Insurance insurance) {
        PremiumRate premiumRate = insurance.getPremiumRate();
        return premiumRate;
    }

    @Override
    public void createInsurance(Insurance insurance) {
        insuranceDao.create(insurance);
    }

    @Override
    public void updateInsurance(Insurance beforeInsurance, Insurance afterInsurance) {
        insuranceDao.update(beforeInsurance, afterInsurance);
    }

    @Override
    public void deleteInsurance(Insurance insurance) {
        insuranceDao.delete(insurance);
    }

    @Override
    public ArrayList<Insurance> retrieveAllInsurance() {
        return insuranceDao.retrieveAll();
    }

    @Override
    public PremiumRate createPremiumRate(int premiumRateID, int coverageAmount, String coverageEvent, int coveragePeriod, String coverageTarget, int insuranceFee) {
        PremiumRate premiumRate = new PremiumRate(premiumRateID, coverageAmount, coverageEvent, coveragePeriod, coverageTarget, insuranceFee);
        return premiumRate;
    }

    @Override
    public float calculate(PremiumRate premiumRate) throws RemoteException {
        float rate = premiumRate.calculate();
        return rate;
    }

    @Override
    public boolean update(float accidentRate, float expectedProfitRate) throws InvalidInputException, RemoteException {
        return false;
    }

    @Override
    public void createPremiumRate(PremiumRate premiumRate) {
        premiumRateDao.create(premiumRate);
    }

    @Override
    public void updatePremiumRate(PremiumRate beforePremiumRate, PremiumRate afterPremiumRate) {
        premiumRateDao.update(beforePremiumRate, afterPremiumRate);
    }

    @Override
    public void deletePremiumRate(PremiumRate premiumRate) {
        premiumRateDao.delete(premiumRate);
    }

    @Override
    public ArrayList<PremiumRate> retrieveAllPremiumRate() {
        return premiumRateDao.retrieveAll();
    }
}
