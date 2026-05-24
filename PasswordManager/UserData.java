package PasswordManager;


public class UserData {
    private String name;
    private String dob;
    private String pan;
    private String masterKey;

    public UserData(String name, String dob, String pan, String masterKey){
        this.name= name;
        this.dob = dob;
        this.pan = pan;
        this.masterKey = masterKey;

    }
    public String getName()      { return name; }
    public String getDob()       { return dob; }
    public String getPan()       { return pan; }
    public String getMasterKey() { return masterKey; }
    
}

