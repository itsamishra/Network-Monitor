import fi.iki.elonen.NanoHTTPD;
import java.io.IOException;

/** Server class starts HTTP server in local machine */
public class Server extends NanoHTTPD {
  private SystemInformation systemInformation;

  public Server(SystemInformation systemInformation) {
    super(8080);

    this.systemInformation = systemInformation;
  }

  /**
   * Starts server
   *
   * @throws IOException
   */
  void runServer() throws IOException {
    ProgUtil.print("Starting server on port 8080 ...");

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
