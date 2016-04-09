import java.io.*;
import java.net.*;
import java.util.Scanner;
//                                                                             |
public class Input implements Runnable{
//                                                                             |
    private Fields fields;
    private DataInputStream in;
//                                                                             |
    public Input(DataInputStream inIn, Fields fieldsIn){
//                                                                             |
        in = inIn;
        fields = fieldsIn;
    }
//                                                                             |
    public void run(){
//                                                                             |
        while(true){
//                                                                             |
            try{
                String message = in.readUTF();
                System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
                System.out.println(Constants.normalText +message
                    + "                ");
                if(!fields.getLeave()){
                    System.out.print(fields.getMode().getModeText());
                }
            } catch(Exception e){
                System.out.println("Hey there is an exception in the class "
                    + "Input");
                System.out.println(e);
            }
//                                                                             |
            try{
                Thread.sleep(200);
            } catch(Exception e){
            }
        }
    }                                                           
}
