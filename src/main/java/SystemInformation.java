/** SystemInformation class holds data regarding current system */
public class SystemInformation {
  private String base64EncodedScreenshot;

  /** @param base64EncodedScreenshot the new value of base64EncodedScreenshot */
  public void setBase64EncodedScreenshot(String base64EncodedScreenshot) {
    this.base64EncodedScreenshot = base64EncodedScreenshot;
  }

  public String getBase64EncodedScreenshot() {
    return base64EncodedScreenshot;
  }

  @Override
  public String toString() {
    String stringRepresentation = "base64EncodedScreenshot: " + base64EncodedScreenshot;
    return stringRepresentation;
  }

  /** @return JSON representation of SystemInformation object */
  public String toJson() {
    // TODO: Use Google GSON to convert Map into JSON
    return String.format("{\"base64EncodedScreenshot\":\"%s\"}", base64EncodedScreenshot);
  }
}
