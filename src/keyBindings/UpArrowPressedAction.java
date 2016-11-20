package keyBindings;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cubetimer.Paint;
import cubetimer.Scrambler;
import fields.DisplayState;
import fields.Fields;

@SuppressWarnings("serial")
public class UpArrowPressedAction extends AbstractAction {

    private Fields fields;
    private Paint paint;
    private Scrambler scrambler;

    public UpArrowPressedAction(Fields f, Paint p, Scrambler s) {
        fields = f;
        paint = p;
        scrambler = s;
    }

    public void actionPerformed(ActionEvent e) {

        if(fields.addCommand()){
            return;
        }

        if (fields.getDisplayState() == DisplayState.menu) {
            fields.getMenu().upOne();
        }

        else if(fields.getDisplayState() == DisplayState.timeMenu){
            fields.getMenu().getTimeOptionMenu().up();
        }
        else if(fields.getDisplayState() == DisplayState.times){
            if(fields.getGreenTextIndex() <= 0){
            
                fields.setGreenTextIndex(fields.getAllUsers().getUser()
                    .getTwistyPuzzle().getTimes().size() - 1);
            }
            else{
                fields.setGreenTextIndex(fields.getGreenTextIndex() - 1);
            }
        }

        else if (fields.getDisplayState() == DisplayState.changeTwistyPuzzle) {
            fields.getMenu().getTwistyPuzzleMenu().upOne();
        }

        else if (fields.getDisplayState() == DisplayState.userMenu) {
            fields.getMenu().getUserActionsMenu().upOne();
        }

        else if (fields.getDisplayState() ==
            DisplayState.changeScrambleLenght) {

            fields.getAllUsers().getUser().getTwistyPuzzle().setScrambleLength(
                fields.getAllUsers().getUser().getTwistyPuzzle()
                .getScrambleLength() + 1);

            scrambler.randomCorrectScrambleInFieldsUsingFields();
        }

        else if (fields.getDisplayState() == DisplayState.changeUser) {

            fields.getMenu().getUserActionsMenu().userMenuUpOne
                (fields.getAllUsers() .getSize());
        }

        fields.changeSinceLastRepaint();
        paint.repaint();
    }
}
