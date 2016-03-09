package server;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import fields.Fields;
import fields.Constants;

public class UserInput implements Runnable{

    private Output output;
    private Scanner userInput;
    private Fields fields;

    public UserInput(Output outputIn, Fields fieldsIn){
    
        output = outputIn;
        userInput = new Scanner(System.in);
        fields = fieldsIn;
    }

    public void run(){

        try{
        serverInput();
        } catch(Exception e){
        }
    }

    public void serverInput() throws Exception{

        System.out.print(Constants.serverInput);
        String message = userInput.nextLine();
        if(message.length() > 0){
            String firstChar = message.substring(0, 1);
            if(firstChar.matches(Constants.slash)){
                String secondChar = message.substring(1, 2);
                if(secondChar.matches(Constants.q)){
                    if(output.runner()){
                        System.out.println(Constants.normalText 
                            + "The Runner is still playing");
                        if(output.corp()){
                            System.out.println(Constants.normalText 
                            + "The Corp is still playing");
                        }
                        System.out.println(Constants.actionPrompts 
                            +"Do you want to (q)uit anyway (c)ancel and posibly"                            + "ask them to leave?" + Constants.normalText);
                        qWithPlayers();
                    }
                    else{
                        if(output.corp()){
                            System.out.println(Constants.normalText
                                + "The Corp is still playing");
                            System.out.println(Constants.actionPrompts 
                                + "Do you want to (q)uit anyway (c)ancel and"
                                + "posibly ask them to leave?"
                                + Constants.normalText);
                            qWithPlayers();
                        }
                        System.out.print((char)27 + "[0m");
                        System.exit(0);
                    }
                }
                else{
                    System.out.println(Constants.actionPrompts 
                    + "Unknown command: " + message);
                }
                serverInput();
            }
            else{
                fields.threads.userInput = new Thread(this);
                fields.threads.userInput.start();
                Thread.sleep(10);
                output.sendMessage(Constants.serverChat + Constants.server +": "
                    + message + Constants.normalText);
            }
        }
        else{
            serverInput();
        }
    }

    private void qWithPlayers() throws Exception{

        System.out.print(Constants.serverInput);
        String message = userInput.nextLine();
        if(message.length() > 0){
            String firstChar = message.substring(0, 1);
            if(firstChar.matches(Constants.q)){
                output.sendMessage(Constants.quit);
                System.out.print((char)27 + "[0m");
                System.exit(0);
            }
            else if(firstChar.matches(Constants.c)){
                serverInput();
            }
            else{
                System.out.println(Constants.actionPrompts + message
                    + " did not start with c or q");
                qWithPlayers();
            }
        }
        else{
            qWithPlayers();
        }
    }
}
