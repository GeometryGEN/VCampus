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
        JFrame jFrame = new JFrame();
        jFrame.setTitle("向服务器发数据");
        jFrame.setSize(200,200);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = jFrame.getContentPane(); //主容器
        JScrollPane scrollPane = new JScrollPane(area); //滚动面板
        jFrame.getContentPane().add(scrollPane,BorderLayout.CENTER);
        c.add(text,"South"); //将文本框放在窗体下部
        text.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writer.println(text.getText().trim()); //将文本框信息写入流
                area.append(text.getText()+'\n'); //将文本框信息显示在文本域中
                text.setText(""); //将文本框清空
            }
        });

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

    public static void main(String[] args){
        MyClient clien = new MyClient();
        clien.connect();
    }
}
