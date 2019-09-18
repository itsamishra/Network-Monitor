import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

/** SystemInformation class holds data regarding current system */
public class SystemInformation {
  private Map<String, String> sysInfoHashMap = new HashMap<>();

  SystemInformation() {
    sysInfoHashMap.put("cpuUsagePercentage", "");
    sysInfoHashMap.put("base64EncodedScreenshot", "");
    sysInfoHashMap.put("systemRamGb", "");
    sysInfoHashMap.put("systemDiskSizeGb", "");
  }

  /** @param base64EncodedScreenshot the new value of base64EncodedScreenshot */
  void setBase64EncodedScreenshot(String base64EncodedScreenshot) {
    sysInfoHashMap.put("base64EncodedScreenshot", base64EncodedScreenshot);
  }

  void setCpuUsagePercentage(String cpuUsagePercentage){
    sysInfoHashMap.put("cpuUsagePercentage", cpuUsagePercentage);
  }

  void setSystemRamGb(String systemRamGb){
    sysInfoHashMap.put("systemRamGb", systemRamGb);
  }

  void setSystemDiskSizeGb(String systemDiskSizeGb){
    sysInfoHashMap.put("systemDiskSizeGb", systemDiskSizeGb);
  }

  @Override
  public String toString() {
    //    String stringRepresentation = "base64EncodedScreenshot: " + base64EncodedScreenshot;
    return this.toJson();
  }

  /** @return JSON representation of SystemInformation object */
  String toJson() {
    return ProgUtil.hashMapToJsonString(this.sysInfoHashMap);
  }
}
