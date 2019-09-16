import javax.swing.*;
import java.awt.image.BufferedImage;

public class NetworkMonitor {
    public static void main(String[] args) {
        ScreenCapture screenCapture = new ScreenCapture();
        BufferedImage screenshot = screenCapture.getScreenshot();
        System.out.println(screenshot);

        ProgUtil.print(2);
        ProgUtil.print("test");

        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        JButton button = new JButton("Press");
        frame.getContentPane().add(button); // Adds Button to content pane of frame
        frame.setVisible(true);
    }

}
