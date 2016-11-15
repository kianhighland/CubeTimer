package keyBindings;

import javax.swing.JComponent;
import javax.swing.KeyStroke;

import cubetimer.Actions;
import cubetimer.Paint;
import cubetimer.Scrambler;
import cubetimer.Stackmat;
import fields.Fields;
import swingTimerActions.SpaceReleased;

@SuppressWarnings("serial")
public class KeyBindings extends JComponent{
	
    private Fields fields;
    private Paint paint;
    private Scrambler scrambler;
    private Actions actions;
    private Stackmat stackmat;
    
    private SpaceKeyAction spaceAction;
    private SpaceReleasedAction spaceReleasedAction;
	
    private EscapeKeyPressedAction escapeAction;
    private EnterKeyPressedAction enterAction;
    private UpArrowPressedAction upAction;
    private DownArrowPressedAction downAction;
    private LeftArrowPressedAction leftAction;
    private RightArrowPressedAction rightAction;
	
    public KeyBindings(Fields fieldsIn, Paint paintIn, Scrambler scramblerIn,
        Actions actionsIn, Stackmat stackmatIn){
		
        fields = fieldsIn;
        paint = paintIn;
        scrambler = scramblerIn;
        actions = actionsIn;
        stackmat = stackmatIn;
   
        spaceAction = new SpaceKeyAction(fields, paint, stackmat);
        spaceReleasedAction = new SpaceReleasedAction(fields, stackmat);
		
        escapeAction = new EscapeKeyPressedAction(fields, paint);
        enterAction = new EnterKeyPressedAction(fields, paint, scrambler,
            actions);
        upAction = new UpArrowPressedAction(fields, paint, scrambler);
        downAction = new DownArrowPressedAction(fields, paint, scrambler);
        rightAction = new RightArrowPressedAction(fields, paint);
        leftAction = new LeftArrowPressedAction(fields, paint);
        
        this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "SpacePressed");
        this.getActionMap().put("SpacePressed", spaceAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("released SPACE"),
            "SpaceReleased");
        this.getActionMap().put("SpaceReleased", spaceReleasedAction);

        this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "LeftPressed");

        this.getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"),
            "EscapePressed");
        this.getActionMap().put("EscapePressed", escapeAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "EnterPressed");
        this.getActionMap().put("EnterPressed", enterAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("UP"), "UpPressed");
        this.getInputMap().put(KeyStroke.getKeyStroke("K"), "UpPressed");
        this.getActionMap().put("UpPressed", upAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("J"), "DownPressed");
        this.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "DownPressed");
        this.getActionMap().put("DownPressed", downAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "LeftPressed");
        this.getInputMap().put(KeyStroke.getKeyStroke("H"), "LeftPressed");
        this.getActionMap().put("LeftPressed", leftAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "RightPressed");
        this.getInputMap().put(KeyStroke.getKeyStroke("L"), "RightPressed");
        this.getActionMap().put("RightPressed", rightAction);
        
    }
	
}
