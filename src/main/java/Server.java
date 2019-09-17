import fi.iki.elonen.NanoHTTPD;

import java.io.IOException;

public class Server extends NanoHTTPD {
    public Server() {
        super(8080);
//        start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
    }

    @Override
    public Response serve(IHTTPSession session) {
        return newFixedLengthResponse("Hello world");
    }

    void runServer() throws IOException {
        ProgUtil.print("Starting server on port 8080...");
        ProgUtil.print("Press");
        start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
    }
}
