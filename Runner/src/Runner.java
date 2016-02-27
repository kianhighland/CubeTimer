import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Runner{

    private final String sRunner = "Runner";

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner userInput;
    private Input input;
	
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
        Thread.sleep(10);
        System.out.println(in.readUTF());
        input = new Input(in);
        Thread thread = new Thread(input);
        thread.start();
        write();
    }

    public void write() throws Exception{

        String message = userInput.nextLine();
        out.writeUTF(sRunner + ": " + message);
        write();
    }
}
