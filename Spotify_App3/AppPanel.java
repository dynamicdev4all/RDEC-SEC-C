import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AppPanel extends JPanel {
    BufferedImage dancerImage;
    ImageIcon dancerImage2;
    Timer timer;
    JButton playPauseButton;
    JButton nextButton;
    JButton previousButton;

    AppPanel() {
        setSize(600, 600);
        playPauseButton = new JButton("Play/Pause");
        nextButton = new JButton("NEXT");
        previousButton = new JButton("PREVIOUS");
        // setBackground(Color.GREEN);
        // loadImage();
        add(playPauseButton);
        add(nextButton);
        add(previousButton);

        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics brush) {
        // TODO Auto-generated method stub
        super.paintComponent(brush);
    }

    void appLoop() {
        timer = new Timer(50, (a) -> {
            repaint();
        });
        timer.start();
    }
}
