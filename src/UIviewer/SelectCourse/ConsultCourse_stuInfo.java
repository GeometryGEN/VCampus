package UIviewer.SelectCourse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultCourse_stuInfo extends JPanel {


    public ConsultCourse_stuInfo()
    {
        setLayout(null);
        JPanel p11=new JPanel();
        p11.setBounds(0,0,1273,784);

        /*//小头像
        JLabel touxiang = new JLabel();
        ImageIcon icon = new ImageIcon("src/image/logodz.png");
        touxiang.setIcon(icon);
        touxiang.setBounds(20, 20, 100, 100);
        jf.getContentPane().add(touxiang);*/

        //文字
        JLabel l1 = new JLabel("  你好！");
        l1.setBounds(170, 100, 100, 75);
        Font font = new Font("楷体", Font.BOLD, 22);
        l1.setFont(font);
        //l1.setForeground(new Color(111,222,0));
        add(l1);

/*
        //左侧面板
        JPanel p3 = new JPanel();
        p3.setBounds(20, 150, 260, 300);
        p3.setBackground(new Color(225,255,255, 180));
        // p3.setBorder(new MyLineBorder(new Color(225,255,255),180,true));
        jf.getContentPane().add(p3);

 */


        //信息面板
        JLabel l4 = new JLabel("      基本信息");
        l4.setBounds(23, 205, 250, 60);
        Font font2 = new Font("楷体", Font.BOLD, 25);
        l4.setFont(font2);
        l4.setForeground(new Color(94, 38, 18));
        add(l4);

        String name = "1";
        JLabel l2 = new JLabel(" 姓名：" + name);
        l2.setBounds(30, 300, 250, 60);
        Font font1 = new Font("微软雅黑", Font.PLAIN, 18);
        l2.setFont(font1);
        l2.setForeground(new Color(0, 0, 0));
        add(l2);
        String card = "";
        JLabel l3 = new JLabel(" 卡号：" + card);
        l3.setBounds(30, 410, 250, 60);
        l3.setFont(font1);
        l3.setForeground(new Color(0, 0, 0));
        add(l3);


        JButton btnNewButton_6 = new JButton("安全返回");
        btnNewButton_6.setBounds(680, 525, 200, 40);
        Font myfont2 = new Font("微软雅黑", Font.PLAIN, 18);
        btnNewButton_6.setFont(myfont2);
        btnNewButton_6.setBackground(new Color(248, 248, 255));
        //btnNewButton_1.setForeground(new Color(248, 248, 255));
        btnNewButton_6.setContentAreaFilled(true);//设置按钮透明
        //btnNewButton_6.setBorder(null);//取消边框

        add(btnNewButton_6);


        //左侧面板
        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 310, 784);
        p1.setBackground(new Color(135, 206, 250, 180));
        add(p1);


        //文本编辑框（输入课程编号或课程名字）
        JLabel lblNewLabel = new JLabel("查看学生选课情况:");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 35));
        lblNewLabel.setBounds(400, 55, 335, 35);
        add(lblNewLabel);


        //右下面板
        JPanel p3 = new JPanel();
        p3.setBounds(310, 0, 950, 685);
        p3.setBackground(new Color(211, 211, 211, 100));
        add(p3);


        //右侧面板
        JPanel p2 = new JPanel();
        p2.setBounds(310, 0, 950, 1000);
        p2.setBackground(new Color(245, 245, 245, 180));
        add(p2);



        //横向图片
        JLabel l16 = new JLabel();
        ImageIcon icon7 = new ImageIcon("src/image/background3.jpg");
        l16.setIcon(icon7);
        l16.setBounds(0, 0, 1273, 790);
        add(l16);

        add(p11);


    }

}
