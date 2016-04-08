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

    public void actions(){
    
        Modes mode = fields.getMode().getMode();
        if(mode == Modes.CHAT){
            try{
                write();
            } catch(Exception e){
                System.out.println(e);
                System.out.println("That was in the class actions method chat");
            }
        }

        else if(mode == Modes.COMMAND){
            try{
                command();
            } catch(Exception e){
                System.out.println(e);
                System.out.println("Class actions method command");
            }
        }

        else{
            System.out.println("Problem");
            System.out.println("There is an unrecognized mode in the class"
                + "Actions. That mode is " + mode);
        }
        
        actions();
    }
//                                                                             |
    public void write(){
//                                                                             |
        System.out.print(fields.getMode().getModeText());
        String message = userInput.nextLine();
        String firstChar = "";
        if(message.length()> 0){
            firstChar = message.substring(0, 1);
        }
        if(firstChar.matches(Constants.slash)){
            String secondChar = message.substring(1, 2);
            if(secondChar.matches(Constants.q)){
                fields.leave();
                try{
                    out.writeUTF(Constants.runnerActions + "The Runner has left"
                        + Constants.normalText);
                    out.writeUTF(Constants.quit);
                } catch(IOException e){
                    System.out.println("There was an IOException when trying to"
                        + " send to the Server. This was in the class Actions");
                    System.out.println(e);
                }
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
            try{
                out.writeUTF(Constants.runnerChat + Constants.runner + ": "
                    + message + Constants.normalText);
            } catch(IOException e){
                System.out.println("There was an IOException when trying to "
                    + "write to the Server. This was in the class Actions");
                System.out.println(e);
            }
        }
    }
//                                                                             |
    public void command(){
//                                                                             |
        System.out.println("(q)uit");
        System.out.println("(c)hat");
        System.out.print(fields.getMode().getModeText());
        String message = userInput.nextLine();
        if(message.length() > 0){
            String firstChar = message.substring(0,1);
            if(firstChar.matches(Constants.q)){
                fields.leave();
                try{
                    out.writeUTF(Constants.runnerActions + "The Runner has left"
                        + Constants.normalText);
                    out.writeUTF(Constants.quit);
                } catch(IOException e){
                    System.out.println("There was an IOException when trying to"
                        + " send to the Server. This was in the class Actions");
                }
                System.out.print("[0m");
                System.exit(0);
            }
            else if(firstChar.matches(Constants.c)){
                fields.getMode().setMode(Modes.CHAT);
            }
            else{
                System.out.println(message + " did not start with any of the"
                    + "avaliable commands");
            }
        }
    }
//                                                                             |
}
