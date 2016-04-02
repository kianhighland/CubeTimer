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

        try{
            save(fileRead);
        } catch(IOException e){
            System.out.println(e + "");
            return false;
        }
        return true;
    }

    public void save(String fileName) throws IOException{

        FileWriter fileWriter = new FileWriter("../saves/" + fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//                                                                             |
        ArrayList<String> list = output;
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

    public boolean open(String fileName){

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
