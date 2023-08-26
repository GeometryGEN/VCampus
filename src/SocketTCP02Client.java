import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

//客户端，发送Hello server给服务端
public class SocketTCP02Client {
    public static void main(String[] args)throws IOException {

        //1.连接服务端（ip、端口），如果连接成功返回socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(),9999); //连接本机9999端口
        System.out.println("客户端 socket返回="+socket.getClass());
        //2.连接上后，生成socket
        //得到和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //3.通过输出流，写入数据到数据通道
        String messageWrite = "Hello server!";
        String messageRead = "/";
        outputStream.write(messageWrite.getBytes(StandardCharsets.UTF_8));
        //设置结束标记
        socket.shutdownOutput();

        //4.获取和socket相关联的输入流，读取数据并显示
        InputStream inputStream = socket.getInputStream();
        int readLen =0;
        byte[] buf = new byte[1024];
        while((readLen = inputStream.read(buf))!=-1){
            messageRead = new String(buf,0,readLen);
            System.out.println(messageRead);
        }
        //5.关闭流对象和socket
        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端退出");
    }

}
