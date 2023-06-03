import Dao.CompensationDao;
import Domain.Compensation;
import ServerIF.CompensationIF;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CompensationServer extends UnicastRemoteObject implements CompensationIF {
    private static final long serialVersionUID = 1L;
    private CompensationDao compensationDao;

    protected CompensationServer() throws RemoteException {
        super();
    }

    public static void main(String[] args) throws NotBoundException {
        try {
            CompensationServer compensationServer = new CompensationServer();
            Naming.rebind("CompensationServer", compensationServer);
            System.out.println("CompensationServer is ready !!");
            compensationServer.compensationDao = new CompensationDao();
        }
        catch(RemoteException e) {
            e.printStackTrace();
        }catch(MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Compensation createCompensation(int compensationId, int compensationMoney, int damage, int evaluation) {
        Compensation compensation = new Compensation(compensationId, compensationMoney, damage, evaluation);
        return compensation;
    }

    @Override
    public void createCompensation(Compensation compensation) {
        compensationDao.create(compensation);
    }

    @Override
    public void updateCompensation(Compensation beforeCompensation, Compensation afterCompensation) {
        compensationDao.update(beforeCompensation, afterCompensation);
    }

    @Override
    public void deleteCompensation(Compensation compensation) {
        compensationDao.delete(compensation);
    }

    @Override
    public ArrayList<Compensation> retrieveAllCompensation() {
        return compensationDao.retrieveAll();
    }

    @Override
    public Compensation retrieveCompensation(int compensationId) {
        return null;
    }
}
