import java.io.*;
import java.net.*;

public class Corp implements Runnable{

    private DataOutputStream out;
    private DataInputStream in;
    private Runner runner;

    public Corp(DataOutputStream out, DataInputStream in, Runner runnerIn){

        this.out = out;
        this.in = in;
        runner = runnerIn;
    }

    public void run(){

        try{
            String message = in.readUTF();
            sendMessage(message);
            runner.sendMessage(message);
        } catch (Exception e) {
        }
        run();
    }

    public void sendMessage(String message) throws Exception{

        out.writeUTF(message);
    }
}
