package connection;

import java.io.*;
import java.net.*;
import server.*;
import fields.Fields;
import fields.Constants;
import java.util.ArrayList;
import staticpackage.PrintLine;

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

    public void connectCorp(Socket socket){

        DataOutputStream out;
        DataInputStream in;
        try{
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
        } catch(IOException e){
            System.out.println("IOException when trying to create data output "
                + "and input streams in class connectCorp");
            return;
        }
        String messages = "";
        ArrayList<String> messageList = fields.getMessages();
        for(int i = 0; i<messageList.size(); i++){
            messages = messages + "\n" + messageList.get(i);
        }
        try{
            out.writeUTF(messages);
            out.writeBoolean(true);
        } catch(IOException e){
            System.out.println("IOException when trying to write in class "
                + "ConnectRunner ");
            System.out.println(e);
        }
        corp = new Corp(out, in, output, fields);
        output.setCorp(corp);
        fields.threads.corp = new Thread(corp);
        fields.threads.corp.start();
    }
}
