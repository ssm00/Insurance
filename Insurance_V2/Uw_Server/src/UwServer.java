import Dao.UWDao;
import Domain.Insurance;
import Domain.UW;
import ServerIF.UwIF;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UwServer extends UnicastRemoteObject implements UwIF {
    private static final long serialVersionUID = 1L;
    private UWDao uwDao;

    protected UwServer() throws RemoteException {
        super();
    }

    public static void main(String[] args) throws NotBoundException {
        try {
            UwServer uwServer = new UwServer();
            Naming.rebind("UwServer", uwServer);
            uwServer.uwDao = new UWDao();
            System.out.println("UwServer is ready !!");
        }
        catch(RemoteException e) {
            e.printStackTrace();
        }catch(MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UW createUW() {
        UW uw = new UW();
        return uw;
    }

    @Override
    public boolean doUnderWriting(UW uw, Insurance insurance) {
        uw.setApplicationForm(true);
        uw.setSecurity(true);
        boolean isAccepted = true;// 자동심사를 통한 인수 여부 결정 수행
        return isAccepted;
    }

    @Override
    public double reinsuranceProcessSign(UW uw, Insurance insurance) {
        // 재보험 검증 및 재보험료 계산
        double reinsuranceFee = uw.calculateReinsuranceFee(insurance);
        return reinsuranceFee;
    }

    @Override
    public boolean validateReinsurance(Insurance insurance) {
        return true;
    }

    @Override
    public float calculateLossRate(String accidentType, int coverageLimit, int insuranceFee, int paidAmount) {
        float lossRate = (float) ((paidAmount * 20) + (insuranceFee * 10) + (coverageLimit * 0.5));
        return lossRate;
    }
}
