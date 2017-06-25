package fields;

import java.awt.Color;

public class Constants{

    public final static int keyRefreshRate = 64;
        // in miliseconds
        // the lower the better, the higher the more sure that it will work
        // this only matter for linux
    public final static String windowName = "Cube Timer";
        // in theory this will get changed to a veriable
    public final static String addUserPrompt = "What is your new users name?";
    public final static String changeUserPrompt = "What is the name of the user"
        + " you would like to switch to?";
    public final static String incorrectUserMessage = "That user does not exist"
        + ". You may have typed it wrong. Good luck if you try again.";
    public final static String firstUserNamePrompt = "What is your first users "
        + "name?";
    public final static String cannotDeleteLastUser = "Sorry, you can't delete "
        + "that user, It is the only one left";
    public final static String renameUserPrompt = "What is your users new name";
    public final static int megaMinxDefaultScrambleLength = 40;
    public final static int defaultScrambleLength = 20;
    public final static int defaultScrambleLength2x2 = 10;
    public final static double defaultScrambleSize = 28.0;
    public final static int minimumScrambleLength = 1;
    public final static String lineSeperator = "/n";
    public final static String font = "Courier";
    public final static int windowWidthOverLeftMargin = 32;
    public final static double fontSize = 1.696;
    public final static double screenHeightPorportion = 2.0/3.0;
    public final static double screenWidthPorportion = 2.0/3.0;
    public final static Color menuBackgroundColor = Color.WHITE;
    public final static int timerUpdateInterval = 1000; // in miliseconds
    public final static String initialShownTime = "0.00";
    public final static DisplayState initialDisplayState = DisplayState.timer;
        // if you change it you may have to modify other code
    public final static int countDownTime = 15; // in seconds
    public final static int secondsPerMinute = 60; // for debugging
    public final static TwistyPuzzleType startingPuzzle
        = TwistyPuzzleType.cube3x3x3;
}
