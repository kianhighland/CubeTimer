package connection;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import server.*;
import fields.Fields;
import fields.Constants;
import staticpackage.PrintLine;

public class ConnectRunner{

    private Runner runner;
    private Output output;
    private ServerSocket serverSocket;
    private DataInputStream firstIn;
    private DataOutputStream firstOut;
    private Fields fields;

    public ConnectRunner(Output outputIn, ServerSocket serverSocketIn,
        Fields fieldsIn){

        output = outputIn;
        serverSocket = serverSocketIn;
        fields = fieldsIn;
    }

    public void connectRunner(Socket socket){

        DataOutputStream out;
        DataInputStream in;
        try{
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
        } catch(IOException e){
            System.out.println("IOException when trying to create data output "
                + "and input streams in class connectRunner");
            System.out.println(e);
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
                + "ConnectRunner");
            System.out.println(e);
        }
        runner = new Runner(out, in, output, fields);
        output.setRunner(runner);
        fields.threads.runner = new Thread(runner);
        fields.threads.runner.start();
    }
}
