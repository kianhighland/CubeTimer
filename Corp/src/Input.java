import java.io.*;
import java.net.*;

public class Input implements Runnable{

    private DataInputStream in;
    private Fields fields;

    public Input(DataInputStream inIn, Fields fieldsIn){

        in = inIn;
        fields = fieldsIn;
    }

    public void run(){

        while(true){
            try{
                String message = in.readUTF();
                System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
                System.out.println(message + "              ");
                if(!fields.getLeave()){
                    System.out.print(fields.getMode());
                }
            } catch(Exception e){
            }

            try{
                Thread.sleep(200);
            } catch(Exception e){
            }
        }
    }
}
