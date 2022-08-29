package UIviewer.QQ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class chat_panel extends JPanel {
    private JPanel type_panel;
    private JPanel record_panel;
    public chat_panel(int width,int height,double width_r,double height_r,int x,int y){
        setLayout(null);
        setBounds((int)(x*width_r),(int)(y*height_r),(int)(width*width_r),(int)(height*height_r));
        setBackground(new Color(224,224,224));
        setBorder(BorderFactory.createLineBorder(new Color(234,234,234)));

        //发消息界面
        type_panel=new JPanel();
        type_panel.setLayout(null);
        type_panel.setBounds(0,(int)(3*height/4*height_r),(int)(width*width_r),(int)(height/4*height_r));
        type_panel.setBorder(BorderFactory.createLineBorder(new Color(234,234,234)));
        type_panel.setBackground(new Color(224,224,224));
        add(type_panel);
        //发送消息按钮
        JButton send_button= new JButton();
        int send_button_height=70;
        int send_button_width=140;
        send_button.setBackground(new Color(30,111,255));
        send_button.setFont(new Font("宋体",Font.PLAIN,(int)(25*width_r)));
        send_button.setText("发送");
        send_button.setForeground(new Color(255,255,255));
        send_button.setBounds((int)((width-send_button_width-1)*width_r),(int)((height/4-send_button_height-30)*height_r),(int)(send_button_width*width_r),(int)(send_button_height*height_r));
        type_panel.add(send_button);
        //关闭该聊天框按钮
        JButton close_button= new JButton();
        int close_button_height=70;
        int close_button_width=140;
        close_button.setBackground(new Color(211,10,11));
        close_button.setFont(new Font("宋体",Font.PLAIN,(int)(25*width_r)));
        close_button.setText("关闭");
        close_button.setForeground(new Color(255,255,255));
        close_button.setBounds((int)((width-2*send_button_width-1.5)*width_r),(int)((height/4-send_button_height-30)*height_r),(int)(send_button_width*width_r),(int)(send_button_height*height_r));
        type_panel.add(close_button);
        close_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        //输入消息框
        JTextArea type_field=new JTextArea();
        type_field.setBounds(0,0,(int)(width*width_r),(int)((height/4-1)*height_r));
        type_field.setBorder(BorderFactory.createLineBorder(new Color(224,224,224)));
        type_field.setBackground(new Color(245,246,247));
        type_field.setFont(new Font("宋体",Font.PLAIN,(int)(25*width_r)));
        type_panel.add(type_field);
        //发送信息
        send_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //发送信息函数
            }
        });

        //显示消息界面
        record_panel=new JPanel();
        record_panel.setLayout(null);
        record_panel.setBounds(0,0,(int)(width*width_r),(int)(height/4*3*height_r));
        record_panel.setBorder(BorderFactory.createLineBorder(new Color(234,234,234)));
        record_panel.setBackground(new Color(245,246,247));
        add(record_panel);
    }
}
