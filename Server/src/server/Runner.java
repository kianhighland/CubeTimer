package server;

import java.io.*;
import java.net.*;
import connection.ConnectRunner;
import fields.Fields;
import fields.Constants;
import print.PrintLine;

public class Runner implements Runnable{

    private DataOutputStream out;
    private DataInputStream in;
    private Output output;
    private Fields fields;
    private ConnectRunner connectRunner;

    public Runner(DataOutputStream out, DataInputStream in, Output outputIn,
        Fields fieldsIn, ConnectRunner connectRunnerIn){

        this.out = out;
        this.in = in;
        output = outputIn;
        fields = fieldsIn;
        connectRunner = connectRunnerIn;
    }

    public void run(){

        while(true){
            try{
                String message = in.readUTF();
                String begining = message.substring(0, 1);
                if(begining.matches(Constants.slash)){
                    if(Command(message)){
                        break;
                    }
                }
                else{
                    output.sendMessage(message);
                }
                Thread.sleep(200);
            } catch (Exception e){
            }
        }
    }

    public void sendMessage(String message) throws Exception{

        out.writeUTF(message);
    }
    
    private boolean Command(String command) throws Exception{

        String firstChar = command.substring(0, 1);
        if(firstChar.matches(Constants.slash)){
            String secondChar = command.substring(1, 2);
            if(secondChar.matches(Constants.q)){
                output.setRunner(null);
                if(fields.threads.connectCorp.isAlive()){
                    fields.setConnectCorp(false);
                    fields.setConnectPlayers(true);
                    fields.waitObject.stopWaiting();
                }
                else{
                    fields.threads.connectRunner = new Thread(connectRunner);
                    fields.threads.connectRunner .start();
                }
                return true;
            }
            else{
                PrintLine.println("unrecognized command in class runner of" 
                    + "Server: " + command);
                PrintLine.println("if the player typed an unrecognized command"
                    + "it shouldn't have goten here");
                sendMessage("there was an unrecognized command in the class run"
                + " of the Server");
                return false;
            }
        }
        else{
            PrintLine.println("There is a problem in the code");
            PrintLine.println("Method chatCommand was called with an"
                + "argument that doesn't start with slash");
            return false;
        }
    }
}
