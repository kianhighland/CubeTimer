import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Runner{

    private final String sRunner = "Runner";

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner userInput;
	
    public Runner() throws Exception{

    	userInput = new Scanner(System.in);
    	System.out.println("What't the ip?");
    	System.out.println("Possible options are:");
    	System.out.println("10.0.1.24");
	System.out.println("10.0.1.22");
    	String ip = userInput.nextLine();
        socket = new Socket(ip, 7665);
        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());
        out.writeUTF(sRunner);
        System.out.println(in.readUTF());
	}
}
