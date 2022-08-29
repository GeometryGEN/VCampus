package UIviewer.QQ;

import ClientToServer.ClientToServer;
import UIhandler.QICQ.Client_qicq;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class main_panel extends JPanel {
    JPanel jp=this;

    public main_panel(ClientToServer ucs, int width, int height){
        double width_r=(double)(width)/1920;
        double height_r=(double)(height)/1080;
        //设置屏幕大小、背景颜色
        setBounds(0,0,width,height);
        setBackground(new Color(255,255,255));
        //设置绝对布局
        setLayout(null);
        //聊天面板
        chat_panel chatPanel=new chat_panel(1920/3*2,1080,width_r,height_r,1920/3,0);
        add(chatPanel);
        //好友面板
//        try {
//            Client_qicq.Require_friend_list();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        friend_list friend_list_panel=new friend_list(1920/3,1080,width_r,height_r,0,0);
        add(friend_list_panel);


    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("SEU QQ");
        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int width=(int ) screensize.getWidth(); //得到宽度
        int height=(int ) screensize.getHeight();//获得高度
        frame.setBounds(0,0,width,height);
        //frame.setContentPane(new main_panel(ucs,width,height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
