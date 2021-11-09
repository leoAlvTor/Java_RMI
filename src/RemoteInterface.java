import java.rmi.RemoteException;

public interface RemoteInterface extends java.rmi.Remote{
    String getName() throws RemoteException;
    void send(String message) throws RemoteException;
    void setClient(RemoteInterface remoteInterface) throws RemoteException;
    RemoteInterface getClient() throws RemoteException;
}
