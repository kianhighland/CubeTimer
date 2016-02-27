import java.io.*;
import java.net.*;

public class Connection implements Runnable{
    
    private ServerSocket serverSocket;
    private Socket socket;
    private DataOutputStream firstOut;
    private DataInputStream firstIn;
    private Output output;
    private ConnectRunner connectRunner;
    private ConnectCorp connectCorp;
    private ConnectPlayers connectPlayers;
    private Fields fields;

    public Connection() throws Exception{

    	fields = new Fields();
        System.out.println("starting server...");
        serverSocket = new ServerSocket(7665);
        System.out.println("server started");
        output = new Output();
        connectRunner = new ConnectRunner(output, serverSocket, fields);
        connectCorp = new ConnectCorp(output, serverSocket, fields);
        connectPlayers = new ConnectPlayers(connectRunner, connectCorp,
            serverSocket, fields);
        fields.threads.anoyYou = new Thread(this);
        fields.threads.anoyYou.start();
        fields.threads.connectPlayers = new Thread(connectPlayers);
        fields.threads.connectPlayers.start();
    }

    public void run(){

        System.out.println("anoy you");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        if(fields.threads.anoyYou == Thread.currentThread()){

            run();
        }
    }

/*    public void connectRunner() throws Exception{

        socket = serverSocket.accept();
        firstIn = new DataInputStream(socket.getInputStream());
        String playertype = firstIn.readUTF();
        if(playertype.matches(sRunner)){
            
            DataOutputStream out = 
                new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            out.writeUTF("You have succesfully connected as Runner");
            runner = new Runner(out, in, output);
            output.setRunner(runner);
            Thread tRunner = new Thread(runner);
            corp.setRunner(runner);
            tRunner.start();
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
            corp = new Corp(out, in, Output);
            output.setCorp(corp);
            Thread tCorp = new Thread(corp);
            runner.setCorp(corp);
            tCorp.start();
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
            runner = new Runner(out, in, output);
            output.setRunner(runner);
            Thread tRunner = new Thread(runner);
            tRunner.start();
            connectCorp();
        }
        else if(playertype.matches(sCorp)){
            
            DataOutputStream out =
                new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            out.writeUTF("you have succesfully connected as Corp");
            corp = new Corp(out, in, output);
            output.setCorp(corp);
            Thread tCorp = new Thread(corp);
            tCorp.start();
            connectRunner();
        }
        else{
            
            firstOut = new DataOutputStream(socket.getOutputStream());
            firstOut.writeUTF("Sorry, you did not connect correctly. " +
                    playertype + " did not match " + sRunner + " or " + sCorp);
            connectBoth();
        } 
    }*/
}
