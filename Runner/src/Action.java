import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Action{

    private DataOutputStream out;
    private DataInputStream in;
    private Scanner userInput;

    public Action(DataOutputStream outIn, DataInputStream inIn){

        out = outIn;
        in = inIn;
        userInput = new Scanner(System.in);
    }

    public void write() throws Exception{

        String message = userInput.nextLine();
        out.writeUTF(Constants.runner + ": " + message);
        write();
    }
}
