package fields;

public class Constants{

    public final static int keyRefreshRate = 1;
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
    public final static String renameUserPrompt = "What is your users new name";
    public final static int megaMinxDefaultScrambleLength = 40;
    public final static int defaultScrambleLength = 20;
    public final static int defaultScrambleLength2x2 = 10;
    public final static double defaultScrambleSize = 28.0;
    public final static int minimumScrambleLength = 1;
}
