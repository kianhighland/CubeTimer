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

    public Corp() throws Exception{

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
        socket = new Socket(ip, 7665);
        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());
        out.writeUTF(Constants.corp);
        System.out.println(in.readUTF());
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
    }

/*    public void write() throws Exception{

        String message = userInput.nextLine();
        out.writeUTF(sCorp + ": " + message);
        write();
    }*/
}
