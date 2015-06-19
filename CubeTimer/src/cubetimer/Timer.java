
package cubetimer;
 
import java.awt.Color;
import java.awt.Graphics;
 
import javax.swing.JPanel;
 
 
public class Timer extends JPanel{
    private Images images;
    private Actions actions;
    private Scrambler scrambler;
    private String time;
    private String randomScramble;
    private boolean countdownRunning;
    private double countdownStart;
    private double countdownEnd;
    private boolean spacePressed;
    private boolean running;
    private boolean ignoreNextRelease;
    private boolean spaceReleased;
    private boolean greenText;
     
    public Timer(){
    	running = false;
        time = "0:0.0";
        images = new Images();
        actions = new Actions();
        scrambler = new Scrambler();
        randomScramble = scrambler.GenerateRandomScramble();
        countdownRunning = false;
    }
    public void spacePressed(){
    	spacePressed = true;
    }
    public void spaceReleased(){
    	spaceReleased = true;
    }
    public void startCountDown(){
    	countdownRunning = true;
    	countdownStart =  (double) (System.currentTimeMillis()/1000.0);
    	repaint();
    }
    public void updateCountdownTime(){
    	countdownEnd = (double) System.currentTimeMillis()/1000.0;
    	if (countdownEnd - countdownStart < 15){
    		int timeInspected = (int) (countdownEnd - countdownStart);
    		String timeLeftOfInspection = Integer.toString(15 - timeInspected);
    		time = timeLeftOfInspection;
    		
    	}
    	else{
    		running = true;
    		time = actions.startTimer();
    		countdownRunning = false;
    	}
		repaint();
    }
    public void keepTime(){
        if (running){
            time = actions.getTime();
        }
        if (spacePressed){
        	spacePressed = false;
        	if(running){
            	randomScramble = scrambler.GenerateRandomScramble();
        		running = false;
        		time = actions.getTime();
        		ignoreNextRelease = true;
        	}
        	else{
        		greenText = true;
        	}
        }
        if(spaceReleased){
        	spaceReleased = false;
        	greenText = false;
        	if(ignoreNextRelease){
        		ignoreNextRelease = false;
        	}
        	else{
        		if(!running){
                	randomScramble = scrambler.GenerateRandomScramble();
        			if (countdownRunning){
        				countdownRunning = false;
        				running = true;
        				time = actions.startTimer();
        			}
        			else{
        				startCountDown();
        			}
        		}
        	}
        }
        if (countdownRunning){
        	updateCountdownTime();
        }
        repaint();
    }
    public void paintComponent (Graphics g){
  //      System.out.println("called paint component");
        super.paintComponents(g);
        images.drawBackGround(Color.WHITE, g);
        images.typeString(time, 300, 400, 60, greenText, g);
        images.typeString(randomScramble,0,200,30, false, g);
    }
 
}