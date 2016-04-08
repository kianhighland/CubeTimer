public class Mode{

    private Modes mode;
    private String modeText;

    public Mode(){
    
        mode = Modes.CHAT;
        modeText = Constants.chatMode;
    }

    public void setMode(Modes modeIn){
    
        mode = modeIn;

        if(modeIn == Modes.CHAT){
            modeText = Constants.chatMode;
        }

        else if(modeIn == Modes.COMMAND){
            modeText = Constants.commandMode;
        }

        else{
            modeText = "unrecognized mode in the class Mode> ";
        }
    }

    public Modes getMode(){
        return mode;
    }

    public String getModeText(){
        return modeText;
    }
}
