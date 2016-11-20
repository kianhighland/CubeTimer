package keyBindings;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fields.DisplayState;
import fields.Fields;

public class ColonPressedAction extends AbstractAction{

    private Fields fields;

    public ColonPressedAction(Fields f){

        fields = f;

    }

    public void actionPerformed(ActionEvent e){

        System.out.println("colon");
        if(fields.getDisplayState() == DisplayState.timer){
            fields.colon();
        }
    }
}
