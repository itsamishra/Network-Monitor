import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.DecimalFormat;
import com.sun.management.OperatingSystemMXBean;

/** NetworkMonitor class gets data & starts http server */
public class NetworkMonitor {
  public static void main(String[] args) throws IOException {
    // Object that holds system's information
    SystemInformation sysInfo = new SystemInformation();

    // Used to get system's memory information
    OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

    // Gets IP of current machine
    // FROM: https://stackoverflow.com/a/38342964
    DatagramSocket socket = new DatagramSocket();
    socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
    String ipAddress = socket.getLocalAddress().getHostAddress();
    sysInfo.setIpAddress(ipAddress);

    // Gets cpu usage percentage
    String cpuUsagePercentage = new DecimalFormat("#.##").format(osBean.getSystemCpuLoad() * 100);
    sysInfo.setCpuUsagePercentage(cpuUsagePercentage);

    // Gets amount of RAM in current device
    String systemRamGb =
        new DecimalFormat("#.##").format(osBean.getTotalPhysicalMemorySize() / 1e+9);
    sysInfo.setSystemRamGb(systemRamGb);

    // Gets size of disk (GB) in current device
    String systemDiskSizeGb = new DecimalFormat("#.##").format(new File("/").getFreeSpace() / 1e+9);
    sysInfo.setSystemDiskSizeGb(systemDiskSizeGb);

    // Gets base64 representation of screenshot (w/ cursor)
    ScreenCaptureUtility screenCapture = new ScreenCaptureUtility("png");
    sysInfo.setBase64EncodedScreenshot(screenCapture.getBase64EncodedScreenshot());

    // Start telemetry server
    TelemetryServer telemetryServer = new TelemetryServer(8080, sysInfo);
    telemetryServer.runServer();
  }
}
