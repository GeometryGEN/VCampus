package UIviewer.QQ;

import ClientToServer.ClientToServer;
import UIhandler.QICQ.Client_qicq;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import ClientToServer.myInfo;

public class add_friend extends JPanel {
//    public add_friend(){
//        setLayout(null);
//        setSize(600,120);
//        setLocation(0,0);
//        JTextField id_field=new JTextField();
//        JTextField nick_field=new JTextField();
//        JLabel id_jLabel=new JLabel("一卡通号：");
//        JLabel nick_jLabel=new JLabel("备注：");
//        Font font=new Font("宋体",Font.PLAIN,22);
//        id_jLabel.setFont(font);
//        nick_jLabel.setFont(font);
//        id_jLabel.setBounds(20,10,100,50);
//        nick_jLabel.setBounds(20,60,100,50);
//        add(id_jLabel);
//        add(nick_jLabel);
//    }

    public static void add_friend() {
        JFrame jf = new JFrame("添加好友");
        jf.setLayout(null);
        jf.setBackground(Color.white);


        JLabel l3 = new JLabel("一卡通:");
        l3.setFont(new Font("宋体", Font.BOLD, 15));
        l3.setBounds(20, 20, 250, 25);
        jf.add(l3);
        JTextField textField3=new JTextField();
        textField3.setFont(new Font("宋体", Font.BOLD, 12));
        textField3.setBounds(95, 20, 125, 25);
        jf.add(textField3);
        textField3.setColumns(10);

        JLabel l4 = new JLabel("备注:");
        l4.setFont(new Font("宋体", Font.BOLD, 15));
        l4.setBounds(20, 60, 250, 25);
        jf.add(l4);
        JTextField mail=new JTextField();
        mail.setFont(new Font("宋体", Font.BOLD, 12));
        mail.setBounds(95, 60, 125, 25);
        jf.add(mail);
        mail.setColumns(10);

        JButton b1=new JButton("申请添加");
        b1.setBounds(270,38,100,30);
        b1.setForeground(Color.white);
        b1.setBackground(new Color(30,111,255));
        b1.setFocusPainted(false);
        jf.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Client_qicq.add_friend(myInfo.getId(),myInfo.getName(),l3.getText(),l4.getText());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        jf.getContentPane().setBackground(Color.white);
        jf.setBounds(0,0,400,150);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);
    }
}
