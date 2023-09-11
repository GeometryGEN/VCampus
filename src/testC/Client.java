package testC;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    public static void main(String[] args) throws IOException {
        //1.连接服务端（ip，端口）
        //解读：连接本机的9999端口，如果连接成功，返回socket对象
        System.out.println(InetAddress.getLocalHost());
        Socket socket = new Socket("10.203.192.130", 9999);
        System.out.println("客户端socket返回="+socket.getClass());

        //2.连接后，生成socket，通过socket.getOutputStream
        //得到和socket关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();

        //3.通过输入流，写数据到数据通道
        outputStream.write("hello sever".getBytes(StandardCharsets.UTF_8));

        //4.关闭流对象和socket
        outputStream.close();
        socket.close();
        System.out.println("客户端退出...");
    }
}
