import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AppPanel extends JPanel {
    BufferedImage bgImage;
    Timer timer;
    int xPos = 0;
    int yPos = 0;

    Car car1;
    Car car2;
    Car car3;
    Car car4;

    AppPanel() {
        setSize(500, 500);
        // setBackground(Color.BLUE);
        // loadBgImage();
        car1 = new Car(30, 20, 150, 150, 1, "enemyCar.png");
        car2 = new Car(160, 20, 150, 150, 3, "enemyCar.png");
        car3 = new Car(290, 20, 150, 150, 20, "enemyCar.png");
        car4 = new Car(160, 290, 80, 150, 20, "playerCar.png");
        appLoop();
        addKeyBoardControl();
        setFocusable(true);
    }

    void appLoop() {
        timer = new Timer(30, (abc) -> {
            // if (xPos > 500) {
            // xPos = 0;
            // }
            // xPos++;
            // yPos++;
            // car1.moveCarUP();
            // car2.moveCarUP();
            // car3.moveCarUP();
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        car1.paintBgImage(g);
        car2.paintBgImage(g);
        car3.paintBgImage(g);
        car4.paintBgImage(g);
    }

    void addKeyBoardControl() {
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    xPos += 5;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    xPos -= 5;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    yPos -= 5;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    yPos += 5;
                }

                throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
            }

        });
    }
}
