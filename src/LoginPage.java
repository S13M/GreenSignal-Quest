import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginPage extends JPanel {
    private ArrayList<User> users;

    public LoginPage(ArrayList<User> users) {
        this.users = users;
        setLayout(new BorderLayout());

        JLabel imageLabel = new JLabel();
        add(imageLabel, BorderLayout.CENTER);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                ImageIcon scaledImageIcon = ImageUtils.getScaledImageIcon("images/3.jpg", getWidth(), getHeight());
                imageLabel.setIcon(scaledImageIcon);
            }
        });

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2));

        formPanel.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        formPanel.add(emailField);

        formPanel.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField();
        formPanel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                User user = findUserByEmail(email);
                if (user != null && user.getPassword().equals(password)) {
                    Main.setLoggedInUser(user);
                    JOptionPane.showMessageDialog(LoginPage.this, "Login successful! Welcome " + user.getName());
                    Main.switchToPage("Home");
                } else {
                    JOptionPane.showMessageDialog(LoginPage.this, "Invalid email or password!");
                }
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> Main.switchToPage("Home"));

        formPanel.add(backButton);

        //add(formPanel, BorderLayout.SOUTH);

        formPanel.add(loginButton);

        add(formPanel, BorderLayout.SOUTH);
    }

    private User findUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
}
