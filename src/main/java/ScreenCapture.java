import java.awt.*;
import java.awt.image.BufferedImage;


class ScreenCapture {
    private Rectangle screenRect;
    private Robot robot;


    ScreenCapture() {
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            ProgUtil.handleException(e);
        }

        Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenDimensions.height;
        int width = screenDimensions.width;
        this.screenRect = new Rectangle(width, height);
    }

    /**
     * @return screenshot of screen
     */
    BufferedImage getScreenshot() {
        return this.robot.createScreenCapture(this.screenRect);
    }
}
