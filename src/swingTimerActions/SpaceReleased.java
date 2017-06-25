package swingTimerActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import fields.Fields;
import cubetimer.Stackmat;

public class SpaceReleased implements ActionListener{

    private Fields fields;
    private Stackmat stackmat;

    public SpaceReleased(Fields f, Stackmat sm){
        fields = f;
        stackmat = sm;
    }

    public void actionPerformed(ActionEvent e){
        
        fields.setGreenText(false);
        
        if(fields.getIgnoreNextRelese()){
            fields.setIgnoreNextRelese(false);
        }
       
        else{
            if(! fields.getTimerStatus().getRunning()){
                
                fields.getDisplayedData().getScrambleData()
                    .setRandomScramble("");
                
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
    }
}
