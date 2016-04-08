import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Runner{

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner userInput;
    private Input input;
    private Actions actions;
    private Fields fields;
    private boolean successful;
	
    public Runner(){

        successful = false;
        fields = new Fields();
        System.out.println(Constants.normalText + "                            "
            + "                                                                "
            + "                                                                "
            + "                                                                "
            + "                                                              ");
        System.out.print(Constants.normalText + "\b");
        System.out.println(Constants.normalText);
        userInput = new Scanner(System.in);
        System.out.println("What't the ip?");
        System.out.println("Possible options are:");
        System.out.println("10.0.1.24");
        System.out.println("10.0.1.22");
        System.out.println("24.9.62.120");
        String ip = userInput.nextLine();
                                                                                
        connect(ip);
    }

    public void connect(String ip){

        try{
            socket = new Socket(ip, 7665);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            out.writeUTF(Constants.runner);
        } catch(ConnectException e){
            System.out.println("ConnectException " + e);
            System.out.println("1");
            return;
        } catch(IOException e){
            System.out.println("IOException " + e);
            System.out.println("1");
        }
        try{
            Thread.sleep(10);
        } catch(InterruptedException e){
            System.out.println("Interruped Exception " + e);
            System.out.println("2");
        }
            String message;
        try{
            message = in.readUTF();
        } catch (IOException e){
            System.out.println("IOException" + e);
            System.out.println("3");
            message = "IOException" + e;
        }
        System.out.println("First normal" + (char)27 + "[30m" + "black"
            + (char)27 + "[31m" + "red" + (char)27 + "[32m" + "green" + (char)27
            + "[33m" + "yellow" + (char)27 + "[34m" + "blue" + (char)27 + "[35m"
            + "magenta" + (char)27 + "[36m" + "cyan" + (char)27 + "[37m"
            + "white");
        System.out.println("Second bright" + (char)27 + "[1m" + (char)27
            +"[30m" + "black" + (char)27 + "[31m" + "red" + (char)27 + "[32m"
            + "green" + (char)27 + "[33m" + "yellow" + (char)27 + "[34m"
            + "blue" + (char)27 + "[35m" + "magenta" + (char)27 + "[36m"
            + "cyan" + (char)27 + "[37m" + "white" + Constants.normalText);
        System.out.println(message);

        Boolean success;
        try{
            success = in.readBoolean();
        } catch (IOException e){
            System.out.println("IOException " + e);
            System.out.println("4");
            success = false;
        }

        if(!success){
            System.out.print((char)27 + "[0m");
            System.exit(0);
        }
        actions = new Actions(out, fields);
        input = new Input(in, fields);
        Thread thread = new Thread(input);
        try{
            out.writeUTF(Constants.runnerActions + "The Runner has joined");
        } catch(Exception e){
            System.out.println("IOException " + e);
            System.out.println("5");
        }
        thread.start();
        actions.actions();
        successful = true;
    }
}
