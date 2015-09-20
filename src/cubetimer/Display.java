package cubetimer;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fields.Fields;
import keyBindings.KeyBindings;

@SuppressWarnings("serial")
public class Display extends JFrame implements WindowListener {

	private JPanel gp;
	private KeyBindings kb;
	private CloseOperation co;
	private Fields f;
	private Paint p;

	public Display(CloseOperation coIn, Paint pIn, Fields fIn, Stackmat sm,
			Scrambler s, Actions a) {

		co = coIn;
		f = fIn;
		p = pIn;
		gp = (JPanel) getGlassPane();
		gp.setVisible(true);
		kb = new KeyBindings(f, p, s, a, sm);
		gp.setLayout(new GridLayout(1, 1));
		this.setLayout(new GridLayout(1, 1));
		gp.add(p);
		this.add(kb);

		this.addComponentListener(new ComponentListener() {

			public void componentHidden(ComponentEvent e) {

			}

			public void componentMoved(ComponentEvent e) {

			}

			public void componentResized(ComponentEvent e) {

				Dimension size = getSize();
				f.setScreenSize(size.width, size.height);
			}

			public void componentShown(ComponentEvent e) {

			}
		});

	}

	public void close() {
		System.exit(0);
	}

	public void windowActivated(WindowEvent e) {

	}

	public void windowClosed(WindowEvent e) {

	}

	public void windowClosing(WindowEvent e) {
		co.closeOperation();

	}

	public void windowDeactivated(WindowEvent e) {

	}

	public void windowDeiconified(WindowEvent e) {

	}

	public void windowIconified(WindowEvent e) {

	}

	public void windowOpened(WindowEvent e) {

	}
}
