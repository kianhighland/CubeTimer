package savedData;

import fields.Constants;

public class Time {

    private double time;
    private int timePenalty;
    private boolean DNF;
    private double timeSeconds;
    private int timeMinutes;

    public Time(double timeIn, int timePenlatyIn, boolean DNFIn) {

        time = timeIn;
        timePenalty = timePenlatyIn;
        DNF = DNFIn;
        timeSeconds = 0;
        timeMinutes = 0;
    }

    public String getDisplayTime() {

        if (DNF) {

            return "DNF";
        }

        else {

            timeSeconds = time + timePenalty;
            timeMinutes = 0;

            while (timeSeconds > Constants.secondsPerMinute) {

                timeSeconds -= Constants.secondsPerMinute;
                timeMinutes++;
            }

            if (timeMinutes > 0) {
                return Integer.toString(timeMinutes) + ":"
                        + String.format("%.2f", timeSeconds);
            }
            
            else{
                return String.format("%.2f", timeSeconds);
            }
        }
    }
    
    public double getFinalValue(){
        
        if(DNF){
            
            return 0.0;
        }
        
        else{
            
            return time + timePenalty;
        }
    }
    
    public void setTime(double timeIn){
        
        time = timeIn;
    }
    
    public void setTimePenalty(int timePenaltyIn){
        
        timePenalty = timePenaltyIn;
    }
    
    public void timePenaltyPlusTwo(){
        
        timePenalty += 2;
    }
    
    public void setDNF(boolean DNFIn){
        
        DNF = DNFIn;
    }
    
    public void DNF(){
        
        DNF = true;
    }
}
