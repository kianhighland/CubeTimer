public class Fields{

    private boolean leave;
    private Mode mode;

    public Fields(){

        leave = false;
        mode = new Mode();
    }

    public void leave(){
        leave = true;
    }

    public boolean getLeave(){
        return leave;
    }

    public Mode getMode(){
        return mode;
    }
}
