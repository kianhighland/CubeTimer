package menus;


public class Menu{
    
    private UserActionsMenu userActionsMenu;
    private TwistyPuzzleMenu twistyPuzzleMenu;
    private OptionsMenu optionsMenu;
    private TimeMenu timeOptionMenu;
    
    private boolean changeTwistyPuzzle;
    private boolean userMenu;
    private boolean changeScrambleLength;
    private boolean deleteLastSolve;
    private boolean newScramble;
    private boolean timeMenu;
    private boolean options;
    private boolean exit;
    private boolean quit;
    
    public Menu(){
    
        setUserActionsMenu(new UserActionsMenu());
        setTwistyPuzzleMenu(new TwistyPuzzleMenu());
        setOptionsMenu(new OptionsMenu());
        setTimeMenu(new TimeMenu());
        
        changeTwistyPuzzle = true;
        userMenu = false;
        changeScrambleLength = false;
        deleteLastSolve = false;
        newScramble = false;
        timeMenu = false;
        options = false;
        exit = false;
        quit = false;
    }
    
    private void allFalse(){
    
        changeTwistyPuzzle = false;
        userMenu = false;
        changeScrambleLength = false;
        newScramble = false;
        timeMenu = false;
        options = false;
        exit = false;
        quit = false;
    }
    
    public void downOne(){
    
        if(changeTwistyPuzzle){
            changeTwistyPuzzle = false;
            userMenu = true;
        }
        
        else if(userMenu){
            userMenu = false;
            changeScrambleLength = true;
        }
        
        else if(changeScrambleLength){
            changeScrambleLength = false;
            deleteLastSolve = true;
        }
        
        else if(deleteLastSolve){
            deleteLastSolve = false;
            newScramble = true;
        }
        
        else if(newScramble){
            newScramble = false;
            timeMenu = true;
        }
        
        else if(timeMenu){
            timeMenu = false;
            options = true;
        }
        
        else if(options){
            options = false;
            exit = true;
        }
        
        else if(exit){
            exit = false;
            quit = true;
        }
        
        else{
            allFalse();
            changeTwistyPuzzle = true;
        }
    }
    
    public void upOne(){
    
        if(changeTwistyPuzzle){
            changeTwistyPuzzle = false;
            quit = true;
        }
        
        else if(userMenu){
            userMenu = false;
            changeTwistyPuzzle = true;
        }
        
        else if(changeScrambleLength){
            changeScrambleLength = false;
            userMenu = true;
        }
        
        else if(deleteLastSolve){
            deleteLastSolve = false;
            changeScrambleLength = true;
        }
        
        else if(newScramble){
            newScramble = false;
            deleteLastSolve = true;
        }
        
        else if(timeMenu){
            timeMenu = false;
            newScramble = true;
        }
        
        else if(options){
            options = false;
            timeMenu = true;
        }
    
        else if(exit){
            exit = false;
            options = true;
        }
        
        else{
            allFalse();
            exit = true;
        }
    }
    
    public boolean getChangeTwistyPuzzle(){
    
        return changeTwistyPuzzle;
    }
    
    public boolean getUserMenu(){
    
        return userMenu;
    }
    
    public boolean getChangeScrambleLenght(){
    
        return changeScrambleLength;
    }
    
    public boolean getDeleteLastSolve(){
        
        return deleteLastSolve;
    }
    
    public boolean getNewScramble(){
    
        return newScramble;
    }
    
    public boolean getTimeMenu(){
        
        return timeMenu;
    }
    
    public boolean getOptions(){
    
        return options;
    }
    
    public boolean getExit(){
    
        return exit;
    }
    
    public boolean getQuit(){
        
        return quit;
    }

    public OptionsMenu getOptionsMenu() {
        return optionsMenu;
    }

    public void setOptionsMenu(OptionsMenu optionsMenuIn) {
        optionsMenu = optionsMenuIn;
    }

    public TwistyPuzzleMenu getTwistyPuzzleMenu() {
        return twistyPuzzleMenu;
    }

    public void setTwistyPuzzleMenu(TwistyPuzzleMenu twistyPuzzleMenuIn) {
        twistyPuzzleMenu = twistyPuzzleMenuIn;
    }

    public UserActionsMenu getUserActionsMenu() {
        return userActionsMenu;
    }

    public void setUserActionsMenu(UserActionsMenu userActionsMenuIn) {
        userActionsMenu = userActionsMenuIn;
    }

    public TimeMenu getTimeOptionMenu(){
        return timeOptionMenu;
    }

    public void setTimeMenu(TimeMenu timeMenuIn){
        timeOptionMenu = timeMenuIn;
    }
}
