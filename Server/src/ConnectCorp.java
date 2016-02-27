import java.io.*;
import java.net.*;

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
            firstIn = new DataInputStream(socket.getInputStream());
            String playertype = firstIn.readUTF();
            if(playertype.matches(fields.constants.corp)){

                connectCorp(socket);
            }
            else{
                                                         
                firstOut = new DataOutputStream(socket.getOutputStream());
                firstOut.writeUTF("Sorry, " + playertype + " did not match "
                    + fields.constants.corp);
                firstOut.writeBoolean(false);
                firstOut = null;
                run();
            }
        } catch (Exception e) {
            System.out.println("Exception in class ConectCorp method run");
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
