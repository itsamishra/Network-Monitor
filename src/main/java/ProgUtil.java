import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

class ProgUtil {
  static void handleException(Exception e) {
    ProgUtil.print("Error:");
    ProgUtil.print(e.toString());
    ProgUtil.print("Stack Trace:");
    ProgUtil.print(e.fillInStackTrace().toString());
  }

  static <T> void print(T printThis) {
    System.out.println(printThis);
  }

  static void displayImage(BufferedImage img) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new FlowLayout());
    frame.getContentPane().add(new JLabel(new ImageIcon(img)));
    frame.pack();
    frame.setVisible(true);
  }
}
