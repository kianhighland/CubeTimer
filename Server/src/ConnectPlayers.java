import java.io.*;
import java.net.*;

public class ConnectPlayers implements Runnable{

    private ConnectRunner connectRunner;
    private ConnectCorp connectCorp;
    private ServerSocket serverSocket;
    private DataInputStream in;
    private DataOutputStream out;
    private Fields fields;

    public ConnectPlayers(ConnectRunner connectRunnerIn, 
        ConnectCorp connectCorpIn, ServerSocket serverSocketIn,
        Fields fieldsIn){

        connectRunner = connectRunnerIn;
        connectCorp = connectCorpIn;
        serverSocket = serverSocketIn;
        fields = fieldsIn;
    }

    public void run(){

        fields.threads.anoyYou = null;
    		
        try {
            Socket socket = serverSocket.accept();
            in = new DataInputStream(socket.getInputStream());
            String playertype = in.readUTF();
                                                                  
            if(playertype.matches(fields.constants.runner)){
                                                                                
                connectRunner.connectRunner(socket);
                Thread tConnectCorp = new Thread(connectCorp);
                tConnectCorp.start();
            }

            else if(playertype.matches(fields.constants.corp)){

                connectCorp.connectCorp(socket);
                Thread tConnectRunner = new Thread(connectRunner);
                tConnectRunner.start();
            }
                                                                                
            else{
                                                                               
                out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Sorry, " + playertype + " did not match"
                    + fields.constants.runner + " or " + fields.constants.corp);
                out.writeBoolean(false);
                run();
            }
        } catch (Exception e) {
            System.out.println("Exception in class connectPlayers method run");
            System.out.println(e);
            run();
        }
    }
}
