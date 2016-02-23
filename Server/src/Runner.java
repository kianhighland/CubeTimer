import java.io.*;
import java.net.*;

public class Runner implements Runnable{

	private DataOutputStream out;
	private DataInputStream in;
	private Corp corp;

	public Runner(DataOutputStream out, DataInputStream in, Corp corpIn){

		this.out = out;
		this.in = in;
		corp = corpIn;
}

	public void run(){

	}
}
