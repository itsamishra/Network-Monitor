import java.io.IOException;

public class NetworkMonitor {
    public static void main(String[] args) throws IOException {
        ScreenCapture screenCapture = new ScreenCapture("png");
        ProgUtil.print(screenCapture.getBase64EncodedScreenshot());
        ProgUtil.print(screenCapture.getMousePosition());

    }
}