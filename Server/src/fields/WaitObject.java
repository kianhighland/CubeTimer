package fields;

import staticpackage.print;

public class WaitObject{

    public WaitObject(){

    }

    public void waiting(){

        try{
            synchronized(this){
                wait();
            }
        } catch(Exception e){
            System.out.println("" + e);
            waiting();
        }
        return;
    }

    public void stopWaiting(){

        try{
            synchronized(this){
                notify();
            }
        } catch(Exception e){
            System.out.println("" + e);
            stopWaiting();
        }
    }
}
