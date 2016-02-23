import java.io.*;
import java.net.*;

public class Corp implements Runnable{

	private DataOutputStream out;
	private DataInputStream in;
	private Runner runner;

	public Corp(DataOutputStream out, DataInputStream in, Runner runnerIn){

		this.out = out;
		this.in = in;
		runner = runnerIn;
	}

	public void run(){

	}
}
