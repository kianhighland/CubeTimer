package keyBindings;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import cubetimer.Actions;
import cubetimer.KeyPressActions;
import cubetimer.Paint;
import cubetimer.Scrambler;
import fields.DisplayState;
import fields.Fields;
import fields.TwistyPuzzleType;

@SuppressWarnings("serial")
public class EnterKeyPressedAction extends AbstractAction {

    private Fields fields;
    private Paint paint;
    private Scrambler scrambler;
    private Actions actions;

    public EnterKeyPressedAction(Fields f, Paint p, Scrambler s, Actions a) {
        fields = f;
        paint = p;
        scrambler = s;
        actions = a;
    }

    public void actionPerformed(ActionEvent e) {

        if (fields.getDisplayState() == DisplayState.menu) {

            if (fields.getMenu().getChangeTwistyPuzzle()) {
                fields.setDisplayState(DisplayState.changeTwistyPuzzle);
            }

            else if (fields.getMenu().getUserMenu()) {
                fields.setDisplayState(DisplayState.userMenu);
            }

            else if (fields.getMenu().getChangeScrambleLenght()) {
                fields.setDisplayState(DisplayState.changeScrambleLenght);
            }

            else if (fields.getMenu().getDeleteLastSolve()) {
                fields.setDisplayState(DisplayState.timer);
                fields.getAllUsers().getUser().getTwistyPuzzle()
                    .removeLastTime();
                fields.getAllUsers().getUser().getTwistyPuzzle()
                    .setLastAvarageOf5();
            }

            else if (fields.getMenu().getNewScramble()) {
                scrambler.randomCorrectScrambleInFieldsUsingFields();
                fields.setDisplayState(DisplayState.timer);
            }
            
            else if(fields.getMenu().getTimeMenu()){
                fields.setDisplayState(DisplayState.times);
            }

            else if (fields.getMenu().getQuit()) {
                System.exit(0);
            }

            else {
                fields.setDisplayState(DisplayState.timer);
            }
        }

        else if (fields.getDisplayState() == DisplayState.changeTwistyPuzzle) {

            if (fields.getMenu().getTwistyPuzzleMenu().get2x2x2()) {

                KeyPressActions.changeToTwistyPuzzle(fields,
                        TwistyPuzzleType.cube2x2x2, scrambler, paint);
            }

            else if (fields.getMenu().getTwistyPuzzleMenu().get3x3x3()) {

                KeyPressActions.changeToTwistyPuzzle(fields,
                        TwistyPuzzleType.cube3x3x3, scrambler, paint);
            }

            else if (fields.getMenu().getTwistyPuzzleMenu().get4x4x4()) {

                KeyPressActions.changeToTwistyPuzzle(fields,
                        TwistyPuzzleType.cube4x4x4, scrambler, paint);
            }

            else if (fields.getMenu().getTwistyPuzzleMenu().get5x5x5()) {

                KeyPressActions.changeToTwistyPuzzle(fields,
                        TwistyPuzzleType.cube5x5x5, scrambler, paint);
            }

            else if (fields.getMenu().getTwistyPuzzleMenu().getMegaMinx()) {

                KeyPressActions.changeToTwistyPuzzle(fields,
                        TwistyPuzzleType.megaMinx, scrambler, paint);
            }

            else if (fields.getMenu().getTwistyPuzzleMenu().getGearCube()) {

                KeyPressActions.changeToTwistyPuzzle(fields,
                        TwistyPuzzleType.gearCube, scrambler, paint);
            }

            else if (fields.getMenu().getTwistyPuzzleMenu()
                .getAnisatropicGearCube()) {

                KeyPressActions.changeToTwistyPuzzle(fields,
                        TwistyPuzzleType.anisatropicGearCube, scrambler, paint);
            }

            else if(fields.getMenu().getTwistyPuzzleMenu().getOneHanded3x3x3()){

                KeyPressActions.changeToTwistyPuzzle(fields,
                        TwistyPuzzleType.oneHanded3x3x3, scrambler, paint);
            }

            else if(fields.getMenu().getTwistyPuzzleMenu().getCuboid3x3x1()){
                KeyPressActions.changeToTwistyPuzzle(fields,
                    TwistyPuzzleType.cuboid3x3x1, scrambler, paint);
            }

            else if(fields.getMenu().getTwistyPuzzleMenu()
                .getRandomTwistyPuzzle()) {

                KeyPressActions.changeToRandomTwistyPuzzleType(fields,
                        scrambler, actions, paint);
            }

            fields.setDisplayState(DisplayState.timer);

            if (fields.getMenu().getTwistyPuzzleMenu().getExit()) {
                fields.setDisplayState(DisplayState.menu);
            }
        }

        else if (fields.getDisplayState() == DisplayState.times){
            fields.setDisplayState(DisplayState.timer);
        }

        else if (fields.getDisplayState() == DisplayState.userMenu) {

            if (fields.getMenu().getUserActionsMenu().getAddUser()) {

                KeyPressActions.addAUser(fields, paint);
            }

            else if (fields.getMenu().getUserActionsMenu().getChangeUser()) {

                fields.setDisplayState(DisplayState.changeUser);
            }

            else if (fields.getMenu().getUserActionsMenu()
                .getDeleteCurrentUser()) {

                Actions.deleteCurrentUser(fields, paint);
            }

            else if (fields.getMenu().getUserActionsMenu()
                .getRenameCurrentUser()) {

                KeyPressActions.changeUserName(fields, paint);
            }

            else {
                fields.setDisplayState(DisplayState.menu);
            }
        }

        else if (fields.getDisplayState() == DisplayState.changeScrambleLenght) {

            scrambler.randomCorrectScrambleInFieldsUsingFields();

            fields.setDisplayState(DisplayState.timer);
        }

        else if (fields.getDisplayState() == DisplayState.changeUser) {

            fields.getAllUsers().setCurrentUserIndex(fields.getMenu().getUserActionsMenu()
                    .getSelectedUserIndex());
            fields.setDisplayState(DisplayState.timer);
        }

        fields.changeSinceLastRepaint();
        paint.repaint();

    }

}
