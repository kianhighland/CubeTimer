package cubetimer;

import java.util.ArrayList;
import java.util.Random;

public class Fields{
	
	private Paint paint;
	
	private String randomScramble;
	
	private int screenWidth;
	private int screenHeight;
	
	private TwistyPuzzleType twistyPuzzleType;
	
	private boolean greenText;
	private int scrambleLenght;
	private double scrambleSize;
	private String[] randomScrambleAfterSplit;
	private boolean useStringListForRandomScramble;
	
	private String time;
	
	private ArrayList<Double> last20Solves;
	private String currentUserName;
	private String avarageOf5;
	
	private boolean ignoreNextRelese;
	private boolean running;
	private boolean countDownRunning;
	private boolean DNF;
	private int timePenalty;
	
	private boolean consoleRequiresAtention;
	private boolean addNotChangeUser;
	
	public Fields(Paint p){
	
		paint = p;
		
		randomScramble = "";
		time = "0:0.0";
		scrambleSize = 28.0;
		scrambleLenght = 20;
		last20Solves = new ArrayList<Double>();
		avarageOf5 = "No Avarage Of 5 Yet";
		currentUserName = "";
		DNF = false;
		timePenalty = 0;
		
		twistyPuzzleType = TwistyPuzzleType.cube3x3x3;
	}
	
	public void repaint(){
	
		paint.repaint(consoleRequiresAtention, greenText, screenWidth, screenHeight, time, useStringListForRandomScramble, randomScrambleAfterSplit, randomScramble, scrambleSize, scrambleLenght, avarageOf5, currentUserName, last20Solves, twistyPuzzleType);
		
	}
	
	public TwistyPuzzleType getTwistyPuzzleType(){
	
		return twistyPuzzleType;
	}
	
	public void setTwistyPuzzleType(TwistyPuzzleType twistyPuzzleTypeIn){
	
		twistyPuzzleType = twistyPuzzleTypeIn;
		
		repaint();
	}
	
	public void setCurrentUserName(String currentUserNameIn){
	
		currentUserName = currentUserNameIn;
		
		repaint();
	}
	
	public void setAvarageOf5(String avarageOf5In){
	
		avarageOf5 = avarageOf5In;
		
		repaint();
	}
	
	public void setLast20Solves(ArrayList<Double> last20SolvesIn){
	
		last20Solves = last20SolvesIn;
		
		repaint();
	}
	
	public ArrayList<Double> getLast20Solves(){
	
		return last20Solves;
	}
	
	public String getRandomScramble(){
	
		return randomScramble;
	}
	
	public void setRandomScramble(String randomScrambleIn){
	
		if(randomScrambleIn.contains("/n")){
			
			randomScrambleAfterSplit = randomScrambleIn.split("/n");
			scrambleSize = randomScrambleAfterSplit[0].length() / 2.0 + 4.0;
			useStringListForRandomScramble = true;
		}
		
		else{
			
			randomScramble = randomScrambleIn;
			scrambleSize = randomScramble.length() / 2.0 + 4.0;
			useStringListForRandomScramble = false;
		}
		
		if(scrambleSize < 4.0){
			scrambleSize = 4.0;
		}
		
		repaint();
	}
	
	public void setScrambleLenght(int scrambleLenghtIn){
	
		scrambleLenght = scrambleLenghtIn;
		
		repaint();
	}
	
	public int getScrambleLength(){
	
		return scrambleLenght;
	}
	
	public String getTime(){
	
		return time;
	}
	
	public void setTime(String timeIn){
	
		time = timeIn;
		
		repaint();
	}
	
	public boolean getRunning(){
	
		return running;
	}
	
	public void setRunning(boolean runningIn){
	
		running = runningIn;
	}
	
	public boolean getCountDownRunning(){
	
		return countDownRunning;
	}
	
	public void setCountDownRunning(boolean countDownRunningIn){
	
		countDownRunning = countDownRunningIn;
	}
	
	public int getTimePenalty(){
	
		return timePenalty;
	}
	
	public void setTimePenlaty(int timePenaltyIn){
	
		timePenalty = timePenaltyIn;
	}
	
	public boolean getDNF(){
		return DNF;
	}
	
	public void setDNF(boolean DNFIn){
		DNF = DNFIn;
	}
	
	public double getScrambleSize(){
	
		return scrambleSize;
	}
	
	public void setScrambleSize(double scrambleSizeIn){
	
		scrambleSize = scrambleSizeIn;
	}
	
	public boolean getIgnoreNextRelese(){
	
		return ignoreNextRelese;
	}
	
	public void setIgnoreNextRelese(boolean ignoreNextReleseIn){
	
		ignoreNextRelese = ignoreNextReleseIn;
	}
	
	public void setGreenText(boolean greenTextIn){
	
		greenText = greenTextIn;
		
		repaint();
	}
	
	public boolean getConsoleRequiresAttention(){
	
		return consoleRequiresAtention;
	}
	
	public void setConsoleRequiresAttention(boolean consoleRequresAttentionIn){
	
		consoleRequiresAtention = consoleRequresAttentionIn;
	}
	
	public void setAddNotChangeUser(boolean addNotChangeUserIn){
	
		addNotChangeUser = addNotChangeUserIn;
	}
	
	public boolean getAddNotChangeUser(){
	
		return addNotChangeUser;
	}
	
	public boolean getPaintComponentDone(){
	
		return paint.getPaintComponentDone();
	}
	
	public void setScreenSize(int screenWidthIn, int screenHeightIn){
	
		screenWidth = screenWidthIn;
		screenHeight = screenHeightIn;
		
		repaint();
	}
	
}
