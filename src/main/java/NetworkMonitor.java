import java.io.IOException;

public class NetworkMonitor {
    public static void main(String[] args) throws IOException {
        // Creates SystemInformation object
        SystemInformation sysInfo = new SystemInformation();

        // Gets base64 representation of screenshot (w/ cursor)
        ScreenCapture screenCapture = new ScreenCapture("png");
        sysInfo.setBase64EncodedScreenshot(screenCapture.getBase64EncodedScreenshot());

        // Gets list of "major" processes
        // TODO

        // Gets IP of current machine
        // TODO
//        socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
//        ip = socket.getLocalAddress().getHostAddress();
    }
}