package PasswordManager;

import javax.swing.*;
import java.awt.*;

public class MyGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            PasswordGenerator[] pg = {null};

            JFrame frame = new JFrame("Password Generator");
            frame.setSize(500, 450);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout());

            // --- Fields ---
            JTextField nameField   = new JTextField(20);
            JTextField dobField    = new JTextField(20);
            JTextField panField    = new JTextField(20);
            JTextField masterField = new JTextField(20);
            JTextField resultField = new JTextField(20);
            resultField.setEditable(false);
            resultField.setBackground(Color.LIGHT_GRAY);

            JButton generateBtn = new JButton("Generate Password");
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
            panel.add(generateBtn);

            panel.add(new JLabel(""));
            panel.add(showPassBtn);

            // --- Generate Button ---
            generateBtn.addActionListener((e) -> {
                String name      = nameField.getText().trim();
                String dob       = dobField.getText().trim();
                String pan       = panField.getText().trim();
                String masterKey = masterField.getText().trim();

                if (name.isBlank() || dob.isBlank() ||
                    pan.isBlank()  || masterKey.isBlank()) {
                    JOptionPane.showMessageDialog(frame,
                        "All fields are required!", "Error",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }

                pg[0] = new PasswordGenerator(name, dob, pan, masterKey);
                resultField.setText("********");

                // Show strength popup
                String strength = pg[0].checkStrength();
                if (strength.equals("Strong Password!")) {
                    JOptionPane.showMessageDialog(frame,
                        "Strong Password!", "Password Strength",
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame,
                        "Weak Password!", "Password Strength",
                        JOptionPane.WARNING_MESSAGE);
                }
            });

            // --- Show Password Button ---
            showPassBtn.addActionListener((e) -> {
                if (pg[0] == null) {
                    JOptionPane.showMessageDialog(frame,
                        "Generate a password first!", "Error",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String inputKey = JOptionPane.showInputDialog(frame, "Enter Master Key:");
                if (inputKey == null) return;

                if (inputKey.equals(pg[0].getMasterKey())) {
                    resultField.setText(pg[0].getGeneratedPassword());
                } else {
                    JOptionPane.showMessageDialog(frame,
                        "Incorrect Master Key!", "Error",
                        JOptionPane.ERROR_MESSAGE);
                    resultField.setText("********");
                }
            });

            frame.add(panel, BorderLayout.CENTER);
            frame.revalidate();
            frame.repaint();
            frame.setVisible(true);
        });
    }
}