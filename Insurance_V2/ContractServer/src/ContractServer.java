import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ContractServer extends UnicastRemoteObject implements Remote {
    protected ContractServer() throws RemoteException {
        super();
    }

    public static void main(String[] args) {
        try {
            ContractServer contractServer = new ContractServer();
            Naming.rebind("//localhost:8080/ContractServer", contractServer);
            System.out.println("ContractServer is Ready");
        }catch(RemoteException e){e.printStackTrace();}
        catch (MalformedURLException e){e.printStackTrace();}
    }
}