package extendjdk.otherpackage;

import java.util.ArrayList;

public class ArrayListString extends ArrayList{

    public ArrayListString(ArrayListString original){

        super();
        for(int i = 0; i < original.size(); i++){
            add(original.get(i));
        }
    }

    public ArrayListString(){}

    public void add(int toAdd) throws InvalidMethod{
        throw new InvalidMethod();
    }
}
