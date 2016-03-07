package connection;

import java.io.*;
import java.net.*;
import server.*;
import fields.Fields;
import fields.Constants;
import print.PrintLine;

public class ConnectCorp implements Runnable{

    private Corp corp;
    private Output output;
    private ServerSocket serverSocket;
    private DataInputStream firstIn;
    private DataOutputStream firstOut;
    private Fields fields;

    public ConnectCorp(Output outputIn, ServerSocket serverSocketIn,
        Fields fieldsIn){

        output = outputIn;
        serverSocket = serverSocketIn;
        fields = fieldsIn;
    }

    public void run(){

        try {
            Socket socket = serverSocket.accept();
            if(!fields.getConnectCorp()){
                DataOutputStream out
                    = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("");
                return;
            }
            firstIn = new DataInputStream(socket.getInputStream());
            String playertype = firstIn.readUTF();
            if(playertype.matches(Constants.corp)){

                connectCorp(socket);
            }
                                                                
            else{
                                                         
                firstOut = new DataOutputStream(socket.getOutputStream());
                firstOut.writeUTF("Sorry, " + playertype + " did not match "
                    + Constants.corp);
                firstOut.writeBoolean(false);
                firstOut = null;
                run();
            }
        } catch (Exception e) {
            PrintLine.println("Exception in class ConectCorp method run");
        }
    }

    public void connectCorp(Socket socket) throws Exception{

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());
        out.writeUTF("You have succesfully connected as Corp");
        out.writeBoolean(true);
        corp = new Corp(out, in, output);
        output.setCorp(corp);
        fields.threads.corp = new Thread(corp);
        fields.threads.corp.start();
    }
}
