package connection;

import java.io.*;
import java.net.*;
import fields.Fields;
import fields.Constants;
import staticpackage.PrintLine;

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

        connect();
        run();
    }

    public void connect(){

        Socket socket;
        try{
            socket = serverSocket.accept();
        } catch(IOException e){
            System.out.println("IOException trying to accept players in the"
                + " class AcceptPlayers");
            System.out.println(e);
            return;
        }
        try{
            firstIn = new DataInputStream(socket.getInputStream());
        } catch(IOException e){
            System.out.println("IOException creating DataInputStream");
            System.out.println(e);
            try{
                firstOut = new DataOutputStream(socket.getOutputStream());
                firstOut.writeUTF("Sorry, we were unable to create an"
                    + "inputStream");
                firstOut.writeBoolean(false);
            } catch(IOException f){
                System.out.println("IOException trying to create outputStream"
                    + "or input stream");
                System.out.println(f);
            }
            return;
        }
        String playertype;
        try{
            playertype = firstIn.readUTF();
        } catch(IOException e){
            System.out.println("IOException trying to read from connection");
            System.out.println(e);
            playertype = "problem reading";
        }
        
        if(fields.getConnectRunner() && playertype.matches(Constants.runner)){
            connectRunner.connectRunner(socket);
            fields.setConnectRunner(false);
        }
        else if(fields.getConnectCorp() && playertype.matches(Constants.corp)){
            connectCorp.connectCorp(socket);
            fields.setConnectCorp(false);
        }
        else{
            try{
                firstOut = new DataOutputStream(socket.getOutputStream());
            } catch(IOException e){
                System.out.println("IOException when trying to create "
                    + "DataOutputStream");
                System.out.println(e);
                return;
            }
            try{
                firstOut.writeUTF("Sorry you did not connect\nWe accept "
                    + Constants.corp + " : " + fields.getConnectCorp() + "\n"
                    + "We accept " + Constants.runner + " : "
                    + fields.getConnectRunner() + "\nYou were a: "+ playertype);
                firstOut.writeBoolean(false);
            } catch(IOException e){
                System.out.println("IOException when trying to write");
                System.out.println(e);
            }
        }
    }
}
