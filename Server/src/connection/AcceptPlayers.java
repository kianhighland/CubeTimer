package connection;

import java.io.*;
import java.net.*;
import fields.Fields;
import fields.Constants;
import print.PrintLine;

public class AcceptPlayers implements Runnable{

    private ServerSocket serverSocket;
    private DataInputStream firstIn;
    private DataOutputStream firstOut;
    private ConnectRunner connectRunner;
    private ConnectCorp connectCorp;
    private Fields fields;

    public AcceptPlayers(ServerSocket serverSocketIn, Fields fieldsIn,
        ConnectRunner connectRunnerIn, ConnectCorp connectCorpIn){

        serverSocket = serverSocketIn;
        connectRunner = connectRunnerIn;
        connectCorp = connectCorpIn;
        fields = fieldsIn;
    }

    public void run(){

        try{
            connect();
        } catch(Exception e){
            PrintLine.println("" + e);
            run();
        }
    }

    public void connect() throws Exception{

        Socket socket = serverSocket.accept();
        firstIn = new DataInputStream(socket.getInputStream());
        String playertype = firstIn.readUTF();
        
        if(fields.getConnectRunner() && playertype.matches(Constants.runner)){
            connectRunner.connectRunner(socket);
            fields.setConnectRunner(false);
        }
        else if(fields.getConnectCorp() && playertype.matches(Constants.corp)){
            connectCorp.connectCorp(socket);
            fields.setConnectCorp(false);
        }
        else{
            firstOut = new DataOutputStream(socket.getOutputStream());
            firstOut.writeUTF("Sorry you did not connect\nWe accept "
                + Constants.corp + " : " + fields.getConnectCorp() + "\n"
                + "We accept " + Constants.runner + " : "
                + fields.getConnectRunner() + "\nYou were a: " + playertype);
            firstOut.writeBoolean(false);
        }
        
        connect();
    }
}
