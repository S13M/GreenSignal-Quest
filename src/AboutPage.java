import javax.swing.*;
import java.awt.*;

public class AboutPage extends JPanel {
    public AboutPage() {
        setLayout(new BorderLayout());

        JLabel imageLabel = new JLabel();
        add(imageLabel, BorderLayout.CENTER);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                ImageIcon scaledImageIcon = ImageUtils.getScaledImageIcon("images/about_image.png", getWidth(), getHeight());
                imageLabel.setIcon(scaledImageIcon);
            }
        });

        JTextArea aboutText = new JTextArea("This is an about page with details about the game...");
        aboutText.setWrapStyleWord(true);
        aboutText.setLineWrap(true);
        aboutText.setOpaque(false);
        aboutText.setEditable(false);
        aboutText.setFocusable(false);
        add(aboutText, BorderLayout.NORTH);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> Main.switchToPage("Home"));
        add(backButton, BorderLayout.SOUTH);
    }
}
