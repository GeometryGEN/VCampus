import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SendReceive {
    SendReceive(int k){ //服务器为1，客户端为2
        this.kind = k;
    }
    public void Send(String message,int port) throws IOException {
        if(kind == 1){ //服务器
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("服务端：在"+port+"端口监听，等待连接...");
            Socket socket = serverSocket.accept();
            OutputStream outputStream = socket.getOutputStream();
            //3.通过输出流，写入数据到数据通道
            outputStream.write(message.getBytes(StandardCharsets.UTF_8));
            //设置结束标记
            socket.shutdownOutput();
            outputStream.close();
            socket.close();
            serverSocket.close();
        }
        else { //客户端
            Socket socket = new Socket(InetAddress.getLocalHost(), port); //连接本机9999端口
            OutputStream outputStream = socket.getOutputStream();
            //3.通过输出流，写入数据到数据通道
            outputStream.write(message.getBytes(StandardCharsets.UTF_8));
            //设置结束标记
            socket.shutdownOutput();
            outputStream.close();
            socket.close();
        }
    }
    public String Receive(int port) throws IOException {
        String messageRead = "/";
        if(kind == 1){ //服务器
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务端：在"+port+"端口监听，等待连接...");
            Socket socket = serverSocket.accept();
            //3.通过socket.getInputStream()读取客户端写入到数据通道的数据，显示
            InputStream inputStream = socket.getInputStream();

            //4.IO读取
            byte[] buf = new byte[1024];
            int readLen =0;
            while((readLen = inputStream.read(buf))!=-1){
                messageRead = new String(buf,0,readLen);
            }
            inputStream.close();
            socket.close();
            serverSocket.close();
        }
        else { //客户端
            Socket socket = new Socket(InetAddress.getLocalHost(), port); //连接本机
            //3.通过socket.getInputStream()读取客户端写入到数据通道的数据，显示
            InputStream inputStream = socket.getInputStream();
            //4.IO读取
            byte[] buf = new byte[1024];
            int readLen =0;
            while((readLen = inputStream.read(buf))!=-1){
                messageRead = new String(buf,0,readLen);
            }
            inputStream.close();
            socket.close();
        }

        return messageRead;
    }

    public int kind;
}
