package cubetimer;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import fields.Constants;
import fields.DisplayState;
import fields.Fields;

@SuppressWarnings("serial")
public class Paint extends JPanel {

    private Fields fields;

    public Paint(Fields f) {

        fields = f;
    }

    private void consoleRequiresAttention(Graphics g) {

        Images.drawBackGround(Color.GRAY, fields.getWindowSize()
            .getWindowWidth(), fields.getWindowSize().getWindowHeight(), g);
        Images.typeString("The Console Requires", 0, fields.getWindowSize()
            .getWindowHeight() / 2 - fields.getWindowSize().getWindowWidth()
            / 28, fields.getWindowSize().getWindowWidth() / 14, false, g);
        Images.typeString("Your Attention", 0, fields.getWindowSize()
            .getWindowHeight() / 2 + fields.getWindowSize().getWindowWidth()
            / 28, fields.getWindowSize().getWindowWidth() / 14, false, g);

        fields.setPaintComponentDone(true);
    }

    private void timer(Graphics g) {

        Images.drawBackGround(Color.WHITE, fields.getWindowSize()
            .getWindowWidth(), fields.getWindowSize().getWindowHeight(), g);

        Images.typeString(fields.getDisplayedData().getTime(),
            fields.getWindowSize().getWindowWidth() / 2 - 100,
            fields.getWindowSize().getWindowHeight() / 2,
            fields.getWindowSize().getWindowWidth() / 14,
            fields.getGreenText(), g);

        if (fields.getDisplayedData().getScrambleData()
            .getUseStringListForRandomScramble()) {

            Images.typeStringListCentered(fields.getDisplayedData()
                .getScrambleData().getRandomScrambleAfterSplit(),
                fields.getWindowSize().getWindowWidth() /
                Constants.windowWidthOverLeftMargin,
                fields.getWindowSize().getWindowHeight() / 4,
                (int) ((fields.getWindowSize().getWindowWidth()
                - (2 * fields.getWindowSize().getWindowWidth() /
                Constants.windowWidthOverLeftMargin)) /
                fields.getDisplayedData().getScrambleData().getScrambleSize()),
                g);
        }

        else {
            Images.typeString(fields.getDisplayedData().getScrambleData()
                .getRandomScramble(),
                fields.getWindowSize().getWindowWidth() /
                Constants.windowWidthOverLeftMargin,
                fields.getWindowSize().getWindowHeight() / 4, (int)(
                (fields.getWindowSize().getWindowWidth() - (2 *
                fields.getWindowSize().getWindowWidth() /
                Constants.windowWidthOverLeftMargin))/
                fields.getDisplayedData().getScrambleData().getScrambleSize()),
                false, g);
        }

        Images.typeTimes(fields.getAllUsers().getUser().getTwistyPuzzle()
            .getAllSolves(), 0, fields.getWindowSize().getWindowWidth() / 56,
            fields.getWindowSize().getWindowWidth() / 56, g);
        Images.typeString(
            fields.getAllUsers().getUser().getTwistyPuzzle().getAvarageOf5(), 0,
            (int) (fields.getWindowSize().getWindowHeight() - (30 +
            fields.getWindowSize().getWindowWidth() / 56)),
            fields.getWindowSize().getWindowWidth() / 56, false, g);
        Images.typeString(fields.getAllUsers().getUser().getUserName(),
            (int) (fields.getWindowSize().getWindowWidth() / 1.2 - 20.0),
            fields.getWindowSize().getWindowWidth() / 40,
            fields.getWindowSize().getWindowWidth() / 56, false, g);
        Images.typeScrambleType(
            fields.getAllUsers().getUser().getTwistyPuzzleType(),
            (int) (fields.getWindowSize().getWindowWidth() / 1.2 - 20),
            fields.getWindowSize().getWindowWidth() / 20,
            fields.getWindowSize().getWindowWidth() / 56, g);
        Images.typeString(Integer.toString(fields.getAllUsers().getUser()
            .getTwistyPuzzle().getScrambleLength()),
            (int) (fields.getWindowSize().getWindowWidth() / 1.2 - 20),
            fields.getWindowSize().getWindowWidth() / 15,
            fields.getWindowSize().getWindowWidth() / 56, false, g);
    }

