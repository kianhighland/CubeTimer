package fields;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import print.PrintLine;

public class Fields{

    public Threads threads;
    public WaitObject waitObject;
    private boolean connectCorp;
    private boolean connectRunner;
    private ArrayList <String> output;
    private String openError;
    
    public Fields(){
    
        threads = new Threads();
        waitObject = new WaitObject();
        connectRunner = true;
        connectCorp = true;
        output = new ArrayList<String>();
    }

    public void setConnectCorp(boolean connectCorpIn){

        connectCorp = connectCorpIn;
    }

    public boolean getConnectCorp(){

        return connectCorp;
    }

    public  void setConnectRunner(boolean connectRunnerIn){

        connectRunner = connectRunnerIn;
    }

    public boolean getConnectRunner(){

        return connectRunner;
    }

    public void newMessage(String message){

        output.add(message);
    }

    public ArrayList<String> getMessages(){

        return output;
    }

    public void save() throws Exception{

        FileWriter fileWriter = new FileWriter("../saves/save.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        int length = output.size();
        bufferedWriter.write(length + "");
        bufferedWriter.newLine();
        for(int i = 0; i < length; i++){
            bufferedWriter.write(output.get(i));
            bufferedWriter.newLine();
            PrintLine.println(output.get(i));
        }
        bufferedWriter.close();
    }

    public boolean open(){

    openError = "";
    FileReader fileReader;
    try{
        fileReader = new FileReader("../saves/save.txt");
    } catch(java.io.FileNotFoundException e){
        openError = "File not found";
        return false;
    }
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    String string;
    try{
        string = bufferedReader.readLine();
    } catch(IOException e){
        openError = "File is empty";
        return false;
    }
    int length = Integer.parseInt(string);
    for(int i = 0; i < length; i++){
        try{
            string = bufferedReader.readLine();
        } catch(IOException e){
            openError = e + "";
            return false;
        }
        if(string != null){
            System.out.println(string);
            output.add(string);
        }
    }
    return true;
    }

    public String getOpenError(){

        return openError;
    }
}
