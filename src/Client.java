import java.rmi.Naming;
import java.util.Scanner;

/**
 * @author Leo Alvarado
 * @version 1.0
 */
public class Client {

    /**
     * Main method for client - server communication.
     * Gets interface instance through Naming lookup method.
     * @param args Two args are allowed, 1st: Ip direction. 2nd: Connection Port.
     */
    public static void main(String[] args) throws Exception{
        // Creates a new instance for client connection.
        RemoteInterface client = new RemoteClass("leo");
        // Lookup for server instance in a specific url.
        RemoteInterface server= (RemoteInterface) Naming.lookup("rmi://" +
                args[0] + ":" + args[1] + "/PruebaRMI");
        // Scanner instance for reading keyboard input.
        Scanner scanner = new Scanner(System.in);

        // Link client with our server...
        server.send("Client connected successfully...");
        server.setClient(client);

        // Create an infinite loop to send messages to the server.
        while(true){
            System.out.println("Enter a message:");
            server.send("["+client.getName()+"]=> " + scanner.nextLine().trim());
        }

    }

}
