import javax.swing.*;
import java.awt.*;

public class HelpPage extends JPanel {
    public HelpPage() {
        setLayout(new BorderLayout());

        JLabel imageLabel = new JLabel();
        add(imageLabel, BorderLayout.CENTER);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                ImageIcon scaledImageIcon = ImageUtils.getScaledImageIcon("images/help_image.png", getWidth(), getHeight());
                imageLabel.setIcon(scaledImageIcon);
            }
        });

        JTextArea helpText = new JTextArea("Write your message here...");
        add(helpText, BorderLayout.SOUTH);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> Main.switchToPage("Home"));
        add(backButton, BorderLayout.NORTH);
    }
}
