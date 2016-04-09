package connection;

import java.io.*;
import java.net.*;
import server.*;
import fields.Fields;
import fields.Constants;
import java.util.Scanner;
import staticpackage.print;

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
           PrintLine.println(Constants.actionPrompts + "What is the name of the"
               + " file? Remember its from the saves directory.");
           String fileName =  userInput.nextLine();
           while(!fields.open(fileName)){
               System.out.println(Constants.actionPrompts
               + fields.getOpenError());
               listFiles();
               System.out.println();
               PrintLine.println(Constants.actionPrompts + "Go ahead and try "
                   + "again");
               fileName = userInput.nextLine();
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

    private void listFiles(){

        System.out.println(Constants.actionPrompts + "All files in the saves "
            + "directory are as follows:");
        File folder = new File("../saves");
        listFilesForFolder(folder, "");
    }

    private void listFilesForFolder(File folder, String prefix){

        for(File fileEntry : folder.listFiles()){
            if(fileEntry.isDirectory()){
                listFilesForFolder(fileEntry,
                    prefix + fileEntry.getName() + "/");
            }
            else{
                System.out.println(prefix + fileEntry.getName());
            }
        }
    }
}
