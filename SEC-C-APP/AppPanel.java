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
    int playerIndex = 0;
    int playerRunX = 50;
    int playerDanceIndex = 0;
    int carCount = 1;
    Car carsArr[] = new Car[carCount];
    // int playerCount = 1;
    BufferedImage playerArr[] = Player.getRightMove();
    BufferedImage playerDanceArr[] = Player.getDanceMove();

    // Car car1;
    // Car car2;
    // Car car3;
    // Car car4;

    AppPanel() {
        setSize(500, 500);
        System.out.println(playerArr.length);
        // setBackground(Color.BLUE);
        // loadBgImage();
        // initCars();
        // initPlayers();
        // carsArr[0] = new Car(30, 20, 150, 150, 1, "enemyCar.png");
        // car2 = new Car(160, 20, 150, 150, 3, "enemyCar.png");
        // car3 = new Car(290, 20, 150, 150, 20, "enemyCar.png");
        // car4 = new Car(160, 290, 80, 150, 20, "playerCar.png");
        appLoop();
        addKeyBoardControl();
        setFocusable(true);
    }

    void initCars() {
        int gap = 20;
        for (int i = 0; i < carCount; i++) {
            carsArr[i] = new Car(gap, 20, 150, 150, 1, "random.gif");
            gap = gap + 150 + 20;
        }

        // for (Car car : carsArr) {
        // car = new Car(gap, 20, 150, 150, 1, "random.gif");
        // gap = gap + 150 + 20;
        // }
    }

    // void initPlayers() {
    // int gap = 20;
    // for (int i = 0; i < playerCount; i++) {
    // playerArr[i] = new Player(gap, 20, 150, 150, 1, "player.png");
    // gap = gap + 150 + 20;
    // }
    // }

    void appLoop() {
        timer = new Timer(100, (abc) -> {
            // if (xPos > 500) {
            // xPos = 0;
            // }
            // xPos++;
            // yPos++;
            // car1.moveCarUP();
            // car2.moveCarUP();
            // car3.moveCarUP();
            // moveCars();
            movePlayer();
            playerIndex++;
            playerDanceIndex++;
            if (playerIndex > 3) {
                playerIndex = 0;
            }
            if (playerDanceIndex > 7) {
                playerDanceIndex = 0;
            }
            repaint();
        });
        timer.start();
    }

    void moveCars() {
        for (int i = 0; i < carCount; i++) {
            carsArr[i].moveCarUP();
        }
    }

    void movePlayer() {
        if (playerRunX > 500) {
            playerRunX = -60;
        }
        playerRunX += 15;
    }

    void paintCars(Graphics pen) {
        for (int i = 0; i < carCount; i++) {
            carsArr[i].paintBgImage(pen);
            ;
        }
    }

    void paintPlayer(Graphics pen) {
        // for (int i = 0; i < playerArr.length; i++) {
        Player.paintBgImage(pen, playerArr[playerIndex], 150, playerRunX);
        Player.paintBgImage(pen, playerDanceArr[playerDanceIndex], 0, 190);
        // }
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        // car1.paintBgImage(g);
        // car2.paintBgImage(g);
        // car3.paintBgImage(g);
        // car4.paintBgImage(g);
        // paintCars(g);
        paintPlayer(g);
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
