import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Car {
    int x;
    int y;
    int w;
    int h;
    int speed;
    String fileName;
    // BufferedImage carImage;

    ImageIcon carImage;

    Car(int x, int y, int w, int h, int speed, String fileName) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.speed = speed;
        this.fileName = fileName;
        loadBgImage();
    }

    void loadBgImage() {

        carImage = new ImageIcon(AppPanel.class.getResource(fileName));
        // try {
        //     carImage = ImageIO.read(AppPanel.class.getResource(fileName));
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }

    void paintBgImage(Graphics g) {
        g.drawImage(carImage.getImage(), x, y, w, h, null);
    }

    void moveCarUP() {
        if (y < -h) {
            y = 500 + h;
        }
        y = y - speed;
    }
}
