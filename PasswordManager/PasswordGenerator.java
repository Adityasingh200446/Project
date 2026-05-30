package PasswordManager;
import java.util.Random;

public class PasswordGenerator {
    private String name;
    private String dob;
    private String pan;
    private String masterKey;
    private String generatedPassword;

    public PasswordGenerator(String name, String dob, String pan, String masterKey) {
        this.name      = name;
        this.dob       = dob;
        this.pan       = pan;
        this.masterKey = masterKey;
        this.generatedPassword = generate(name, dob, pan, masterKey);
    }

    public static String generate(String name, String dob, String pan, String masterKey) {
        String namePart = name.length()      >= 3 ? name.substring(0, 3)      : name;
        String dobPart  = dob.length()       >= 8 ? dob.substring(6)          : dob;
        String panPart  = pan.length()       >= 6 ? pan.substring(0, 4)       : pan;
        String keyPart  = masterKey.length() >= 3 ? masterKey.substring(0, 3) : masterKey;
        int random = new Random().nextInt(900) + 100;
        return namePart + dobPart + "@" + panPart + keyPart + random;
    }

    public String checkStrength() {
        if (generatedPassword.length() > 12 && generatedPassword.contains("@")) {
            return "Strong Password!";
        } else {
            return "Weak Password!";
        }
    }

    public void showDetails() {
        System.out.println("Name      : " + name);
        System.out.println("Password  : ********");
        System.out.println("Strength  : " + checkStrength());
    }

    public void showPassword(String inputKey) {
        if (inputKey.equals(masterKey)) {
            System.out.println("Password  : " + generatedPassword);
        } else {
            System.out.println("Incorrect Master Key!");
        }
    }

    public String getGeneratedPassword() { return generatedPassword; }
    public String getMasterKey()         { return masterKey; }
}