    private void menu(Graphics g) {

        String[] menuItems =
            new String[] { "Change Twisty Puzzle", "User Menu",
                "Change Scramble Lenght", "Delete Last Solve",
                "New Scramble", "TimeMenu", "Options", "Exit", "Quit" };

        Boolean[] greenText =
            new Boolean[] { fields.getMenu().getChangeTwistyPuzzle(),
                fields.getMenu().getUserMenu(),
                fields.getMenu().getChangeScrambleLenght(),
                fields.getMenu().getDeleteLastSolve(),
                fields.getMenu().getNewScramble(),
                fields.getMenu().getTimeMenu(), fields.getMenu().getOptions(),
                fields.getMenu().getExit(), fields.getMenu().getQuit() };

        Images.drawMenuList(menuItems, fields.getWindowSize().getWindowWidth()
            / 16, greenText, fields.getWindowSize().getWindowHeight(),
            fields.getWindowSize().getWindowWidth(), 1, g);

    }

    private void changeTwistyPuzzle(Graphics g) {

        String[] menuItems =
            new String[] { "2x2x2", "3x3x3", "4x4x4", "5x5x5", "Mega Minx",
                "Gear Cube", "Anisatropic Gear Cube",
                "One Handed 3x3x3", "3x3x1", "Random Twisty Puzzle", "Exit" };

        Boolean[] greenText =
            new Boolean[] { fields.getMenu().getTwistyPuzzleMenu().get2x2x2(),
                fields.getMenu().getTwistyPuzzleMenu().get3x3x3(),
                fields.getMenu().getTwistyPuzzleMenu().get4x4x4(),
                fields.getMenu().getTwistyPuzzleMenu().get5x5x5(),
                fields.getMenu().getTwistyPuzzleMenu().getMegaMinx(),
                fields.getMenu().getTwistyPuzzleMenu().getGearCube(),
                fields.getMenu().getTwistyPuzzleMenu().getAnisatropicGearCube(),
                fields.getMenu().getTwistyPuzzleMenu().getOneHanded3x3x3(),
                fields.getMenu().getTwistyPuzzleMenu().getCuboid3x3x1(),
                fields.getMenu().getTwistyPuzzleMenu().getRandomTwistyPuzzle(),
                fields.getMenu().getTwistyPuzzleMenu().getExit() };

        Images.drawMenuList(menuItems, fields.getWindowSize().getWindowWidth()
            / 32, greenText, fields.getWindowSize().getWindowHeight(),
            fields.getWindowSize().getWindowWidth(), 2, g);
    }

    public void userMenu(Graphics g) {

        String[] menuItems =
            new String[] { "Add User", "Change User",
                "Delete Current User", "Rename Current User", "Exit" };

        Boolean[] greenText =
            new Boolean[] { fields.getMenu().getUserActionsMenu().getAddUser(),
                fields.getMenu().getUserActionsMenu().getChangeUser(),
                fields.getMenu().getUserActionsMenu().getDeleteCurrentUser(),
                fields.getMenu().getUserActionsMenu().getRenameCurrentUser(),
                fields.getMenu().getUserActionsMenu().getExit() };

        Images.drawMenuList(menuItems, fields.getWindowSize().getWindowWidth()
            / 32, greenText, fields.getWindowSize().getWindowHeight(),
            fields.getWindowSize().getWindowWidth(), 2, g);
    }

    public void timesMenu(Graphics g){
        int amountOfTimes = fields.getAllUsers().getUser().getTwistyPuzzle()
            .getTimeTitles().size();
        String[] times = new String[amountOfTimes];
        times = fields.getAllUsers().getUser()
            .getTwistyPuzzle().getTimeTitles().toArray(times);
        Boolean[] greenText = new Boolean[amountOfTimes];
        for(int i = 0; i < amountOfTimes; i++){
            if(i == fields.getGreenTextIndex()){
                greenText[i] = true;
            }
            else{
                greenText[i] = false;
            }
        }

        Images.drawMenuList(times, fields.getWindowSize().getWindowWidth()
            /32, greenText, fields.getWindowSize().getWindowHeight(),
            fields.getWindowSize().getWindowWidth(), 2, g);
    }

