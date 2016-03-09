package fields;

import java.net.Socket;

public class Fields{

    public Threads threads;
    public WaitObject waitObject;
    private boolean connectCorp;
    private boolean connectRunner;
    
    public Fields(){
    
        threads = new Threads();
        waitObject = new WaitObject();
        connectRunner = true;
        connectCorp = true;
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
}