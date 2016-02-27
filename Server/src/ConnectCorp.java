import java.io.*;
import java.net.*;

public class ConnectCorp implements Runnable{

    private static String sCorp = "Corp";

    private Corp corp;
    private Output output;
    private ServerSocket serverSocket;
    private DataInputStream firstIn;
    private DataOutputStream firstOut;

    public ConnectCorp(Output outputIn, ServerSocket serverSocketIn){

        output = outputIn;
        serverSocket = serverSocketIn;
    }

    public void run(){

        try {
			Socket socket = serverSocket.accept();
			firstIn = new DataInputStream(socket.getInputStream());
			String playertype = firstIn.readUTF();
			if(playertype.matches(sCorp)){

			    connectCorp(socket);
			}
			else{
			    
			    firstOut = new DataOutputStream(socket.getOutputStream());
			    firstOut.writeUTF("Sorry, " + playertype + " did not match "
			        + sCorp);
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
        corp = new Corp(out, in, output);
        output.setCorp(corp);
        Thread tCorp = new Thread(corp);
        tCorp.start();
    }
}
