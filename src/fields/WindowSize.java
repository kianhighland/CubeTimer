package fields;

public class WindowSize{
	
	private int windowWidth;
	private int windowHeight;
	
	public WindowSize(){
	
		setWindowWidth(0);
		setWindowHeight(0);
	}
	
	public void setSize(int windowWidthIn, int windowHeightIn){
		setWindowWidth(windowWidthIn);
		setWindowHeight(windowHeightIn);
	}

	public int getWindowHeight() {
		return windowHeight;
	}

	public void setWindowHeight(int windowHeightIn) {
		windowHeight = windowHeightIn;
	}

	public int getWindowWidth() {
		return windowWidth;
	}

	public void setWindowWidth(int windowWidthIn) {
		windowWidth = windowWidthIn;
	}
}
