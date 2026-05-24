package PasswordManager;

abstract class Account {
    //first initialize variables
    String username;//Inplace of Username Substute with userName you take as input
    private String password;
    
    //constructor 
    public Account(String username, String password){
        this.username = username;
        this.password = password;
    }
    //means every account must define securityLevel
    public abstract void securityLevel();

    public void showDetails(){
        System.out.println("Username:-"+username);
        System.out.println("Password:-*********");
    }
    public void showPassword(String masterKey){
        if(masterKey.equals("admin")){//In place of admin substitute with user hint passowrd
            System.out.println("Password:-"+password);
        }
        else{
            System.out.println("Incorrect Key!");
        }
    }
}







    

