package fields;
public class WaitObject{

    public WaitObject(){

    }

    public void waiting(){

        try{
            synchronized(this){
                wait();
            }
        } catch(Exception e){
            System.out.println(e);
            waiting();
        }
        return;
    }

    public void stopWaiting(){

        System.out.println("stopWaiting");
        try{
            synchronized(this){
                notify();
                System.out.println("I said notify");
            }
        } catch(Exception e){
            System.out.println(e);
            stopWaiting();
        }
    }
}
