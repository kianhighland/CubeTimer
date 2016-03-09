package connection;

import java.io.*;
import java.net.*;
import server.*;
import fields.Fields;
import fields.Constants;
import print.PrintLine;

public class ConnectCorp{

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

    public void connectCorp(Socket socket) throws Exception{

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());
        out.writeUTF("You have succesfully connected as Corp");
        out.writeBoolean(true);
        corp = new Corp(out, in, output, fields);
        output.setCorp(corp);
        fields.threads.corp = new Thread(corp);
        fields.threads.corp.start();
    }
}
