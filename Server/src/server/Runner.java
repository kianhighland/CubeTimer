package server;

import java.io.*;
import java.net.*;
import connection.ConnectRunner;
import fields.Fields;
import fields.Constants;

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
                System.out.println("The runner should quit");
                if(fields.threads.connectCorp.isAlive()){
                    System.out.println("connect corp is alive");
                    fields.setConnectCorp(false);
                    System.out.println(1);
                    fields.setConnectPlayers(true);
                    System.out.println(3);
//                    fields.threads.connectPlayers.notify();
                    System.out.println(4);
                    fields.waitObject.stopWaiting();
                }
                else{
                    System.out.println("connect corp is no alive");
                    fields.threads.connectRunner = new Thread(connectRunner);
                    fields.threads.connectRunner .start();
                }
                return true;
            }
            else{
                System.out.println("unrecognized command in class runner of" 
                    + "Server: " + command);
                System.out.println("if the player typed an unrecognized command"
                    + "it shouldn't have goten here");
                sendMessage("there was an unrecognized command in the class run"
                + " of the Server");
                return false;
            }
        }
        else{
            System.out.println("There is a problem in the code");
            System.out.println("Method chatCommand was called with an"
                + "argument that doesn't start with slash");
            return false;
        }
    }
}
