package PasswordManager;

import javax.swing.*;
import java.awt.*;

public class MyGUI {
    static UserData user;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {  // ← IMPORTANT: run GUI on correct thread

            JFrame frame = new JFrame("Password Generator");
            frame.setSize(500, 450);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout()); // ← add this

            // --- Fields ---
            JTextField nameField   = new JTextField(20);
            JTextField dobField    = new JTextField(20);
            JTextField panField    = new JTextField(20);
            JTextField masterField = new JTextField(20);
            JTextField resultField = new JTextField(20);
            resultField.setEditable(false);
            resultField.setBackground(Color.LIGHT_GRAY);

            JButton submitBtn = new JButton("Generate Password");
            JButton showPassBtn = new JButton("Show Password");

            // --- Panel ---
            JPanel panel = new JPanel(new GridLayout(7, 2, 10, 15));
            panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

            panel.add(new JLabel("Name:"));
            panel.add(nameField);

            panel.add(new JLabel("DOB (dd-mm-yyyy):"));
            panel.add(dobField);

            panel.add(new JLabel("PAN:"));
            panel.add(panField);

            panel.add(new JLabel("Master Key:"));
            panel.add(masterField);

            panel.add(new JLabel("Generated Password:"));
            panel.add(resultField);

            panel.add(new JLabel(""));
            panel.add(submitBtn);

            panel.add(new JLabel(""));
            panel.add(showPassBtn);

            // --- Button Logic ---
            submitBtn.addActionListener((e) -> {
                String name      = nameField.getText().trim();
                String dob       = dobField.getText().trim();
                String pan       = panField.getText().trim();
                String masterKey = masterField.getText().trim();

                if (name.isBlank() || dob.isBlank() || 
                    pan.isBlank()  || masterKey.isBlank()) {
                    JOptionPane.showMessageDialog(frame,
                        "All fields are required!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }

                user = new UserData(name, dob, pan, masterKey);

                String password = PasswordGenerator.generate(
                    user.getName(),
                    user.getDob(),
                    user.getPan(),
                    user.getMasterKey()
                );
                resultField.setText("********");
                resultField.putClientProperty("actualPassword", password);
            });

             showPassBtn.addActionListener((e) -> {

                if(user == null){
                    JOptionPane.showMessageDialog(frame,"Enter Password First","ERROR",
                    JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String inputKey = JOptionPane.showInputDialog("enter MasterKey");

                if(inputKey==null){
                    return;
                }

                if(inputKey.equals(user.getMasterKey())){
                    String result = (String) resultField.getClientProperty("actualPassword");
                    resultField.setText(result);
                }
                else{
                    JOptionPane.showMessageDialog(frame,"Incorrect MasterKey!","Error",JOptionPane.ERROR_MESSAGE);
                    resultField.setText("*******");
                }



             });


            // --- Add panel to frame ---
            frame.add(panel, BorderLayout.CENTER); 
            frame.revalidate(); 
            frame.repaint();    
            frame.setVisible(true); 
        });
    }
}