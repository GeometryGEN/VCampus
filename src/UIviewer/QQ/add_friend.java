package UIviewer.QQ;

import ClientToServer.ClientToServer;
import UIhandler.QICQ.Client_qicq;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import ClientToServer.myInfo;

public class add_friend {
    static JFrame jf;
    public static void add_friend() {
        jf = new JFrame("添加好友");
        jf.setLayout(null);
        jf.setBackground(Color.white);


        JLabel l3 = new JLabel("一卡通:");
        l3.setFont(new Font("宋体", Font.BOLD, 15));
        l3.setBounds(20, 20, 250, 25);
        jf.add(l3);
        JTextField idCard=new JTextField();
        idCard.setFont(new Font("宋体", Font.BOLD, 12));
        idCard.setBounds(95, 20, 125, 25);
        jf.add(idCard);
        idCard.setColumns(10);

        JLabel l4 = new JLabel("备注:");
        l4.setFont(new Font("宋体", Font.BOLD, 15));
        l4.setBounds(20, 60, 250, 25);
        jf.add(l4);
        JTextField nickname=new JTextField();
        nickname.setFont(new Font("宋体", Font.BOLD, 12));
        nickname.setBounds(95, 60, 125, 25);
        jf.add(nickname);
        nickname.setColumns(10);

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
                    Client_qicq.add_friend(myInfo.getId(),myInfo.getName(),idCard.getText(),nickname.getText());
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

    public static void add_friend_succeed() {
        jf.dispose();
    }

    public static void add_friend_fail() {
        JOptionPane.showMessageDialog(null, "未查找到该用户", "WARNING!", JOptionPane.PLAIN_MESSAGE);
    }
}