    public void timeMenu(Graphics g){
    
        String[] menuItems = new String[] { "", "Penalty: " + fields.getMenu()
            .getTimeOptionMenu().getTime().getTimePenalty(), "Delete Solve",
            "Exit"};

        if(fields.getMenu().getTimeOptionMenu().getTime().getDNF()){
            menuItems[0] = "X  DNF";
        }
        else{
            menuItems[0] = "   DNF";
        }
        
        Boolean[] greenText = new Boolean[] {
            fields.getMenu().getTimeOptionMenu().getDnf(),
            fields.getMenu().getTimeOptionMenu().getPenalty(),
            fields.getMenu().getTimeOptionMenu().getDelete(),
            fields.getMenu().getTimeOptionMenu().getExit()};

        Images.drawMenuList(menuItems, fields.getWindowSize().getWindowWidth()
            / 32, greenText, fields.getWindowSize().getWindowHeight(),
            fields.getWindowSize().getWindowWidth(), 2, g);
    }

    public void changeScrambleLenght(Graphics g) {

        Images.drawBackGround(Color.WHITE, fields.getWindowSize()
            .getWindowWidth(), fields.getWindowSize().getWindowHeight(), g);

        Images.typeString(Integer.toString(fields.getAllUsers().getUser()
            .getTwistyPuzzle().getScrambleLength()),
            fields.getWindowSize().getWindowWidth() / 2 - 100,
            fields.getWindowSize().getWindowHeight() / 2,
            fields.getWindowSize().getWindowWidth() / 12, true, g);
    }

    public void changeUser(Graphics g) {

        ArrayList<String> arrayListMenuItems = new ArrayList<String>();

        for (int i = 0; i < fields.getAllUsers().getSize(); i++) {

            arrayListMenuItems.add(fields.getAllUsers().getUser(i) 
                .getUserName());
        }

        String[] menuItems = new String[arrayListMenuItems.size()];
        menuItems = (String[]) arrayListMenuItems.toArray(menuItems);

        ArrayList<Boolean> arrayListGreenTexts = new ArrayList<Boolean>();

        for (int i = 0; i < fields.getAllUsers().getSize(); i++) {

            arrayListGreenTexts.add(fields.getMenu().getUserActionsMenu()
                    .getSelectedUserIndex() == i);
        }

        Boolean[] greenTexts = new Boolean[arrayListGreenTexts.size()];
        greenTexts = (Boolean[]) arrayListGreenTexts.toArray(greenTexts);

        Images.drawMenuList(menuItems, 32, greenTexts,
           fields.getWindowSize().getWindowHeight(), fields.getWindowSize()
           .getWindowWidth(), 2, g);
    }

    public void options(Graphics g) {

        Images.drawBackGround(Color.WHITE, fields.getWindowSize()
            .getWindowWidth(), fields.getWindowSize().getWindowHeight(), g);
    }

    public void paintComponent(Graphics g) {
        
        //timeMenu(g);

        if(fields.getChangeSinceLastRepaint()){
    
            fields.repainted();
            
            super.paintComponent(g);
    
            if (fields.getDisplayState()
                == DisplayState.consoleRequiresAttention) {

                consoleRequiresAttention(g);
            }

            else if(fields.getDisplayState() == DisplayState.times){
                timesMenu(g);
            }

            else if(fields.getDisplayState() == DisplayState.timeMenu){
                timeMenu(g);
            }
    
            else if (fields.getDisplayState() == DisplayState.menu) {
    
                menu(g);
            }
    
            else if (fields.getDisplayState()
                == DisplayState.changeTwistyPuzzle) {
    
                changeTwistyPuzzle(g);
            }
    
            else if (fields.getDisplayState() == DisplayState.userMenu) {
    
                userMenu(g);
            }
    
            else if (fields.getDisplayState()
                == DisplayState.changeScrambleLenght) {

                changeScrambleLenght(g);
            }
    
            else if (fields.getDisplayState() == DisplayState.changeUser) {
                changeUser(g);
            }

            else if (fields.getDisplayState() == DisplayState.options) {
            
            }
        
            else {
            
                timer(g);
            }
        }
        
    }
}
