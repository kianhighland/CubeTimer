package menus;

import savedData.Time;

public class TimeMenu{

    private Time time;
    private boolean dnf;
    private boolean penalty;
    private boolean delete;
    private boolean exit;

    public TimeMenu(){
    
        dnf = true;
        penalty = false;
        delete = false;
        exit = false;
    }

    public void up(){
    
        if(dnf){
            dnf = false;
            delete = true;
        }
        else if(penalty){
            penalty = false;
            dnf = true;
        }
        else if(delete){
            delete = false;
            penalty = true;
        }
        else{
            exit = false;
            delete = true;
        }
    }

    public void down(){
    
        if(dnf){
            dnf = false;
            penalty = true;
        }
        else if(penalty){
            penalty = false;
            delete = true;
        }
        else if(delete){
            delete = false;
            exit = true;
        }
        else{
            exit = false;
            dnf = true;
        }
    }

    public boolean getDnf(){
        return dnf;
    }

    public boolean getPenalty(){
       return penalty;
    }
 
    public boolean getDelete(){
        return delete;
    }
 
    public boolean getExit(){
        return exit;
    }

    public void setTime(Time timeIn){
        time = timeIn;
    }

    public Time getTime(){
        return time;
    }
}
