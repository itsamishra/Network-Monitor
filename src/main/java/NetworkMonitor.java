import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/** NetworkMonitor class gets data & starts http server */
public class NetworkMonitor {
  public static void main(String[] args) throws IOException {
    // Creates SystemInformation object
    SystemInformation sysInfo = new SystemInformation();

    // Gets base64 representation of screenshot (w/ cursor)
    ScreenCaptureUtility screenCapture = new ScreenCaptureUtility("png");
    sysInfo.setBase64EncodedScreenshot(screenCapture.getBase64EncodedScreenshot());

    // Gets list of "major" processes
    // TODO

    // Get CPU usage (%)
    // TODO

    // Gets IP of current machine
    // TODO

//    ProgUtil.print(sysInfo);
    ProgUtil.print(sysInfo.toJson());

    // Start http server
    Server server = new Server(sysInfo);
    server.runServer();
  }
}
