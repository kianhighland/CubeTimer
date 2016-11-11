package cubetimer;

import javax.swing.Timer;

import swingTimerActions.AddUser;
import swingTimerActions.RenameUser;
import fields.DisplayState;
import fields.Fields;
import fields.TwistyPuzzleType;
import fields.UserAction;

public class KeyPressActions {

    public static void changeToRandomTwistyPuzzleType(Fields fields,
        Scrambler scrambler, Actions actions, Paint paint) {

        Actions.randomTwistyPuzzle(fields);
        scrambler.randomCorrectScrambleInFieldsUsingFields();
    
        paint.repaint();
    }

    public static void changeToTwistyPuzzle(Fields fields,
        TwistyPuzzleType twistyPuzzleType, Scrambler scrambler, Paint paint) {

        fields.getAllUsers().getUser().setTwistyPuzzleType(twistyPuzzleType);

        scrambler.randomCorrectScrambleInFieldsUsingFields();

        fields.changeSinceLastRepaint();
        paint.repaint();

    }

    public static void addAUser(Fields fields, Paint paint) {

        fields.setDisplayState(DisplayState.consoleRequiresAttention);
        fields.setUserAction(UserAction.add);
        fields.setPaintComponentDone(false);

        fields.changeSinceLastRepaint();
        paint.repaint();

        Timer timer = new Timer(0, new AddUser(fields, paint));
        timer.setRepeats(false);
        timer.start();
    }

    public static void changeUserName(Fields fields, Paint paint) {

        fields.setDisplayState(DisplayState.consoleRequiresAttention);
        fields.setUserAction(UserAction.rename);
        fields.setPaintComponentDone(false);

        fields.changeSinceLastRepaint();
        paint.repaint();

        Timer timer = new Timer(0, new RenameUser(fields, paint));
        timer.setRepeats(false);
        timer.start();
    }
}
