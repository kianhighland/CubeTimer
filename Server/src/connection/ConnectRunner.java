package connection;

import java.io.*;
import java.net.*;
import server.*;
import fields.Fields;
import fields.Constants;
import staticpackage.print;
import staticpackage.print;

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

    public void connectRunner(Socket socket) throws Exception{

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());
        String messages = "";
        ArrayList<String> messageList = fields.getMessages();
        for(int i = 0; i<messageList.size(); i++){
            messages = messages + "\n" + messageList.get(i);
        }
        out.writeUTF(messages);
        out.writeBoolean(true);
        runner = new Runner(out, in, output, fields);
        output.setRunner(runner);
        fields.threads.runner = new Thread(runner);
        fields.threads.runner.start();
    }
}
