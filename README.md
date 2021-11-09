# Java RMI
Distributed Systems Practice #2 Part 2 RMI basic chat.

## Commands for compiling and executing this project.

1. Compile the interface.
2. Creates a JAR containing the interface in order to make it available to Client and Server.
```
1. javac RemoteInterface.java
2. jar cvf objRemotos.jar RemoteInterface.class
```

1. Compiles the RemoteClass (server).
2. Using the command rmic compiles the class RemoteClass and generates a .stub file (a server side entity for dispatching communication using IIOP protocol).
```
1. javac RemoteClass.java
2. rmic -d . RemoteClass
```

1. This command creates and start a remote object registery based on a specific port (this allows the communication for RMI).
```
1. rmiregistry 1234
```

1. Executes the server side connection in the port 1234
```
1. java -Djava.rmi.server.hostname=127.0.0.1 RemoteClass 1234
```

1. Compiles the client side connection class.
2. Executes the Client side connetion in localhost and port 1234.
```
1. javac Client.java
2. java Client 127.0.0.1 1234
```
