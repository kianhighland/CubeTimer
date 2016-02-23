import java.io.*;
import java.net.*;

public class Server{

	private ServerSocket serverSocket;
	private Socket socket;
	private DataOutputStream out;

	public Server() throws Exception{

	System.out.println("starting server...");
	serverSocket = new ServerSocket(7665);
	System.out.println("server started");
	socket = serverSocket.accept();
	System.out.println("Client connetcted");
	out = new DataOutputStream(socket.getOutputStream());
	out.writeUTF("This is a test of java sockets");
	}
}
