package keyBindings;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Timer;

import cubetimer.Stackmat;
import fields.Constants;
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
        spaceTimer = new javax.swing.Timer(1000, spaceReleased);
        spaceTimer.setRepeats(false);
        spaceTimer.setInitialDelay(Constants.keyRefreshRate);
    }
    
    public void actionPerformed(ActionEvent e){
        if(fields.addCommand()){
            return;
        }
        //stops the previous timer so that the timer only acutally fires
        //when space released stops getting pressed
        spaceTimer.stop();
        spaceTimer.start();
    }
}
