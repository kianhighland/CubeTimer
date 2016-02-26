import java.io.*;
import java.net.*;

public class ConnectPlayers implements Runnable{

    private final String sRunner = "Runner";
    private final String sCorp = "Corp";

    private ConnectRunner connectRunner;
    private ConnectCorp connectCorp;
    private ServerSocket serverSocket;
    private DataInputStream in;
    private DataOutputStream out;

    public ConnectPlayers(ConnectRunner connectRunnerIn,
        ConnectCorp connectCorpIn, ServerSocket serverSocketIn){

        connectRunner = connectRunnerIn;
        connectCorp = connectCorpIn;
        serverSocket = serverSocketIn;
    }

    public void run(){

        Socket socket = serverSocket.accept();
        in = new DataInputStream(socket.getInputStream());
        String playertype = in.readUTF();
        if(playertype.matches(sRunner)){

            connectRunner.connectRunner(socket);
        }

        else if(playertype.matches(sCorp)){

            connectCorp.connectCorp(socket);
        }
        else{

            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Sorry, " + playertype + " did not match" + sRunner
                + " or " + sCorp);
        run();
        }
    }
}
