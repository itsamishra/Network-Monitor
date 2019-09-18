import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;

import com.sun.management.OperatingSystemMXBean;

/** NetworkMonitor class gets data & starts http server */
public class NetworkMonitor {
  public static void main(String[] args) throws IOException {
    // Object that holds system's information
    SystemInformation sysInfo = new SystemInformation();

    // Used to get system's memory information
    OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

    // Gets cpu usage percentage
    String cpuUsagePercentage = new DecimalFormat("#.##").format(osBean.getSystemCpuLoad() * 100);
    sysInfo.setCpuUsagePercentage(cpuUsagePercentage);

    // Gets amount of RAM in current device
    String systemRamGb =
        new DecimalFormat("#.##").format(osBean.getTotalPhysicalMemorySize() / 1e+9);
    sysInfo.setSystemRamGb(systemRamGb);

    // Gets list of "major" processes
    // TODO

    // Gets IP of current machine
    // TODO

    // Gets base64 representation of screenshot (w/ cursor)
    ScreenCaptureUtility screenCapture = new ScreenCaptureUtility("png");
    sysInfo.setBase64EncodedScreenshot(screenCapture.getBase64EncodedScreenshot());

    ProgUtil.print(sysInfo);

    // Start http server
    Server server = new Server(sysInfo);
    server.runServer();
  }
}
