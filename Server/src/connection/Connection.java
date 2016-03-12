package connection;

import java.io.*;
import java.net.*;
import server.*;
import fields.Fields;
import fields.Constants;

public class Connection{
    
    private ServerSocket serverSocket;
    private Socket socket;
    private DataOutputStream firstOut;
    private DataInputStream firstIn;
    private Output output;
    private ConnectRunner connectRunner;
    private ConnectCorp connectCorp;
    private Fields fields;
    private UserInput userInput;
    private AcceptPlayers acceptPlayers;

    public Connection() throws Exception{

        System.out.print(Constants.normalText);
        write();
        read();
        System.out.println(Constants.normalText + "                            "
            + "                                                                "
            + "                                                                "
            + "                                                                "
            + "                                                              ");
        System.out.print("\b");
        System.out.println();
    	fields = new Fields();
        System.out.println("starting server...");
        serverSocket = new ServerSocket(7665);
        System.out.println("server started");
        output = new Output(fields);
        connectRunner = new ConnectRunner(output, serverSocket, fields);
        connectCorp = new ConnectCorp(output, serverSocket, fields);
        acceptPlayers = new AcceptPlayers(serverSocket, fields,
            connectRunner, connectCorp);
        fields.threads.acceptPlayers = new Thread(acceptPlayers);
        fields.threads.acceptPlayers.start();
        userInput = new UserInput(output, fields);
        fields.threads.userInput = new Thread(userInput);
        fields.threads.userInput.start();
        
    }

    public void write() throws Exception{

        FileWriter fileWriter = new FileWriter("../saves/test.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write("test");
        bufferedWriter.newLine();
        bufferedWriter.write("4");

        bufferedWriter.close();
    }

    public void read() throws Exception{
                                                                                
        FileReader fileReader = new FileReader("../saves/test.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String string = bufferedReader.readLine();
        System.out.println(string);
        string = bufferedReader.readLine();
        int integer = Integer.parseInt(string);
        System.out.println(integer);
        bufferedReader.close();
    }
}
