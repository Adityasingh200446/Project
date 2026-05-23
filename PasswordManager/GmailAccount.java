package PasswordManager;

    class GmailAccount extends Account{
        public GmailAccount(String username, String password){
            super(username,password);
            
            if(!username.contains("@gmail.com")){
                throw new IllegalArgumentException("Not valid gmail address");
            }
        }
        @Override
        public void securityLevel(){
            System.out.println("2FA Authentication for Password Enabled");
        }
    }

    

 