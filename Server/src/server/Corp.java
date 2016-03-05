package server;

import java.io.*;
import java.net.*;
import connection.ConnectCorp;
import fields.Constants;

public class Corp implements Runnable{

    private DataOutputStream out;
    private DataInputStream in;
    private Output output;

    public Corp(DataOutputStream out, DataInputStream in, Output outputIn){

        this.out = out;
        this.in = in;
        output = outputIn;
    }

    public void run(){

        while(true){
            try{
                String message = in.readUTF();
                String firstChar = message.substring(0,1);
                if (firstChar.matches(Constants.slash)){
                    String secondChar = message.substring(1, 2);
                    if(secondChar.matches(Constants.q)){
                        output.setCorp(null);
                        break;
                        }
                    else{
                        System.out.println("unrecognized command: " + message);
                        sendMessage("unrecognized command: " + message);
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
}
