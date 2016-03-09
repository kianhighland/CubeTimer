package fields;

import java.net.Socket;
import java.util.ArrayList;

public class Fields{

    public Threads threads;
    public WaitObject waitObject;
    private boolean connectCorp;
    private boolean connectRunner;
    private ArrayList <String> output;
    
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
}
