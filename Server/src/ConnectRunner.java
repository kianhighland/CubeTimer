import java.io.*;
import java.net.*;

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
            System.out.println("Exception in class ConnectRunner method run");
            run();
        }
    }

    public void connectRunner(Socket socket) throws Exception{

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());
        out.writeUTF("You have succesfully connected as Runner");
        out.writeBoolean(true);
        runner = new Runner(out, in, output);
        output.setRunner(runner);
        fields.threads.runner = new Thread(runner);
        fields.threads.runner.start();
    }
}
