package server;

import java.io.*;
import java.net.*;
import connection.ConnectCorp;
import fields.Fields;
import fields.Constants;
import print.PrintLine;

public class Corp implements Runnable{

    private DataOutputStream out;
    private DataInputStream in;
    private Output output;
    private Fields fields;
    private ConnectCorp connectCorp;

    public Corp(DataOutputStream out, DataInputStream in, Output outputIn,
        Fields fieldsIn, ConnectCorp connectCorpIn){

        this.out = out;
        this.in = in;
        output = outputIn;
        fields = fieldsIn;
        connectCorp = connectCorpIn;
    }

    public void run(){

        while(true){
            try{
                String message = in.readUTF();
                String firstChar = message.substring(0,1);
                if (firstChar.matches(Constants.slash)){
                    if(command(message)){
                        break;
                    }
                }
                else{
                    output.sendMessage(message);
                }
            } catch (Exception e) {
            }
            try{
                Thread.sleep(200);
            }catch (Exception e){
            }
        }
    }

    public void sendMessage(String message) throws Exception{

        out.writeUTF(message);
    }

    public boolean command(String command) throws Exception{

        String firstChar = command.substring(0, 1);
        if(firstChar.matches(Constants.slash)){
            String secondChar = command.substring(1, 2);
            if(secondChar.matches(Constants.q)){
                output.setCorp(null);
                fields.setConnectCorp(true);
                return true;
            }
            else{
                PrintLine.println("unrecognized command in class Corp of"
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
