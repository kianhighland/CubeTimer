public class Output{

    public Runner runner;
    public Corp corp;

    public Output(){

        runner = null;
        corp = null;
    }

    public void sendMessage(String message) throws Exception{

        System.out.println(message);

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

}
