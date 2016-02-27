import java.io.*;
import java.net.*;

public class ConnectRunner implements Runnable{

    private final String sRunner = "Runner";

    private Runner runner;
    private Output output;
    private ServerSocket serverSocket;
    private DataInputStream firstIn;
    private DataOutputStream firstOut;

    public ConnectRunner(Output outputIn, ServerSocket serverSocketIn){

        output = outputIn;
        serverSocket = serverSocketIn;
    }

    public void run(){

        try {
			Socket socket = serverSocket.accept();
			firstIn = new DataInputStream(socket.getInputStream());
			String playertype = firstIn.readUTF();
			if(playertype.matches(sRunner)){

			    connectRunner(socket);
			}
			else{
			    
			    firstOut = new DataOutputStream(socket.getOutputStream());
			    firstOut.writeUTF("Sorry, " + playertype + " did not match "
			        + sRunner);
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
        runner = new Runner(out, in, output);
        output.setRunner(runner);
        Thread tRunner = new Thread(runner);
        tRunner.start();
    }
}
