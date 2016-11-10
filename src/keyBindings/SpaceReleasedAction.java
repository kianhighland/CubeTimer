package keyBindings;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cubetimer.Stackmat;
import fields.Fields;

@SuppressWarnings("serial")
public class SpaceReleasedAction extends AbstractAction{
	
	private Fields fields;
	private Stackmat stackmat;
	
	public SpaceReleasedAction(Fields f, Stackmat sm){
	
		fields = f;
		stackmat = sm;
	}
	
	public void actionPerformed(ActionEvent e){
	
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
		
	}
	
}
