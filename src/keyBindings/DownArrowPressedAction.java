package keyBindings;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cubetimer.Paint;
import cubetimer.Scrambler;
import fields.Constants;
import fields.DisplayState;
import fields.Fields;

@SuppressWarnings("serial")
public class DownArrowPressedAction extends AbstractAction{
    
    private Fields fields;
    private Paint paint;
    private Scrambler scrambler;
    
    public DownArrowPressedAction(Fields f, Paint p, Scrambler s){
    
        fields = f;
        paint = p;
        scrambler = s;
        
    }
    
    public void actionPerformed(ActionEvent e){
    
        if(fields.addCommand()){
            return;
        }
        if(fields.getDisplayState() == DisplayState.menu){
            fields.getMenu().downOne();
        }

        else if(fields.getDisplayState() == DisplayState.timeMenu){
            fields.getMenu().getTimeOptionMenu().down();
        }
        else if(fields.getDisplayState() == DisplayState.times){

            if(fields.getGreenTextIndex() >= fields.getAllUsers().getUser()
                .getTwistyPuzzle().getTimes().size() - 1){
       
                fields.setGreenTextIndex(0);
            }
            else{
                fields.setGreenTextIndex(fields.getGreenTextIndex() + 1);
            }
        
        }

        else if(fields.getDisplayState() == DisplayState.changeTwistyPuzzle){
            fields.getMenu().getTwistyPuzzleMenu().downOne();
        }
        
        else if(fields.getDisplayState() == DisplayState.userMenu){
            fields.getMenu().getUserActionsMenu().downOne();
        }
        
        else if(fields.getDisplayState() == DisplayState.changeScrambleLenght){
            
            if(fields.getAllUsers().getUser().getTwistyPuzzle()
                .getScrambleLength()  >= Constants.minimumScrambleLength){

                fields.getAllUsers().getUser().getTwistyPuzzle()
                    .setScrambleLength(fields.getAllUsers().getUser()
                    .getTwistyPuzzle().getScrambleLength() - 1);
            }
            
            scrambler.randomCorrectScrambleInFieldsUsingFields();
        }
        
        else if(fields.getDisplayState() == DisplayState.changeUser){
            
            fields.getMenu().getUserActionsMenu().userMenuDownOne(
                fields.getAllUsers().getSize());
        }
        
        fields.changeSinceLastRepaint();
        paint.repaint();
    }
}
