package cubetimer;

import java.util.ArrayList;

import javax.swing.WindowConstants;

import fields.Fields;

public class Main{
	
	private static ArrayList <Integer> screenSize = 
		Actions.getDefaultWindowSize();
	private static int width = screenSize.get(0);
	private static int height = screenSize.get(0);
	
	private static Fields f;
	private static FileWriter fw;
	private static Paint p;
	private static Scrambler s;
	private static Stackmat t;
	private static Actions a;
	private static CloseOperation co;
	private static Display d;
	
	public static void main(String[] args){
		
		f = new Fields();
		Actions.callUponOpen(f);
		fw = new FileWriter();
		p = new Paint(f);
		s = new Scrambler(f, p);
		t = new Stackmat(f, s, p, fw);
		a = new Actions();
		co = new CloseOperation(f);
		d = new Display(co, p, f, t, s, a);
		
	
		d.setSize(width, height);
		d.setResizable(true);
		d.setVisible(true);
		d.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		d.setTitle("Cube Timer");
		d.setLocationRelativeTo(null);
		d.addWindowListener(d);
		
	}

}
