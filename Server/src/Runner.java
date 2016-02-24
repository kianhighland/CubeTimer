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

        while(true){
            try{
                String message = in.readUTF();
                sendMessage(message);
                corp.sendMessage(message);
            } catch (Exception e){
            }
        }
    }

    public void sendMessage(String message) throws Exception{

        out.writeUTF(message);
    }

    public void setCorp(Corp corpIn){

        corp = corpIn;
    }
}
