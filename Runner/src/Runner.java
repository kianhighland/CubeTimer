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
        System.out.print("\b");
        System.out.println();
        userInput = new Scanner(System.in);
        System.out.println("What't the ip?");
        System.out.println("Possible options are:");
        System.out.println("10.0.1.24");
        System.out.println("10.0.1.22");
        String ip = userInput.nextLine();
        try{
            connect(ip);
        } catch(Exception e){
            System.out.println(e);
            try{
                connect(ip);
            } catch(Exception f){
                System.out.println(e);
            }
        }
        System.out.println(20);
        if(!successful){
            try{
                connect(ip);
            } catch(Exception e){
                System.out.println(e);
            }
        }
        System.out.println(successful);
    }

    public void connect(String ip) throws Exception{

        socket = new Socket(ip, 7665);
        System.out.println(1);
        out = new DataOutputStream(socket.getOutputStream());
        System.out.println(2);
        in = new DataInputStream(socket.getInputStream());
        System.out.println(3);
        out.writeUTF(Constants.runner);
        Thread.sleep(10);
        System.out.println(4);
        Thread.sleep(10);
        System.out.println(5);
        String message = in.readUTF();
        if(message.matches("")){
            successful = false;
            System.out.println("if");
            return;
        }
        else{
            System.out.println(message);
            System.out.println("else");
        }
        System.out.println(6);
        System.out.println(10);
        Boolean success = in.readBoolean();
        if(!success){
            System.exit(0);
        }
        System.out.println("First normal" + (char)27 + "[30m" + "black"
            + (char)27 + "[31m" + "red" + (char)27 + "[32m" + "green" + (char)27            + "[33m" + "yellow" + (char)27 + "[34m" + "blue" + (char)27 + "[35m"
            + "magenta" + (char)27 + "[36m" + "cyan" + (char)27 + "[37m"
            + "white");
        System.out.println("Second bright" + (char)27 + "[1m" + (char)27
            +"[30m" + "black" + (char)27 + "[31m" + "red" + (char)27 + "[32m"
            + "green" + (char)27 + "[33m" + "yellow" + (char)27 + "[34m"
            + "blue" + (char)27 + "[35m" + "magenta" + (char)27 + "[36m"
            + "cyan" + (char)27 + "[37m" + "white" + Constants.normalText);
        actions = new Actions(out);
        input = new Input(in, actions);
        Thread thread = new Thread(input);
        thread.start();
        actions.write();
        successful = true;
    }
}
