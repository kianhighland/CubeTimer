import java.io.*;
import java.net.*;

public class Runner implements Runnable{

    private DataOutputStream out;
    private DataInputStream in;
    private Corp corp;

    public Runner(DataOutputStream out, DataInputStream in, Corp corpIn){

    this.out = out;
    this.in = in;
    corp = corpIn;
    }

    public void run(){

        try{
        String message = in.readUTF();
        sendMessage(message);
        corp.sendMessage(message);
        } catch (Exception e){
        }
        run();
    }

    public void sendMessage(String message) throws Exception{

        out.writeUTF(message);
    }
}
