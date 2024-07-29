import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    private static JFrame frame;
    private static ArrayList<User> users = new ArrayList<>();
    private static User loggedInUser;

    public static void main(String[] args) {
        frame = new JFrame("Main Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new CardLayout());

        JPanel homePage = createHomePage();
        JPanel registerPage = new RegisterPage(users);
        JPanel loginPage = new LoginPage(users);
        JPanel aboutPage = new AboutPage();
        JPanel helpPage = new HelpPage();
        JPanel gamePage = new GamePage();

        frame.add(homePage, "Home");
        frame.add(registerPage, "Register");
        frame.add(loginPage, "Login");
        frame.add(aboutPage, "About");
        frame.add(helpPage, "Help");
        frame.add(gamePage, "Game");

        frame.setVisible(true);
        switchToPage("Home");
    }

    private static JPanel createHomePage() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel imageLabel = new JLabel();
        panel.add(imageLabel, BorderLayout.CENTER);

        panel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                ImageIcon scaledImageIcon = ImageUtils.getScaledImageIcon("images/home_image.png", panel.getWidth(), panel.getHeight());
                imageLabel.setIcon(scaledImageIcon);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 6));

        JButton registerButton = new JButton("Register");
        JButton loginButton = new JButton("Login");
        JButton aboutButton = new JButton("About");
        JButton helpButton = new JButton("Help");
        JButton startGameButton = new JButton("Start Game");
        JButton exitButton = new JButton("Exit");

        registerButton.addActionListener(e -> switchToPage("Register"));
        loginButton.addActionListener(e -> switchToPage("Login"));
        aboutButton.addActionListener(e -> switchToPage("About"));
        helpButton.addActionListener(e -> switchToPage("Help"));
        startGameButton.addActionListener(e -> {
            if (loggedInUser != null) {
                switchToPage("Game");
            } else {
                JOptionPane.showMessageDialog(frame, "Please login or register first.");
            }
        });
        exitButton.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(frame, "Do you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        buttonPanel.add(registerButton);
        buttonPanel.add(loginButton);
        buttonPanel.add(aboutButton);
        buttonPanel.add(helpButton);
        buttonPanel.add(startGameButton);
        buttonPanel.add(exitButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        return panel;
    }

    public static void switchToPage(String pageName) {
        CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
        cl.show(frame.getContentPane(), pageName);
    }

    public static void setLoggedInUser(User user) {
        loggedInUser = user;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static JFrame getFrame() {
        return frame;
    }
}

