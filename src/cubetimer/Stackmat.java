package cubetimer;

import javax.swing.Timer;

import savedData.Time;
import swingTimerActions.KeepCountDown;
import swingTimerActions.KeepTime;
import fields.Fields;

public class Stackmat {

	private Fields fields;
	private Scrambler scrambler;
	private Paint paint;
	@SuppressWarnings("unused")
	private FileWriter fileWriter;
	private Timer countDownTimer;
	private Timer stackmatTimer;
	private KeepCountDown keepCountDown;
	private KeepTime keepTime;

	public Stackmat(Fields f, Scrambler scramblerIn, Paint paintIn,
			FileWriter fileWriterIn) {

		fields = f;
		scrambler = scramblerIn;
		paint = paintIn;
		fileWriter = fileWriterIn;

	}

	public void stopTimer() {

		stackmatTimer.stop();

		scrambler.randomCorrectScrambleInFieldsUsingFields();
		fields.getTimerStatus().setRunning(false);
		fields.getAllUsers()
				.getUser()
				.getTwistyPuzzle()
				.addTime(
						new Time(keepTime.getEndTimeResult(), keepCountDown
								.getPenalty(), keepCountDown.getDNF()));
		fields.getAllUsers().getUser().getTwistyPuzzle().setLastAvarageOf5();

		fields.changeSinceLastRepaint();
	}

	public void startTimer() {

		fields.getTimerStatus().setRunning(true);
		keepTime = new KeepTime(fields, paint, keepCountDown);
		stackmatTimer = new Timer(1000, keepTime);
		stackmatTimer.start();

		fields.changeSinceLastRepaint();
	}

	public void StartCountDown() {

		fields.getTimerStatus().setCountDownRunning(true);

		keepCountDown = new KeepCountDown(fields, paint);
		countDownTimer = new Timer(1000, keepCountDown);
		countDownTimer.setInitialDelay(1000);
		countDownTimer.start();
		
		fields.changeSinceLastRepaint();
	}

	public void stopCountDown() {

		fields.getTimerStatus().setCountDownRunning(false);
		countDownTimer.stop();
		
		fields.changeSinceLastRepaint();
	}

}
