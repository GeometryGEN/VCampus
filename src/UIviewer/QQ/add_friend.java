package UIviewer.QQ;

import ClientToServer.ClientToServer;
import UIhandler.QICQ.Client_qicq;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import ClientToServer.myInfo;
import UIviewer.Shopping.shopCustomer;
import net.coobird.thumbnailator.Thumbnails;

/**
 * 添加朋友
 *
 * @author Zhangyang_Ge
 * @date 2022/09/03
 */
public class add_friend {
    static JFrame jf;
    static Color color1=new Color(30,111,255);
    static Color color2=new Color(45,52,82);
    static Color color3=new Color(190,213,235);
    static Font myfont1=new Font("微软雅黑", Font.BOLD, 17);
    /**
     * 添加朋友
     */
    public static void add_friend() {
        jf = new JFrame("添加好友");
        jf.setLayout(null);
        jf.setBackground(color3);


        JLabel l1 = new JLabel("一卡通:");
        l1.setFont(myfont1);
        //l1.setFont(new Font("宋体", Font.BOLD, 15));
        l1.setBounds(40, 120, 120, 25);
        l1.setForeground(color2);
        jf.add(l1);
        JTextField idCard=new JTextField();
        idCard.setFont(new Font("宋体", Font.BOLD, 15));
        idCard.setBounds(115, 120, 125, 25);
        jf.add(idCard);
        idCard.setColumns(10);

        JLabel l2 = new JLabel("分组:");
        l2.setFont(myfont1);
        //l2.setFont(new Font("宋体", Font.BOLD, 15));
        l2.setBounds(40, 160, 120, 25);
        l2.setForeground(color2);
        jf.add(l2);
        JTextField group=new JTextField();
        group.setFont(new Font("宋体", Font.BOLD, 15));
        group.setBounds(115, 160, 125, 25);
        jf.add(group);
        group.setColumns(10);

        JLabel l3 = new JLabel("备注:");
        //l3.setFont(new Font("宋体", Font.BOLD, 15));
        l3.setFont(myfont1);
        l3.setBounds(40, 200, 120, 25);
        l3.setForeground(color2);
        jf.add(l3);
        JTextField nickname=new JTextField();
        nickname.setFont(new Font("宋体", Font.BOLD, 15));
        nickname.setBounds(115, 200, 125, 25);
        jf.add(nickname);
        nickname.setColumns(10);

        JButton b1=new JButton("申请添加");
        b1.setFocusPainted(false);
        b1.setBounds(85,260,120,30);
        b1.setForeground(Color.white);
        b1.setFont(myfont1);
        b1.setBackground(new Color(30,111,255));
        b1.setFocusPainted(false);
        jf.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Client_qicq.add_friend(myInfo.getId(),group.getText(),idCard.getText(),nickname.getText());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        JPanel p11=new JPanel();
        p11.setBounds(0,0, 300,100);
        JLabel pic1 = new JLabel();
        //裁减2到min的尺寸
        try {
            Thumbnails.of(new File("src/image/QQ/3.jpg"))
                    .size(300,100)
                    .keepAspectRatio(false)
                    .toFile(new File("src/image/QQ/3_fit.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pic1.setIcon(new ImageIcon("src/image/QQ/3_fit.jpg"));
        pic1.setBounds(0,0 , 300,100);
        p11.add(pic1);

        jf.add(pic1);
        jf.getContentPane().setBackground(color3);
        jf.setBounds(0,0,300,360);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);
    }

    /**
     * 添加好友成功
     */
    public static void add_friend_succeed() {
        JOptionPane.showMessageDialog( jf,"添加好友成功！");
        jf.dispose();
    }

    /**
     * 添加好友失败
     */
    public static void add_friend_fail() {
        JOptionPane.showMessageDialog(null, "未查找到该用户", "WARNING!", JOptionPane.PLAIN_MESSAGE);
    }
}
