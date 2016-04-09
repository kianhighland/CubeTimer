package fields;

import java.io.*;
import java.net.Socket;
import staticpackage.Static;
import java.util.ArrayList;
import staticpackage.PrintLine;

public class Fields{

    public Threads threads;
    public WaitObject waitObject;
    private boolean connectCorp;
    private boolean connectRunner;
    private ArrayList<String> output;
    private String openError;
    private String fileRead;
    
    public Fields(){
    
        threads = new Threads();
        waitObject = new WaitObject();
        connectRunner = true;
        connectCorp = true;
        output = new ArrayList<String>();
        fileRead = null;
    }
//                                                                             |
    public void setConnectCorp(boolean connectCorpIn){

        connectCorp = connectCorpIn;
    }
//                                                                             |
    public boolean getConnectCorp(){
//                                                                             |
        return connectCorp;
    }
//                                                                             |

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
    
    public boolean save(){

        System.out.println(fileRead);
        
        if(fileRead == null){
            return false;
        }

        save(fileRead);
        System.out.println(fileRead);
        return true;
    }

    public boolean save(String fileName){

        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        try{
            fileWriter = new FileWriter("../saves/" + fileName);
            bufferedWriter = new BufferedWriter(fileWriter);
        } catch(IOException e){
            System.out.println(e);
            return false;
        }
//                                                                             |
        ArrayList<String> list = Static.copyArrayListString(output);
        int length = list.size();
        try{
            bufferedWriter.write(length + "");
            bufferedWriter.newLine();
        } catch(IOException e){
            System.out.println(e);
            return false;
        }
        for(int i = 0; i < length; i++){
            try{
                bufferedWriter.write("" + list.get(i));
                bufferedWriter.newLine();
            } catch(IOException e){
                System.out.println(e);
            }
            PrintLine.println("" + list.get(i));
        }
        try{
            bufferedWriter.close();
        } catch(IOException e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean open(String fileName){
//                                                                             |
    openError = "";
    FileReader fileReader;
    try{
        fileReader = new FileReader("../saves/" + fileName);
    } catch(java.io.FileNotFoundException e){
        openError = "File not found";
        return false;
    }
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    String string;
    try{
        string = bufferedReader.readLine();
    } catch(IOException e){
        openError = e + "";
        return false;
    }
    output = new ArrayList<String>();
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
    fileRead = fileName;
    return true;
    }

    public String getOpenError(){

        return openError;
    }
}
