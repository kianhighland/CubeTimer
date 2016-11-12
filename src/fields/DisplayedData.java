package fields;


public class DisplayedData{
    
    private ScrambleData scrambleData;
    private String time;
    
    public DisplayedData(){
        
        scrambleData = new ScrambleData();
        time = Constants.initialShownTime;
    }
    
    public ScrambleData getScrambleData(){
        
        return scrambleData;
    }
    
    public String getTime(){
        
        return time;
    }
    
    public void setTime(String timeIn){
        
        time = timeIn;
    }
}
