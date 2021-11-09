import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 * @author Leo Alvarado
 * @version 1.0
 */
public class RemoteClass extends UnicastRemoteObject implements RemoteInterface {

    // Chat identifier.
    private final String name;
    // Remote interface whether for Client or Server.
    private RemoteInterface client = null;

    /**
     * Class constructor for RemoteClass.
     * @param userName The name of user which will identify the connection.
     * @throws RemoteException If super() method fails throws an exception.
     */
    public RemoteClass(String userName) throws RemoteException {
        super();
        this.name = userName;
    }

    /**
     * Method definition for getting username.
     * @return The username from the constructor.
     */
    @Override
    public String getName() throws RemoteException {
        return this.name;
    }

    /**
     * Method definition for sending a message, it prints to console a message.
     * @param message A string containing the information to be printed.
     */
    @Override
    public void send(String message) throws RemoteException {
        System.out.println("\n"+message);
    }

    /**
     * Method definition to link two remote interfaces (Client<->Server)
     * @param remoteInterface A RemoteInterface instance containing a valid connection.
     */
    @Override
    public void setClient(RemoteInterface remoteInterface) throws RemoteException {
        this.client = remoteInterface;
    }

    /**
     * Method definition for getting client reference.
     * @return An instance of RemoteInterface interface.
     */
    @Override
    public RemoteInterface getClient() throws RemoteException {
        return this.client;
    }

    /**
     * Main method for server initialization.
     * @param args Receive only one parameter. 1st: Connection port.
     */
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        RemoteInterface server = new RemoteClass("server");
        Naming.rebind("rmi://" + java.net.InetAddress.getLocalHost().getHostAddress() +
                ":" + args[0] + "/PruebaRMI", server);

        System.out.println("Server Ready!");
        while(true){
            System.out.println("Enter a message: ");
            if(server.getClient() != null)
                server.getClient().send("["+server.getName()+"]=> "+scanner.nextLine());
        }

    }

}
