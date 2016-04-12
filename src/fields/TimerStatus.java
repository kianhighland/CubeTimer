package fields;


public class TimerStatus{
	
	private boolean running;
	private boolean countDownRunning;
	
	public TimerStatus(){
		setRunning(false);
		setCountDownRunning(false);
	}

	public boolean getCountDownRunning() {
		return countDownRunning;
	}

	public void setCountDownRunning(boolean countDownRunningIn) {
		countDownRunning = countDownRunningIn;
	}

	public boolean getRunning() {
		return running;
	}

	public void setRunning(boolean runningIn) {
		running = runningIn;
	}
	
}
