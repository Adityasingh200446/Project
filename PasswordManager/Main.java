package PasswordManager;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); 

        System.out.println("Name: ");
        String name = sc.nextLine();

        System.out.println("DOB(dd-mm-yyyy): ");
        String dob = sc.nextLine();

        System.out.println("PAN: ");
        String pan = sc.nextLine();

        System.out.println("MasterKey: ");
        String key = sc.nextLine();

        UserData user = new UserData(name,dob,pan,key);

        PasswordManager1 pm = new PasswordManager1();
        pm.addAccount(user);

        pm.showAccounts();
        
    }
}