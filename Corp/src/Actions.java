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
        out.writeUTF(Constants.corp + ": " + message);
        write();
    }
}
