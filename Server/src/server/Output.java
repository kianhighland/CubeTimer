package server;

import fields.Constants;
import fields.Fields;
import staticpackage.PrintLine;

public class Output{

    public Runner runner;
    public Corp corp;
    public Fields fields;

    public Output(Fields fieldsIn){

        runner = null;
        corp = null;
        fields = fieldsIn;
        
        try{
            sendMessage("Hello from program");
        } catch(Exception e){
            PrintLine.println("" + e);
        }
    }

    public void sendMessage(String message){
                                                                                
        PrintLine.println(Constants.normalText + message);
        fields.newMessage(message);

        if(runner != null){
            runner.sendMessage(message);
        }

        if(corp != null){
        corp.sendMessage(message);
        }
    }

    public void setRunner(Runner runnerIn){

        runner = runnerIn;
    }

    public void setCorp(Corp corpIn){

        corp = corpIn;
    }

    public boolean runner(){
        if(runner == null){
            return false;
        }
        return true;
    }

    public boolean corp(){
        if(corp == null){
            return false;
        }
        return true;
    }
}
