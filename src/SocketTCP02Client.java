import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

//客户端，发送Hello server给服务端
public class SocketTCP02Client {
    public static void main(String[] args)throws IOException {
        int port =9999;
        String messageWrite = "Hello server!";
        //2.连接上后，生成socket
        SendReceive sr = new SendReceive(2);
        sr.Send(messageWrite,port);
        sr.Send(messageWrite,port);
        String messageRead = sr.Receive(port);
        System.out.println(messageRead);
        System.out.println("客户端退出");
    }

}
