import java.io.IOException;

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

    ProgUtil.print(sysInfo);

    // Start http server
    Server server = new Server(sysInfo);
    server.runServer();
  }
}
