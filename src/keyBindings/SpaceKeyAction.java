package keyBindings;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cubetimer.Paint;
import cubetimer.Stackmat;
import fields.Fields;

@SuppressWarnings("serial")
public class SpaceKeyAction extends AbstractAction{
	
	private Fields fields;
	private Paint paint;
	private Stackmat stackmat;
	public SpaceKeyAction(Fields f, Paint p, Stackmat sm){
	
		fields = f;
		paint = p;
		stackmat = sm;
	}
	
	public void actionPerformed(ActionEvent e){
	
		if(fields.getTimerStatus().getRunning()){
			
			fields.setIgnoreNextRelese(true);
			stackmat.stopTimer();

		}
		else{
			
			if(! fields.getIgnoreNextRelese()){
				
				fields.setGreenText(true);
			}
		}
		
		paint.repaint();
	}
	
}
