import fi.iki.elonen.NanoHTTPD;
import java.io.IOException;

/** Server class starts HTTP server in local machine */
public class TelemetryServer extends NanoHTTPD {
  private SystemInformation systemInformation;

  public TelemetryServer(Integer port, SystemInformation systemInformation) {
    super(port);

    this.systemInformation = systemInformation;
  }

  /**
   * Starts server
   *
   * @throws IOException
   */
  void runServer() throws IOException {
    start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
  }

  @Override
  public Response serve(IHTTPSession session) {
    if (session.getMethod() == Method.GET) {
      return newFixedLengthResponse(
          NanoHTTPD.Response.Status.OK, "application/json", systemInformation.toJson());

    } else {
      return newFixedLengthResponse(
          Response.Status.NOT_FOUND, MIME_PLAINTEXT, "The requested resource does not exist");
    }
  }
}
