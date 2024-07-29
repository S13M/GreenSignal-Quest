import javax.swing.*;
import java.awt.*;

public class GamePage extends JPanel {
    public GamePage() {
        setLayout(new BorderLayout());

        JLabel imageLabel = new JLabel();
        add(imageLabel, BorderLayout.CENTER);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                ImageIcon scaledImageIcon = ImageUtils.getScaledImageIcon("images/game_image.png", getWidth(), getHeight());
                imageLabel.setIcon(scaledImageIcon);
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> Main.switchToPage("Home"));
        add(backButton, BorderLayout.NORTH);
    }
}
