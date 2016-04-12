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

		if (fields.getDisplayState() == DisplayState.menu) {
			fields.getMenu().upOne();
		}

		else if (fields.getDisplayState() == DisplayState.changeTwistyPuzzle) {
			fields.getMenu().getTwistyPuzzleMenu().upOne();
		}

		else if (fields.getDisplayState() == DisplayState.userMenu) {
			fields.getMenu().getUserActionsMenu().upOne();
		}

		else if (fields.getDisplayState() == DisplayState.changeScrambleLenght) {

			fields.getDisplayedData().getScrambleData().setScrambleLenght(fields.getDisplayedData().getScrambleData().getScrambleLenght() + 1);

			scrambler.randomCorrectScrambleInFieldsUsingFields();
		}

		else if (fields.getDisplayState() == DisplayState.changeUser) {

			fields.getMenu().getUserActionsMenu().userMenuUpOne(fields.getAllUsers()
					.getSize());
		}

		fields.changeSinceLastRepaint();
		paint.repaint();
	}
}
