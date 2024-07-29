import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegisterPage extends JPanel {
    private ArrayList<User> users;

    public RegisterPage(ArrayList<User> users) {
        this.users = users;
        setLayout(new BorderLayout());

        JLabel imageLabel = new JLabel();
        add(imageLabel, BorderLayout.CENTER);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                ImageIcon scaledImageIcon = ImageUtils.getScaledImageIcon("images/4.jpeg", getWidth(), getHeight());
                imageLabel.setIcon(scaledImageIcon);
            }
        });

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(6, 2));

        formPanel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Phone:"));
        JTextField phoneField = new JTextField();
        formPanel.add(phoneField);

        formPanel.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        formPanel.add(emailField);

        formPanel.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField();
        formPanel.add(passwordField);

        formPanel.add(new JLabel("Address:"));
        JTextField addressField = new JTextField();
        formPanel.add(addressField);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String phone = phoneField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String address = addressField.getText();

                User user = new User(name, phone, email, password, address);
                users.add(user);
                JOptionPane.showMessageDialog(RegisterPage.this, "User registered successfully!");
                Main.switchToPage("Home");
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> Main.switchToPage("Home"));

        formPanel.add(backButton);
        
        formPanel.add(registerButton);

        add(formPanel, BorderLayout.SOUTH);
    }
}
