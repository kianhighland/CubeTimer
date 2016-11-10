package keyBindings;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Timer;

import cubetimer.Stackmat;
import fields.Fields;
import swingTimerActions.SpaceReleased;

@SuppressWarnings("serial")
public class SpaceReleasedAction extends AbstractAction{
    
    private Fields fields;
    private Stackmat stackmat;
    private SpaceReleased spaceReleased;
    private Timer spaceTimer;
    
    public SpaceReleasedAction(Fields f, Stackmat sm){
    
        fields = f;
        stackmat = sm;
        spaceReleased = new SpaceReleased(f, sm);
    }
    
/*    public void actionPerformed(ActionEvent e){
    
        System.out.println("released");
        fields.setGreenText(false);
        
        if(fields.getIgnoreNextRelese()){
            fields.setIgnoreNextRelese(false);
        }
        
        else{
            if(! fields.getTimerStatus().getRunning()){
                
                fields.getDisplayedData().getScrambleData().setRandomScramble("");
                
                if(fields.getTimerStatus().getCountDownRunning()){
                    
                    stackmat.stopCountDown();
                    stackmat.startTimer();
                }
                else{
                    stackmat.StartCountDown();
                }
            }
        }
        fields.changeSinceLastRepaint();
        
    }*/
    public void actionPerformed(ActionEvent e){
        spaceTimer = new Timer(1000, spaceReleased);
        spaceTimer.setRepeats(false);
        spaceTimer.setInitialDelay(10);
        fields.setSpaceReleased(true);
        spaceTimer.start();
    }
        
}
