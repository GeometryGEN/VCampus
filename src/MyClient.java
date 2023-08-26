import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import javax.swing.*;

public class MyClient {
    private PrintWriter writer;
    Socket socket;
    public JTextArea area = new JTextArea();//展示信息的文本域
    public JTextField text = new JTextField();//发送信息的文本域

    public MyClient(){

    }

    private void connect(){
        area.append("尝试连接\n");
        try{
            socket = new Socket("127.0.0.1",8998);
            writer = new PrintWriter(socket.getOutputStream(),true);
            area.append("完成连接\n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
