package fields;


public class ScrambleData{
	
	private int scrambleLenght;
	private double scrambleSize;
	private String randomScramble;
	private String[] randomScrambleAfterSplit;
	private boolean useStringListForRandomScramble;
	
	public ScrambleData(){
		setRandomScramble("");
		setScrambleSize(28.0);
		setScrambleLenght(20);
	}

	public String getRandomScramble() {
		return randomScramble;
	}

	public void setRandomScramble(String randomScrambleIn) {
		randomScramble = randomScrambleIn;
	}

	public String[] getRandomScrambleAfterSplit() {
		return randomScrambleAfterSplit;
	}

	public void
			setRandomScrambleAfterSplit(String[] randomScrambleAfterSplitIn) {
		randomScrambleAfterSplit = randomScrambleAfterSplitIn;
	}

	public int getScrambleLenght() {
		return scrambleLenght;
	}

	public void setScrambleLenght(int scrambleLenghtIn) {
		scrambleLenght = scrambleLenghtIn;
	}

	public double getScrambleSize() {
		return scrambleSize;
	}

	public void setScrambleSize(double scrambleSizeIn) {
		scrambleSize = scrambleSizeIn;
	}

	public boolean getUseStringListForRandomScramble() {
		return useStringListForRandomScramble;
	}

	public void setUseStringListForRandomScramble(
			boolean useStringListForRandomScrambleIn) {
		useStringListForRandomScramble = useStringListForRandomScrambleIn;
	}
}
