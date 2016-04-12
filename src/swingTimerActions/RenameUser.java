package swingTimerActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cubetimer.Actions;
import cubetimer.Paint;
import fields.Fields;


public class RenameUser implements ActionListener{
	
	public Fields fields;
	public Paint paint;
	
	public RenameUser(Fields f, Paint p){
		
		fields = f;
		paint = p;
	}

	public void actionPerformed(ActionEvent e){
		
		Actions.renameCurrentUser(fields, paint);
	}
	
}
