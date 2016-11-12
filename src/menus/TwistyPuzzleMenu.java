package menus;

public class TwistyPuzzleMenu{
    
    private boolean cube2x2x2;
    private boolean cube3x3x3;
    private boolean cube4x4x4;
    private boolean cube5x5x5;
    private boolean megaMinx;
    private boolean curvyCopter;
    private boolean gearCube;
    private boolean anisatropicGearCube;
    private boolean oneHanded3x3x3;
    private boolean cuboid3x3x1;
    
    private boolean randomTwistyPuzzle;
    
    private boolean exit;
    
    public TwistyPuzzleMenu(){
    
        cube2x2x2 = false;
        cube3x3x3 = true;
        cube4x4x4 = false;
        cube5x5x5 = false;
        megaMinx = false;
        curvyCopter = false;
        gearCube = false;
        anisatropicGearCube = false;
        oneHanded3x3x3 = false;
        cuboid3x3x1 = false;
        randomTwistyPuzzle = false;
        exit = false;
        
    }
    
    private void allFalse(){
    
        cube2x2x2 = false;
        cube3x3x3 = false;
        cube4x4x4 = false;
        cube5x5x5 = false;
        megaMinx = false;
        gearCube = false;
        curvyCopter = false;
        anisatropicGearCube = false;
        oneHanded3x3x3 = false;
        randomTwistyPuzzle = false;
        exit = false;
    }
    
    public void upOne(){
    
        if(cube2x2x2){
            
            allFalse();
            
            exit = true;
        }
        
        else if(cube3x3x3){
            
            allFalse();
            
            cube2x2x2 = true;
        }
        
        else if(cube4x4x4){
            
            allFalse();
            
            cube3x3x3 = true;
        }
        
        else if(cube5x5x5){
            
            allFalse();
            
            cube4x4x4 = true;
        }
        
        else if(megaMinx){
            
            allFalse();
            
            cube5x5x5 = true;
        }
        
        else if(curvyCopter){ // at this point in time, there is no curvy copter
            
            allFalse();
            
            megaMinx = true;
        }
        
        else if(gearCube){
            
            allFalse();
            
            megaMinx = true;
        }
        
        else if(anisatropicGearCube){
            
            allFalse();
            
            gearCube = true;
        }
        
        else if(oneHanded3x3x3){
            
            allFalse();
            
            anisatropicGearCube = true;
        }

        else if(cuboid3x3x1){
            
            allFalse();

            oneHanded3x3x3 = true;
        }
        
        else if(randomTwistyPuzzle){
            
            allFalse();
            
            cuboid3x3x1 = true;
        }
        
        else if(exit){
            
            allFalse();
            
            randomTwistyPuzzle = true;
        }
        
    }
    
    public void downOne(){
    
        if(cube2x2x2){
            
            allFalse();
            
            cube3x3x3 = true;
        }
        
        else if(cube3x3x3){
            
            allFalse();
            
            cube4x4x4 = true;
        }
        
        else if(cube4x4x4){
            
            allFalse();
            
            cube5x5x5 = true;
        }
        
        else if(cube5x5x5){
            
            allFalse();
            
            megaMinx = true;
        }
        
        else if(megaMinx){
            
            allFalse();
            
            gearCube = true;
        }
        
        else if(gearCube){
            
            allFalse();
            
            anisatropicGearCube = true;
        }
        
        else if(anisatropicGearCube){
            
            allFalse();
            
            oneHanded3x3x3 = true;
        }
        
        else if(oneHanded3x3x3){
            
            allFalse();
            
            cuboid3x3x1 = true;
        }

        else if(cuboid3x3x1){
 
            allFalse();
        
            randomTwistyPuzzle = true;
        }

        else if(randomTwistyPuzzle){
            
            allFalse();
            
            exit = true;
        }
        
        else if(exit){
            
            allFalse();
            
            cube2x2x2 = true;
        }
        
    }
    
    public boolean get2x2x2(){
    
        return cube2x2x2;
    }
    
    public boolean get3x3x3(){
    
        return cube3x3x3;
    }
    
    public boolean get4x4x4(){
    
        return cube4x4x4;
    }
    
    public boolean get5x5x5(){
    
        return cube5x5x5;
    }
    
    public boolean getMegaMinx(){
    
        return megaMinx;
    }
    
    public boolean getGearCube(){
    
        return gearCube;
    }
    
    public boolean getAnisatropicGearCube(){
    
        return anisatropicGearCube;
    }
    
    public boolean getOneHanded3x3x3(){
    
        return oneHanded3x3x3;
    }

    public boolean getCuboid3x3x1(){
        return cuboid3x3x1;
    }
    
    public boolean getRandomTwistyPuzzle(){
    
        return randomTwistyPuzzle;
    }
    
    public boolean getExit(){
    
        return exit;
    }
}
