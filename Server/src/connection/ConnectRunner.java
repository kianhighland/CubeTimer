package connection;

import java.io.*;
import java.net.*;
import server.*;
import fields.Fields;
import fields.Constants;
import print.PrintLine;

public class ConnectRunner implements Runnable{

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

    public void run(){

        try {
            Socket socket = serverSocket.accept();
            if(Thread.currentThread() != fields.threads.connectRunner){
            	System.out.println(Thread.currentThread());
                System.out.println(fields.threads.connectRunner);
                return;
            }
            firstIn = new DataInputStream(socket.getInputStream());
            String playertype = firstIn.readUTF();
            if(playertype.matches(Constants.runner)){

                connectRunner(socket);
            }
            else{
                                                 
                firstOut = new DataOutputStream(socket.getOutputStream());
                firstOut.writeUTF("Sorry, " + playertype + " did not match "
                    + Constants.runner);
                firstOut.writeBoolean(false);
                firstOut = null;
                run();
            }
        } catch (Exception e) {
            PrintLine.println("Exception in class ConnectRunner method run");
            PrintLine.println("" + e);
            run();
        }
    }

    public void connectRunner(Socket socket) throws Exception{

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());
        out.writeUTF("You have succesfully connected as Runner");
        out.writeBoolean(true);
        runner = new Runner(out, in, output, fields, this);
        output.setRunner(runner);
        fields.threads.runner = new Thread(runner);
        fields.threads.runner.start();
    }
}
