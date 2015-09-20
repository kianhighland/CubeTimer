package swingTimerActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cubetimer.Paint;
import fields.Fields;

public class KeepCountDown implements ActionListener {

	private boolean plus2;
	private int timeLeft;
	private Fields fields;
	private Paint paint;
	private boolean DNF;

	public KeepCountDown(Fields fieldsIn, Paint paintIn) {

		timeLeft = 15;
		plus2 = false;
		fields = fieldsIn;
		paint = paintIn;
		fields.getDisplayedData().setTime(Integer.toString(timeLeft));

		paint.repaint();
	}

	public void actionPerformed(ActionEvent e) {

		timeLeft--;

		if (timeLeft > 0) {

			if (plus2) {
				fields.getDisplayedData().setTime("+2");
			}

			else {
				fields.getDisplayedData().setTime("+2");
			}

		}

		else {

			if (plus2) {

				fields.getDisplayedData().setTime("DNF");
				DNF = true;
			}

			else {

				fields.getDisplayedData().setTime("+2");
				timeLeft = 2;
				plus2 = true;
			}
		}

		paint.repaint();
	}

	public int getPenalty() {

		if (plus2) {

			return 2;
		}

		else {

			return 0;
		}
	}

	public boolean getDNF() {

		return DNF;
	}
}
