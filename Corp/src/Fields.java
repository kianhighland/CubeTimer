public class Fields{

    private boolean leave;
    private String mode;

    public Fields(){

        leave = false;
        mode = Constants.chatMode;
    }

    public void leave(){
        leave = true;
    }

    public boolean getLeave(){
        return leave;
    }

    public void setMode(String newMode){
        mode = newMode;
    }

    public String getMode(){
        return mode;
    }
}
