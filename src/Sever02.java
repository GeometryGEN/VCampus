

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Sever02 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器9999接口正在监听...");
        System.out.println(InetAddress.getLocalHost());

        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();

        byte[] buf = new byte[1024];
        int readLen=0;
        while ((readLen=inputStream.read(buf))!=-1){
            System.out.println(new String(buf,0,readLen));
        }
        socket.shutdownInput();


        OutputStream outputStream = socket.getOutputStream();


        outputStream.write("Hello,Client!".getBytes(StandardCharsets.UTF_8));
        socket.shutdownOutput();

        inputStream.close();
        outputStream.close();
        socket.close();

        serverSocket.close();

    }
}
