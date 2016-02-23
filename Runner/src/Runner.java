import java.io.*;
import java.net.*;
public class Runner{

	private Socket socket;
	private DataInputStream in;
	
	public Runner() throws Exception{

	System.out.println("connecting...");
	socket = new Socket("localhost", 7665);
	System.out.println("Connected");
	in = new DataInputStream(socket.getInputStream());
	System.out.println(in.readUTF());
	}
}
