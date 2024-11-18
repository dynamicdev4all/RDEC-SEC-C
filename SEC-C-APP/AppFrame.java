import javax.swing.JFrame;

public class AppFrame extends JFrame {
    AppFrame() {
        setTitle("SEC C APP");
        setSize(500, 500);
        AppPanel appPanel = new AppPanel();
        add(appPanel);
        setVisible(true);
    }
}
