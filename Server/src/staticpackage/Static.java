package staticpackage;

import java.util.ArrayList;

public class Static{

    public static ArrayList<String> copyArrayListString(ArrayList<String> old){
        
        ArrayList<String> newList = new ArrayList<String>();
        
        for(int i = 0; i<old.size(); i++){
            newList.add(old.get(i));
        }
        
        return newList;
    }
}
