public class Fields{

    private boolean leave;
    private Mode mode;

    public Fields(){

        leave = false;
        mode = new Mode();
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

    public Mode getMode(){
        return mode;
    }
}
