public class Output{

    public Runner runner;
    public Corp corp;

    public Output(){

    }

    public void send Message(String message){

        runner.sendMessage(message);
        corp.sendMessage(message);
    }

    public void setRunner(Runner runnerIn){

        runner = runnerIn;
    }

    public void setCorp(Corp corpIn){

        corp = corpIn;
    }
}
