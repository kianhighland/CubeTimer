import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Actions{

    private Fields fields;
    private DataOutputStream out;
    private Scanner userInput;
//                                                                             |
    public Actions(DataOutputStream outIn, Fields fieldsIn){
//                                                                             |
        out = outIn;
        userInput = new Scanner(System.in);
        fields = fieldsIn;
    }
//                                                                             |
    public void write() throws Exception{
//                                                                             |
        System.out.print(fields.getMode());
        String message = userInput.nextLine();
        String firstChar = "";
        if(message.length()> 0){
            firstChar = message.substring(0, 1);
        }
        if(firstChar.matches(Constants.slash)){
            String secondChar = message.substring(1, 2);
            if(secondChar.matches(Constants.q)){
                fields.leave();
                out.writeUTF(Constants.runnerActions + "The Runner has left"
                    + Constants.normalText);
                out.writeUTF(Constants.quit);
                System.out.print((char)27 + "[0m");
                System.exit(0);
            }
            else{
                System.out.println(message + "is not recognized as a command");
                System.out.println("Sorry if it should be");
                System.out.println("Please don't start with / if you don't want"
                    + " to type a command");
                System.out.println("If you want to start with /, start with a"
                    + " space and then a slash");
            }
        }
        else{
            out.writeUTF(Constants.runnerChat + Constants.runner + ": "
                + message + Constants.normalText);
        }
        write();
        fields.setMode(Constants.commandMode);
        command();
    }
//                                                                             |
    public void command() throws Exception{
//                                                                             |
        System.out.println("(q)uit");
        System.out.println("(c)hat");
        System.out.print(fields.getMode());
//                                                                             |
        command();
        fields.setMode(Constants.chatMode);
        write();
    }
//                                                                             |
}
