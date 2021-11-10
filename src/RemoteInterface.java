import java.rmi.RemoteException;
import java.util.List;

/**
 * @author Leo Alvarado
 * @version 1.0
 */
public interface RemoteInterface extends java.rmi.Remote{
    String getName() throws RemoteException;
    void send(String message) throws RemoteException;
    void sendAll(String message) throws RemoteException;
    void setClient(RemoteInterface remoteInterface) throws RemoteException;
    List<RemoteInterface> getClients() throws RemoteException;
    int getNumberOfClients() throws RemoteException;
}
