package staticpackage;

import fields.Constants;

public class PrintLine{

    public static void println(String output){

        System.out.print("\b\b\b\b\b\b\b\b");
        System.out.println(output);
        for(int i = 0; i < 8 - output.length(); i++){
            System.out.print(" ");
        }
        System.out.print(Constants.serverInput);
    }
}
