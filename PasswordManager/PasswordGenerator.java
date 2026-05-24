package PasswordManager;
import java.util.*;

public class PasswordGenerator {
    public static String generate(String name, String dob, String pan, String masterKey){
        String namepart = name.length() >= 3 ? name.substring(0,3):name;
        String dobpart = dob.length() >=8 ? dob.substring(6):dob;
        String panpart = pan.length() >=6 ? pan.substring(0,4):pan;
        String favpart = masterKey.length() >=3 ? masterKey.substring(0,3):masterKey;

        int random = new Random().nextInt(900)+100;


        return namepart+dobpart+"@"+panpart+favpart+random;

    }

    
}
