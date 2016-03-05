import java.io.*;
import java.net.*;

public class Connection{
    
    private ServerSocket serverSocket;
    private Socket socket;
    private DataOutputStream firstOut;
    private DataInputStream firstIn;
    private Output output;
    private ConnectRunner connectRunner;
    private ConnectCorp connectCorp;
    private ConnectPlayers connectPlayers;
    private Fields fields;
    private UserInput userInput;

    public Connection() throws Exception{

        System.out.println(Constants.normalText + "                            "
            + "                                                                "
            + "                                                                "
            + "                                                                "
            + "                                                              ");
    	fields = new Fields();
        System.out.println("starting server...");
        serverSocket = new ServerSocket(7665);
        System.out.println("server started");
        output = new Output();
        connectRunner = new ConnectRunner(output, serverSocket, fields);
        connectCorp = new ConnectCorp(output, serverSocket, fields);
        connectPlayers = new ConnectPlayers(connectRunner, connectCorp,
            serverSocket, fields);
        fields.threads.connectPlayers = new Thread(connectPlayers);
        fields.threads.connectPlayers.start();
        userInput = new UserInput(output, fields);
        fields.threads.userInput = new Thread(userInput);
        fields.threads.userInput.start();
        
    }
}
