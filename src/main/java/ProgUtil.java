import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;

/** ProgUtil class contains utility methods */
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

  /**
   * Converts hash map to JSON string using Google's GSON library
   *
   * @param sysInfoHashMap hash map containing system information
   * @return stringify(JSON) of hash map containing system information
   */
  public static String hashMapToJsonString(Map<String, String> sysInfoHashMap) {
    GsonBuilder gsonMapBuilder = new GsonBuilder();
    Gson gsonObject = gsonMapBuilder.create();

    return gsonObject.toJson(sysInfoHashMap);
  }
}
