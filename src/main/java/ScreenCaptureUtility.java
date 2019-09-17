import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;


class ScreenCaptureUtility {
    private Rectangle screenRect;
    private Robot robot;
    private String base64ImageFormat;


    ScreenCaptureUtility(String base64ImageFormat) {
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            ProgUtil.handleException(e);
        }

        this.base64ImageFormat = base64ImageFormat;

        Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenDimensions.height;
        int width = screenDimensions.width;
        this.screenRect = new Rectangle(width, height);
    }

    /**
     * @return screenshot of screen (with mouse location)
     */
    private BufferedImage getScreenshot() {
        Point mousePosition = this.getMousePosition();

        BufferedImage screenshot = this.robot.createScreenCapture(this.screenRect);
        Graphics2D screenshotGraphics2d = screenshot.createGraphics();
        screenshotGraphics2d.setColor(Color.red);
        screenshotGraphics2d.fill(new Ellipse2D.Float(mousePosition.x - 5, mousePosition.y - 5, 10, 10));
        screenshotGraphics2d.dispose();

        return screenshot;
    }

    /**
     * @return gets Base64 representation of screenshot
     * @throws IOException thrown if image write fails
     */
    String getBase64EncodedScreenshot() throws IOException {
        BufferedImage screenshot = this.getScreenshot();
//        ProgUtil.displayImage(screenshot);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ImageIO.write(screenshot, this.base64ImageFormat, byteArrayOutputStream);
        return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
    }

    private Point getMousePosition() {
        return MouseInfo.getPointerInfo().getLocation();
    }
}
