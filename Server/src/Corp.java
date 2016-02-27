import java.io.*;
import java.net.*;

public class Corp implements Runnable{

    private DataOutputStream out;
    private DataInputStream in;
    private Output output;

    public Corp(DataOutputStream out, DataInputStream in, Output outputIn){

        this.out = out;
        this.in = in;
        output = outputIn;
    }

    public void run(){

        while(true){
            try{
                String message = in.readUTF();
                output.sendMessage(message);
                Thread.sleep(200);
            } catch (Exception e) {
            }
        }
    }

    public void sendMessage(String message) throws Exception{

        out.writeUTF(message);
    }
}
