import java.io.*;
import java.net.*;

public class Input implements Runnable{

    private DataInputStream in;

    public Input(DataInputStream inIn){

        in = inIn;
    }

    public void run(){

        while(true){
            try{
            String message = in.readUTF();
            System.out.println(message);
            } catch(Exception e){
            }
        }
    }
}
