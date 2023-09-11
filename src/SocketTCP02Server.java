import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketTCP02Server {
    public static void main(String args[]) throws IOException {
        int port=9999;

        SendReceive sr = new SendReceive(1);
        String messageRead = sr.Receive(port);
        System.out.println(messageRead);
//        messageRead = sr.Receive(port);
//        System.out.println(messageRead);

        String messageWrite = "Hello client!";
        sr.Send(messageWrite,port);

        System.out.println("服务器退出");
    }
}
