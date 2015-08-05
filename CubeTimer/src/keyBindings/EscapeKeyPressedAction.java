package keyBindings;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cubetimer.Paint;
import fields.DisplayState;
import fields.Fields;


@SuppressWarnings("serial")
public class EscapeKeyPressedAction extends AbstractAction{
	
	private Fields fields;
	private Paint paint;
	
	public EscapeKeyPressedAction(Fields f, Paint p){
		fields = f;
		paint = p;
	}

	public void actionPerformed(ActionEvent e){
	
		if(fields.displayState == DisplayState.timer){
			fields.displayState = DisplayState.menu;
		}
		
		paint.repaint();
		
	}
}
