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
    private boolean successful;
	
    public Runner(){

        successful = false;
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
                                                                                
        try{
            connect(ip);
        } catch(UnknownHostException e){
            System.out.println("UnknownHostExceptionException: " + e);
        } catch(ConnectException e){
            System.out.println("ConnectException: " + e);
        } catch(IOException e){
            System.out.println("IOException: " + e);
        } catch(InterruptedException e){
            System.out.println("InterruptedException: " + e);
        }catch(Exception e){
            System.out.println("InterruptedException: " + e);
        }
        System.out.println("bye");
    }

    public void connect(String ip)
        throws ConnectException, UnknownHostException, IOException,
        InterruptedException{

        socket = new Socket(ip, 7665);
        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());
        out.writeUTF(Constants.runner);
        Thread.sleep(10);
        String message = in.readUTF();
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

        Boolean success = in.readBoolean();

        if(!success){
            System.out.print((char)27 + "[0m");
            System.exit(0);
        }
        actions = new Actions(out);
        input = new Input(in, actions);
        Thread thread = new Thread(input);
        thread.start();
        try{
            actions.write();
        } catch(Exception e){
            System.out.println(e);
        }
        successful = true;
    }
}
