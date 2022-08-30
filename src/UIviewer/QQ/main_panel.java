package UIviewer.QQ;

import ClientToServer.ClientToServer;
import UIhandler.QICQ.Client_qicq;
import UIhandler.StatusManagement.Client_status;
import UIviewer.login.functionChoose;
import UIviewer.status_manage.RoundJButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class main_panel extends JPanel {
    JPanel jp=this;
    public static JButton close_button;
    public main_panel(ClientToServer ucs, int width, int height){
        double width_r=(double)(width)/1920;
        double height_r=(double)(height)/1080;
        //设置屏幕大小、背景颜色
        setBounds(0,0,width,height);
        setBackground(new Color(255,255,255));
        //设置绝对布局
        setLayout(null);
        //返回功能选择模块
        functionChoose.back_from_student_status=new RoundJButton();
        functionChoose.back_from_student_status.setText("返回功能选择");
        functionChoose.back_from_student_status.setBounds((int)(width_r*1920/3-170),(int)((1080-100)*height_r),(int)(170*width_r),(int)(50*height_r));
        functionChoose.back_from_student_status.setBackground(new Color(30,111,255));
        functionChoose.back_from_student_status.setForeground(new Color(255,255,255));
        functionChoose.back_from_student_status.setFont(new Font("微软雅黑",Font.PLAIN,(int)(22*width_r)));
        add(functionChoose.back_from_student_status);
        updateUI();
        functionChoose.back_from_student_status.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client_status.resetS();
                functionChoose.jf.setContentPane(functionChoose.fc_panel);
            }
        });
        //聊天面板
        chat_panel chatPanel=new chat_panel(1920/3*2,1080,width_r,height_r,1920/3,0);
        add(chatPanel);
        //好友列表
        friend_list friend_list_panel=new friend_list(1920/3,1080,width_r,height_r,0,0);
        add(friend_list_panel);
        friend_list_panel.setVisible(true);
        functionChoose.back_from_student_status.setVisible(false);
        functionChoose.back_from_student_status.setVisible(true);
        updateUI();


    }
}
