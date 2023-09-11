import java.io.*;
import java.net.*;

public class MyServer {
    private ServerSocket server; //服务器套接字
    private Socket socket;//客户机套接字

    void start() {
        try{
            server = new ServerSocket(8998);
            System.out.println("服务器套接字已创建成功");
            while(true){
                System.out.println("等待客户机的连接");
                socket = server.accept(); //服务器监听客户机的连接

                //根据套接字创建字符输入流
                BufferedReader reader = new BufferedReader(new InputStreamReader((socket.getInputStream())));
                while(true){
                    String message = reader.readLine(); //读取一行文本
                    if("exit".equals(message)){
                        System.out.println("客户机退出");
                        break;
                    }
                    System.out.println("客户机："+message);
                }
                reader.close();
                socket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyServer tcp = new MyServer();
        tcp.start(); //启动服务器
    }
}
