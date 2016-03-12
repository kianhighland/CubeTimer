package connection;

import java.io.*;
import java.net.*;
import server.*;
import fields.Fields;
import fields.Constants;
import print.PrintLine;
import java.util.Scanner;

public class Connection{
    
    private ServerSocket serverSocket;
    private Socket socket;
    private DataOutputStream firstOut;
    private DataInputStream firstIn;
    private Output output;
    private ConnectRunner connectRunner;
    private ConnectCorp connectCorp;
    private Fields fields;
    private UserInput userInput;
    private AcceptPlayers acceptPlayers;

    public Connection() throws Exception{

        System.out.print(Constants.normalText);
        System.out.println(Constants.normalText + "                            "
            + "                                                                "
            + "                                                                "
            + "                                                                "
            + "                                                              ");
        System.out.print("\b");
        System.out.println();
        write();
        read();
    	fields = new Fields();
        System.out.println("starting server...");
        serverSocket = new ServerSocket(7665);
        System.out.println("server started");
        output = new Output(fields);
        connectRunner = new ConnectRunner(output, serverSocket, fields);
        connectCorp = new ConnectCorp(output, serverSocket, fields);
        acceptPlayers = new AcceptPlayers(serverSocket, fields,
            connectRunner, connectCorp);
        fields.threads.acceptPlayers = new Thread(acceptPlayers);
        fields.threads.acceptPlayers.start();
        userInput = new UserInput(output, fields);
        fields.threads.userInput = new Thread(userInput);
        openFile();
        fields.threads.userInput.start();
    }

    private void write() throws Exception{

        FileWriter fileWriter = new FileWriter("../saves/testtest.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write("test");
        bufferedWriter.newLine();
        bufferedWriter.write("4");

        bufferedWriter.close();
    }

    private void read() throws Exception{
                                                                                
        FileReader fileReader;
        try{
            fileReader = new FileReader("../saves/test.txt");
        } catch(java.io.FileNotFoundException e){
            System.out.println("could not find file");
            return;
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String string = bufferedReader.readLine();
        System.out.println(string);
        string = bufferedReader.readLine();
        int integer = Integer.parseInt(string);
        System.out.println(integer);
        bufferedReader.close();
    }

    private void openFile(){

       PrintLine.println(Constants.actionPrompts + "Would you like to open "
            + "a game that you have saved? (y)es or (n)o"
            + Constants.normalText);
       Scanner userInput = new Scanner(System.in);
       String answer = userInput.nextLine();
       String firstchar;
       if(answer.length() > 0){
           firstchar = answer.substring(0, 1);
       }
       else{
           openFile();
           return;
       }
       if(firstchar.matches("y")){
           if(!fields.open()){
               System.out.println(fields.getOpenError());
           }
       }
       else if(firstchar.matches("n")){
           System.out.println(Constants.actionPrompts + "Okay"
               + Constants.normalText);
       }
       else{
           PrintLine.println(Constants.actionPrompts + answer + " didn't start "
               + "with y or n. Please try again.");
       }
    }
}
