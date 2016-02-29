import java.io.*;
import java.net.*;

public class Input implements Runnable{

    private DataInputStream in;
    private Actions actions;

    public Input(DataInputStream inIn, Actions actionsIn){

        in = inIn;
        actions = actionsIn;
    }

    public void run(){

        while(true){
            try{
                String message = in.readUTF();
                System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
                System.out.println(message + "              ");
                System.out.print(actions.getMode());
                Thread.sleep(200);
            } catch(Exception e){
            }
        }
    }
}
