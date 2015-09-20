package cubetimer;

import fields.TwistyPuzzleType;

import java.awt.*;
import java.util.ArrayList;

public class Images{
	
	public Images(){
	
	}
	
	public static void typeStringListCentered(String[] string, int x, int y, int fontSize, Graphics g){
	
		Font font = new Font("Arial", Font.PLAIN, fontSize);
		g.setFont(font);
		g.setColor(Color.BLACK);
		
		for(int i = 0; i < string.length; i ++){
			g.drawString(string[i], x, y - (string.length / 2 - i) * fontSize);
		}
		
	}
	
	public static void typeTimes(ArrayList<String> arrayList, int x, int y, int fontSize,
			Graphics g){
		
		Font font = new Font("Arial", Font.PLAIN, fontSize);
		g.setFont(font);
		g.setColor(Color.BLACK);
		
		for(int i = 0; i < arrayList.size(); i ++){
			
			g.drawString(arrayList.get(i), x, y
					+ (i * fontSize));
		}
	}
	
	public static void typeString(String string, int x, int y, int fontSize, boolean green, Graphics g){
	
		Font font = new Font("Arial", Font.PLAIN, fontSize);
		g.setFont(font);
		
		if(green){
			g.setColor(Color.GREEN);
		}
		else{
			g.setColor(Color.BLACK);
		}
		
		g.drawString(string, x, y);
	}
	
	public static void typeScrambleType(TwistyPuzzleType twistyPuzzleType, int x, int y, int fontSize, Graphics g){
	
		Font font = new Font("Arial", Font.PLAIN, fontSize);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString(twistyPuzzleType.toString(), x, y);
	}
	
	public static void drawBackGround(Color color, int screenWidth, int screenHeight, Graphics g){
	
		g.drawRect(30, 30, 100, 100);
		g.setColor(color);
		g.fillRect(0, 0, screenWidth, screenHeight);
	}
	
	public static void drawMenuList(String[] menuItems, int fontSize, Boolean[] greenText,
			int windowHeight, int windowWidth, int lineSpacingSize, Graphics g){
		
		drawBackGround(Color.WHITE, windowWidth, windowHeight, g);
		
		for(int i = 0; i < menuItems.length; i ++){
			
			typeString(menuItems[i], 0, (windowWidth / (20 * (lineSpacingSize))) * (i + 2)
					+ (windowWidth / (50 * lineSpacingSize)) * (i + 1), fontSize, greenText[i], g);
		}
	}
}
