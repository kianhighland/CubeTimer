import java.io.*;
import java.net.*;

public class Connection{
    
    private final String sRunner = "Runner";
    private final String sCorp = "Corp";

    private ServerSocket serverSocket;
    private Socket socket;
    private DataOutputStream firstOut;
    private DataInputStream firstIn;
    private Runner runner;
    private Corp corp;

    public Connection() throws Exception{

        System.out.println("starting server...");
        serverSocket = new ServerSocket(7665);
        System.out.println("server started");

	connectBoth();
    }

    public void connectRunner() throws Exception{

        socket = serverSocket.accept();
        firstIn = new DataInputStream(socket.getInputStream());
        String playertype = firstIn.readUTF();
        if(playertype.matches(sRunner)){
            
            DataOutputStream out = 
                new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            out.writeUTF("You have succesfully connected as Runner");
            runner = new Runner(out, in, corp);
        }
        else{
            
            connectRunner();
        }
    }

    public void connectCorp() throws Exception{

        socket = serverSocket.accept();
        firstIn = new DataInputStream(socket.getInputStream());
        String playertype = firstIn.readUTF();
        if(playertype.matches(sCorp)){
            
            DataOutputStream out =
                new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            out.writeUTF("You have succesfully connected as Corp");
            corp = new Corp(out, in, runner);
        }
        else{
            
            connectCorp();
        }
    }

    public void connectBoth() throws Exception{

        socket = serverSocket.accept();
        firstIn = new DataInputStream(socket.getInputStream());
        String playertype = firstIn.readUTF();
        if(playertype.matches(sRunner)){
            
            DataOutputStream out =
                new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            out.writeUTF("You have succesfully connected as Runner");
            runner = new Runner(out, in, corp);
            connectCorp();
        }
        else if(playertype.matches(sCorp)){
            
            DataOutputStream out =
                new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            out.writeUTF("you have succesfully connected as Corp");
            corp = new Corp(out, in, runner);
            connectRunner();
        }
        else{
            
            firstOut = new DataOutputStream(socket.getOutputStream());
            firstOut.writeUTF("Sorry, you did not connect correctly. " +
                    playertype + " did not match " + sRunner + " or " + sCorp);
            connectBoth();
        }
    }
}
