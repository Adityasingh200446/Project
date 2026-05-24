package PasswordGenerator;
import javax.swing.*;
import java.awt.*;

public class MyGUI {
    static UserData user;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Smart Password Generator");
        frame.setSize(400,320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField nameField = new JTextField(20);
        JTextField dobField = new JTextField(20);
        JTextField panField = new JTextField(20);
        JTextField favField = new JTextField(20);
        resultField.setEditable(false);

        JButton submit = new JButton("submit");
        JButton GeneratePassword = new JButton("GeneratePassword");

        JLabel passwordLabel = new JLabel("Password: ");


        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("DOB(dd-mm-yyyy):"));
        panel.add(dobField);
        panel.add(new JLabel("PAN:"));
        panel.add(panField);
        panel.add(new JLabel("Favourite Name (Master Key):"));
        panel.add(masterField);

        frame.add(submit);
        frame.add(GeneratePassword);
        frame.add(passwordLabel);

        submit.addActionListener(e ->{
            String name = nameField.getText();
            String dob = dobField.getText();
            String pan = panField.getText();
            String masterKey = favField.getText();

            user = new UserData(name, dob, pan, masterKey);

        }
        );
        GeneratePassword.addActionListener(e ->{
            if(user==null){
                System.out.println("Enter details First");
                return;
            }
            String password = PasswordGenerator.generate(user.name,user.dob,user.pan,user.masterKey);
            passwordLabel.setText("Password"+password);

        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);



    }
}
