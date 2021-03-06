package keyBindings;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cubetimer.Paint;
import fields.DisplayState;
import fields.Fields;

public class LeftArrowPressedAction extends AbstractAction{

    private Fields fields;
    private Paint paint;

    public LeftArrowPressedAction(Fields f, Paint p){

        fields = f;
        paint = p;
    }

    public void actionPerformed(ActionEvent e){

        if(fields.addCommand()){
            return;
        }

        if(fields.getDisplayState() == DisplayState.timeMenu && 
            fields.getMenu().getTimeOptionMenu().getPenalty()){

            fields.getMenu().getTimeOptionMenu().getTime().setTimePenalty(
                fields.getMenu().getTimeOptionMenu().getTime()
                .getTimePenalty() -1);
            fields.changeSinceLastRepaint();
            paint.repaint();
        }
    }
}
