public class Fields{

    private boolean leave;
    private String mode;

    public Fields(){

        leave = false;
        mode = Constants.chatMode;
    }
    
    private void setLeave(boolean newLeave){
        leave = newLeave;
    }
    
    public boolean getLeave(){
        return leave;
    }

    public void leave(){
        leave = true;
    }

    public void setMode(String newMode){
        mode = newMode;
    }

    public String getMode(){
        return mode;
    }
}
