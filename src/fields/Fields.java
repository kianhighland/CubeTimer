package fields;

import menus.Menu;
import savedData.AllUsers;

public class Fields {

	private DisplayedData displayedData;
	private TimerStatus timerStatus;
	private WindowSize windowSize;

	private boolean close;

	private Menu menu;

	private DisplayState displayState;
	private UserAction userAction;

	private boolean greenText;

	private boolean ignoreNextRelese;

	private boolean paintComponentDone;

	private AllUsers allUsers;

	public Fields() {

		displayedData = new DisplayedData();
		setTimerStatus(new TimerStatus());
		setWindowSize(new WindowSize());
		allUsers = new AllUsers();

		setMenu(new Menu());

		setPaintComponentDone(false);

		setDisplayState(DisplayState.timer);
	}

	public void setScreenSize(int windowWidth, int windowHeight) {

		getWindowSize().setSize(windowWidth, windowHeight);
	}

	public AllUsers getAllUsers() {

		return allUsers;
	}
	
	public void setAllUsers(AllUsers allUsersIn){
		
		allUsers = allUsersIn;
	}

	public boolean getClose() {
		return close;
	}

	public void setClose(boolean closeIn) {
		close = closeIn;
	}

	public DisplayedData getDisplayedData() {
		return displayedData;
	}

	public void setDisplayedDada(DisplayedData displayedDataIn) {
		displayedData = displayedDataIn;
	}

	public DisplayState getDisplayState() {
		return displayState;
	}

	public void setDisplayState(DisplayState displayStateIn) {
		displayState = displayStateIn;
	}

	public boolean getGreenText() {
		return greenText;
	}

	public void setGreenText(boolean greenTextIn) {
		greenText = greenTextIn;
	}

	public boolean getIgnoreNextRelese() {
		return ignoreNextRelese;
	}

	public void setIgnoreNextRelese(boolean ignoreNextReleseIn) {
		ignoreNextRelese = ignoreNextReleseIn;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menuIn) {
		menu = menuIn;
	}

	public boolean getPaintComponentDone() {
		return paintComponentDone;
	}

	public void setPaintComponentDone(boolean paintComponentDoneIn) {
		paintComponentDone = paintComponentDoneIn;
	}

	public TimerStatus getTimerStatus() {
		return timerStatus;
	}

	public void setTimerStatus(TimerStatus timerStatusIn) {
		timerStatus = timerStatusIn;
	}

	public UserAction getUserAction() {
		return userAction;
	}

	public void setUserAction(UserAction userActionIn) {
		userAction = userActionIn;
	}

	public WindowSize getWindowSize() {
		return windowSize;
	}

	public void setWindowSize(WindowSize windowSizeIn) {
		windowSize = windowSizeIn;
	}
}