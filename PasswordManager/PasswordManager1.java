package PasswordManager;
import java.util.*;
public class PasswordManager1 {
    private ArrayList<Account> accounts = new ArrayList<>();

    public void addAccount(UserData user){
        String generatedPassword = PasswordGenerator.generate(
            user.getName(),
            user.getDob(),
            user.getPan(),
            user.getMasterKey()
        );
        accounts.add(new NormalAccount(
            "default-site",
            user.getName(),
            generatedPassword,
            user.getMasterKey()
        ));
        }

    public void showAccounts(){
        Scanner sc = new Scanner(System.in);
        for(Account account : accounts){
            account.showDetails();

            account.securityLevel();

            System.out.println("View pasword? (1=yes)/(2=No)");
            String choice = sc.nextLine();
            if(choice.equals("1")){
                System.out.println("Enter MasterKey: ");
                String Key = sc.nextLine();
                account.showPassword(Key);
            }
            else{
                System.out.println("Password:-********");
            }
            System.out.println("If you want to store your details 1=yes/ 2=no");
            String input = sc.nextLine();
            if(input.equals("1")){
                System.out.println("this password for which app/website:");
                String aap = sc.nextLine();
                accounts.add(new NormalAccount(aap,account.username,account.getPassword(),account.getMasterKey()));

            }
            System.out.println();

        }
        
        }
    }

