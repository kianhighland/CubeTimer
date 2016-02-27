public class Output{

    public Runner runner;
    public Corp corp;

    public Output(){

    }

    public void sendMessage(String message) throws Exception{

        runner.sendMessage(message);
        corp.sendMessage(message);
        System.out.println(message);
    }

    public void setRunner(Runner runnerIn){

        runner = runnerIn;
    }

    public void setCorp(Corp corpIn){

        corp = corpIn;
    }

}
