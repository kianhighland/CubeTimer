package connection;

import java.io.*;
import java.net.*;
import server.*;
import fields.Fields;
import fields.Constants;
import print.PrintLine;

public class ConnectPlayers implements Runnable{

    private ConnectRunner connectRunner;
    private ConnectCorp connectCorp;
    private ServerSocket serverSocket;
    private DataInputStream in;
    private DataOutputStream out;
    private Fields fields;

    public ConnectPlayers(ConnectRunner connectRunnerIn, 
        ConnectCorp connectCorpIn, ServerSocket serverSocketIn,
        Fields fieldsIn){

        connectRunner = connectRunnerIn;
        connectCorp = connectCorpIn;
        serverSocket = serverSocketIn;
        fields = fieldsIn;
    }

    public void run(){

        fields.threads.anoyYou = null;
    		
        try {
            Socket socket = serverSocket.accept();
            in = new DataInputStream(socket.getInputStream());
            Thread.sleep(5);
            String playertype = in.readUTF();
                                                                  
            if(playertype.matches(Constants.runner)){
                                                                                
                connectRunner.connectRunner(socket);
                fields.setConnectCorp(true);
                fields.threads.connectCorp = new Thread(connectCorp);
                fields.threads.connectCorp.start();
            }

            else if(playertype.matches(Constants.corp)){

                connectCorp.connectCorp(socket);
                fields.setConnectRunner(true);
                fields.threads.connectRunner = new Thread(connectRunner);
                fields.threads.connectRunner.start();
            }
                                                                                
            else{
                                                                               
                out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Sorry, " + playertype + " did not match"
                    + Constants.runner + " or " + Constants.corp);
                out.writeBoolean(false);
                run();
            }
        } catch (Exception e) {
            PrintLine.println("Exception in class connectPlayers method run");
            PrintLine.println("" + e);
            run();
        }
        fields.setConnectPlayers(false);
        waiting();
        run();
    }

    public void waiting(){

//        Thread.sleep(2147483647);
        fields.waitObject.waiting();

        if(fields.getConnectPlayers()){
            return;
        }

        else{
            waiting();
            System.out.println("Hello");
        }
    }
}
