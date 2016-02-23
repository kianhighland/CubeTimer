import java.io.*;
import java.net.*;

public class Runner{

    private final String sRunner = "Runner";

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
	
    public Runner() throws Exception{

	System.out.println("connecting...");
	socket = new Socket("localhost", 7665);
	out = new DataOutputStream(socket.getOutputStream());
	in = new DataInputStream(socket.getInputStream());
	out.writeUTF(sRunner);
	System.out.println(in.readUTF());
	}
}
