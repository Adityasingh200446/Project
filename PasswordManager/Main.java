package PasswordManager;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("DOB (dd-mm-yyyy): ");
        String dob = sc.nextLine();

        System.out.print("PAN: ");
        String pan = sc.nextLine();

        System.out.print("Master Key: ");
        String key = sc.nextLine();

        PasswordGenerator pg = new PasswordGenerator(name, dob, pan, key);

        pg.showDetails();

        System.out.print("View password? (1=Yes / 2=No): ");
        String choice = sc.nextLine();
        if (choice.equals("1")) {
            System.out.print("Enter Master Key: ");
            String inputKey = sc.nextLine();
            pg.showPassword(inputKey);
        } else {
            System.out.println("Password: ********");
        }

        System.out.print("Save for a specific app/website? (1=Yes / 2=No): ");
        String save = sc.nextLine();
        if (save.equals("1")) {
            System.out.print("Which app/website: ");
            String app = sc.nextLine();
            System.out.println("Saved! Use this password for: " + app);
            System.out.println("Password: " + pg.getGeneratedPassword());
        }

        sc.close();
    }
}