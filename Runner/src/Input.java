import java.io.*;
import java.net.*;

public class Input implements Runnable{

    private DataInputStream in;

    public Input(DataInputStream inIn){

        in = inIn;
    }

    public void run(){

        try{
        System.out.println(in.readUTF());
        } catch(Exception e){
        }
        run();
    }
}
