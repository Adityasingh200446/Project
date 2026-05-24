package PasswordManager;
import java.util.*;
import PasswordManager.Account;        // add this
import PasswordManager.GmailAccount;   // add this

public class Main {
    public static void main(String[] args) {
        Account acc = new GmailAccount("hacker123@hacker.com", "Password");

        acc.securityLevel();
        acc.showDetails();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter masterKey to view password:");
        String inputKey = sc.nextLine();
        acc.showPassword(inputKey);
    }
}