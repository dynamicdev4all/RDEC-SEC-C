import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Player {
    static int x;
    static int y;
    static int w;
    static int h;
    static int speed;
    static String fileName;
    static BufferedImage playerImage;
    static BufferedImage playerImages[] = new BufferedImage[4];
    static BufferedImage playerDanceImages[] = new BufferedImage[8];

    // ImageIcon playerImage;

    Player(int x, int y, int w, int h, int speed, String fileName) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.speed = speed;
        this.fileName = "player.png";
        loadBgImage();
    }

    static void loadBgImage() {

        // playerImage = new ImageIcon(AppPanel.class.getResource(fileName));
        try {
            playerImage = ImageIO.read(AppPanel.class.getResource("player.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static BufferedImage[] getRightMove() {
        loadBgImage();
        playerImages[0] = playerImage.getSubimage(0, 120, 60, 60);
        playerImages[1] = playerImage.getSubimage(60, 120, 60, 60);
        playerImages[2] = playerImage.getSubimage(120, 120, 60, 60);
        playerImages[3] = playerImage.getSubimage(180, 120, 60, 60);
        return playerImages;
    }

    static BufferedImage[] getDanceMove() {
        loadBgImage();
        playerDanceImages[0] = playerImage.getSubimage(0, 0, 60, 60);
        playerDanceImages[1] = playerImage.getSubimage(60, 0, 60, 60);
        playerDanceImages[2] = playerImage.getSubimage(120, 0, 60, 60);
        playerDanceImages[3] = playerImage.getSubimage(180, 0, 60, 60);
        playerDanceImages[4] = playerImage.getSubimage(240, 0, 60, 60);
        playerDanceImages[5] = playerImage.getSubimage(300, 0, 60, 60);
        playerDanceImages[6] = playerImage.getSubimage(360, 0, 60, 60);
        playerDanceImages[7] = playerImage.getSubimage(420, 0, 60, 60);
        return playerDanceImages;
    }

    static void paintBgImage(Graphics g, BufferedImage image,int y,int x) {
        System.out.println("paint called");
        g.drawImage(image, x, y, 100, 100, null);
    }

    void movePlayerUP() {
        if (y < -h) {
            y = 500 + h;
        }
        y = y - speed;
    }
    static void movePlayerRight() {
        if (x < -60) {
            x = 500 + 60;
        }
        x = x + 5;
    }
}
