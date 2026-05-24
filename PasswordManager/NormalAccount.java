package PasswordManager;

class NormalAccount extends Account {
    public NormalAccount(String website, String username, String password, String masterKey) {
        super(website, username, password, masterKey);
        
    }

    @Override
    public void securityLevel() {
        System.out.println("Basic Security - Consider enabling 2FA");
    }
}

    

 