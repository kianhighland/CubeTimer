package swingTimerActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fields.DisplayState;
import fields.Fields;


public class ChangeUser implements ActionListener{

	private Fields fields;
	
	public ChangeUser(Fields f){
		
		setFields(f);
	}
	
	public void actionPerformed(ActionEvent e){
	
		getFields().setDisplayState(DisplayState.changeUser);
		
	}

	Fields getFields() {
		return fields;
	}

	void setFields(Fields fieldsIn) {
		fields = fieldsIn;
	}
	
}
