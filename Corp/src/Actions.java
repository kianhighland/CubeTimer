import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Actions{

    public DataOutputStream out;
    public DataInputStream in;
    public Scanner userInput;
    
    public Actions(DataOutputStream outIn, DataInputStream inIn){

        out = outIn;
        in = inIn;
        userInput = new Scanner(System.in);
    }

    public void write() throws Exception{

        String message = userInput.nextLine();
        String firstChar = message.substring(0, 1);
        if(firstChar.matches(Constants.slash)){
            String secondChar = message.substring(1,2);
            if(secondChar.matches(Constants.q)){
                out.writeUTF(Constants.quit);
                System.exit(0);
            }
            else{
                out.writeUTF(Constants.corp + ": " + message);
            }
        }
        else{
            out.writeUTF(Constants.corp + ": " + message);
        }
        write();
    }

    public void actions() throws Exception{

        String message = userInput.nextLine();
        //Do stuff. Who knows what
    }
}
