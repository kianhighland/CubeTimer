package server;

import fields.Constants;

public class Output{

    public Runner runner;
    public Corp corp;

    public Output(){

        runner = null;
        corp = null;
    }

    public void sendMessage(String message) throws Exception{

        System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        System.out.println(Constants.normalText + message + "                ");
        System.out.print(Constants.serverInput);

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
