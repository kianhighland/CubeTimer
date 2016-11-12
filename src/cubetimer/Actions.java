package cubetimer;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.swing.Timer;

import fields.Constants;
import fields.DisplayState;
import fields.Fields;
import fields.TwistyPuzzleType;
import fields.WindowSize;
import savedData.User;
import swingTimerActions.ChangeUser;

public class Actions {

    public static void callUponOpen(Fields fields) {

        fields.getAllUsers().addUser(new User());

        @SuppressWarnings("resource")
        Scanner userInput = new Scanner(System.in);
        System.out.println(Constants.firstUserNamePrompt);
        String userName = userInput.nextLine();
        fields.getAllUsers().getUser(0).setUserName(userName);
        fields.getAllUsers().setCurrentUserIndex(0);
        fields.changeSinceLastRepaint();
    }

    public static void addUser(Fields fields, Paint paint) {

        @SuppressWarnings("resource")
        Scanner userInput = new Scanner(System.in);

        System.out.println(Constants.addUserPrompt);
        String userName = userInput.nextLine();
        fields.getAllUsers().addUser(new User());
        fields.getAllUsers().setCurrentUserIndex(fields.getAllUsers()
            .getSize() - 1);
        fields.getAllUsers().getUser().setUserName(userName);
        fields.setDisplayState(DisplayState.timer);
        fields.getAllUsers().getUser().getTwistyPuzzle().setLastAvarageOf5();
        fields.changeSinceLastRepaint();

        paint.repaint();
    }

    public static void changeUser(Fields fields, Paint paint) {

        @SuppressWarnings("resource")
        Scanner userInput = new Scanner(System.in);

        System.out.println(Constants.changeUserPrompt);
        String userName = userInput.nextLine();

        if (fields.getAllUsers().getIndexOfUserWithUserName(userName) < 0) {
            System.out.println(Constants.incorrectUserMessage);
        } else {
            fields.getAllUsers().setCurrentUserUsingUserName(userName);
        }

        fields.getAllUsers().getUser().getTwistyPuzzle().setLastAvarageOf5();
        fields.changeSinceLastRepaint();

        paint.repaint();
    }

    public static void deleteCurrentUser(Fields fields, Paint paint) {

        if (fields.getAllUsers().getSize() > 1) {

            fields.getAllUsers().remove();
            fields.changeSinceLastRepaint();

            paint.repaint();

            Timer changeUser = new Timer(0, new ChangeUser(fields));
            changeUser.setRepeats(false);

            fields.setDisplayState(DisplayState.changeUser);
        }

        else {

            fields.setDisplayState(DisplayState.timer);
            fields.changeSinceLastRepaint();
            System.out.println(Constants.cannotDeleteLastUser);
            
            paint.repaint();
        }

    }

    public static void renameCurrentUser(Fields fields, Paint paint) {

        @SuppressWarnings("resource")
        Scanner userInput = new Scanner(System.in);

        System.out.println(Constants.renameUserPrompt);
        String userName = userInput.nextLine();
        fields.getAllUsers().getUser().setUserName(userName);
        fields.setDisplayState(DisplayState.timer);
        fields.changeSinceLastRepaint();

        paint.repaint();
    }

    public static void randomTwistyPuzzle(Fields fields) {

        Random random = new Random();

        int randomNumber = random.nextInt(TwistyPuzzleType.values().length);
        fields.getAllUsers().getUser().setTwistyPuzzleType(
                TwistyPuzzleType.values()[randomNumber]);

        fields.changeSinceLastRepaint();

    }

    public static void setScrambleInFields(Fields fields,String randomScramble){

        if (randomScramble.contains(Constants.lineSeperator)) {

/*            fields.getDisplayedData().getScrambleData()
                .setRandomScrambleAfterSplit(randomScramble.split(
                Constants.lineSeperator));
            String[] scramble = randomScramble.split(Constants.lineSeperator);
            double scrambleSize = 0;
            for(int i = 0; i < scramble.length; i++){
                String scrambleRow = scramble[i];
                double length = 0;
                for(int j = 0; j < scrambleRow.length(); j++){
                    if(("" + scrambleRow.charAt(j)).matches("-")){
                        length ++;
                    }
                    else{
                        length += 3.4;
                    }
                    if(("" + scrambleRow.charAt(j)).matches("'")){
                    }
                }
                if(length > scrambleSize){
                    scrambleSize = length;
                }
            }
            scrambleSize = scrambleSize / 4.7;
            fields.getDisplayedData().getScrambleData().setScrambleSize(
                scrambleSize);
            fields.getDisplayedData().getScrambleData()
                .setUseStringListForRandomScramble(true);*/
            fields.getDisplayedData().getScrambleData()
                .setRandomScrambleAfterSplit(randomScramble.split(
                Constants.lineSeperator));
            double size;
            if (randomScramble.split(Constants.lineSeperator)[1].contains("'")){
                size = randomScramble.split(Constants.lineSeperator)[1]
                    .length() / Constants.fontSize;
            }
            else{
                size = (randomScramble.split(Constants.lineSeperator)
                    [1].length() + 1) / Constants.fontSize;
            fields.getDisplayedData().getScrambleData().setScrambleSize(size);
            fields.getDisplayedData().getScrambleData()
                .setUseStringListForRandomScramble(true);
            }
        }

        else {

            fields.getDisplayedData().getScrambleData()
                .setRandomScramble(randomScramble);
            fields.getDisplayedData().getScrambleData()
                .setScrambleSize(randomScramble.length() / Constants.fontSize);
            fields.getDisplayedData().getScrambleData()
                .setUseStringListForRandomScramble(false);
        }

/*        if (fields.getDisplayedData().getScrambleData()
            .getScrambleSize() < 4.0) {

            fields.getDisplayedData().getScrambleData().setScrambleSize(4.0);
        }*/
        
        fields.changeSinceLastRepaint();
    }

    public static ArrayList<Integer> getDefaultWindowSize() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) ((screenSize.getWidth() * 2) / 3);
        int height = (int) ((screenSize.getHeight() * 2) / 3);

        ArrayList<Integer> windowSize = new ArrayList<Integer>();
        windowSize.addAll(Arrays.asList(new Integer[] { width, height }));
        return windowSize;
    }

}
