public class Output{

    public Runner runner;
    public Corp corp;

    public Output(){

        runner = null;
        corp = null;
    }

    public void sendMessage(String message) throws Exception{

        if(runner != null){
            runner.sendMessage(message);
        }

        if(corp != null){
        corp.sendMessage(message);
        }

        System.out.println(message);
    }

    public void setRunner(Runner runnerIn){

        runner = runnerIn;
    }

    public void setCorp(Corp corpIn){

        corp = corpIn;
    }

}
