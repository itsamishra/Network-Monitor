import fi.iki.elonen.NanoHTTPD;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

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
      //            String itemIdRequestParameter = session.getParms().get("itemId");
      //            return newFixedLengthResponse("Requested itemId = " + itemIdRequestParameter);
      return newFixedLengthResponse(systemInformation.getBase64EncodedScreenshot());

    } else {
      return newFixedLengthResponse(
          Response.Status.NOT_FOUND, MIME_PLAINTEXT, "The requested resource does not exist");
    }
  }
}
