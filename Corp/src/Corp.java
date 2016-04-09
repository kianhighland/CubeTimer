import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Corp{

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner userInput;
    private Input input;
    private Actions actions;
    private boolean successful;
    private Fields fields;

    public Corp(){

        successful = false;
        fields = new Fields();
        System.out.println(Constants.normalText + "                            "
            + "                                                                "
            + "                                                                "
            + "                                                                "
            + "                                                              ");
        System.out.print("\b");
        System.out.println();
        userInput = new Scanner(System.in);
        System.out.println("What's the ip?");
        System.out.println("Possible options are:");
        System.out.println("10.0.1.24");
        System.out.println("10.0.1.22");
        String ip = userInput.nextLine();

        connect(ip);
    }

    public void connect(String ip){

        try{
            socket = new Socket(ip, 7665);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            out.writeUTF(Constants.corp);
        } catch(UnknownHostException e){
            System.out.println("UnknownHostExcption in class Corp");
            System.out.println(e);
        } catch(IOException e){
            System.out.println("IOException in class Corp");
            System.out.println(e);
        }

        try{
            Thread.sleep(10);
        } catch(InterruptedException e){
            System.out.println("Interrupted Exception in Thread.sleep in class"
                + "Corp\nPlease change this message if this is planned");
            System.out.println(e);
        }

        String message;
        try{
            message = in.readUTF();
        } catch(IOException e){
            message = "";
            System.out.println("IOException in class Corp trying to readUTF");
            System.out.println(e);
        }
        
        if(message.matches("")){
            return;
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
        } catch(IOException e){
            success = false;
            System.out.println("IOException in class Corp trying to "
                + "readBoolean");
        }

        if(!success){
            System.out.print((char)27 + "[0m");
            System.exit(0);
        }

        try{
            out.writeUTF(Constants.corpActions + "The Corp has joined"
                + Constants.normalText);
        } catch(IOException e){
            System.out.println("IOException in class Corp tring to writeUTF");
            System.out.println(e);
        }

        actions = new Actions(out, fields);
        input = new Input(in, fields);
        Thread thread = new Thread(input);
        thread.start();
        actions.actions();
        successful = true;
    }
}
