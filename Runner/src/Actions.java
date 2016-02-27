import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Actions{

    private DataOutputStream out;
    private Scanner userInput;

    public Actions(DataOutputStream outIn){

        out = outIn;
        userInput = new Scanner(System.in);
    }

    public void write() throws Exception{

        String message = userInput.nextLine();
        out.writeUTF(Constants.runner + ": " + message);
        write();
    }
}
