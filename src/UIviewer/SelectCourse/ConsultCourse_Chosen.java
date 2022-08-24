package UIviewer.SelectCourse;

import javax.swing.*;
import java.awt.*;

public class ConsultCourse_Chosen {
    public static void main(String[] args) {
        JFrame jf = new JFrame("ConsultCourse_Chosen");
        jf.setSize(1273, 784);

        //小头像
        JLabel touxiang = new JLabel();
        ImageIcon icon = new ImageIcon("src/image/logodz.png");
        touxiang.setIcon(icon);
        touxiang.setBounds(20, 20, 100, 100);
        jf.getContentPane().add(touxiang);

        //文字
        JLabel l1 = new JLabel("  你好！");
        l1.setBounds(120, 40, 200, 75);
        Font font = new Font("楷体", Font.BOLD, 22);
        l1.setFont(font);
        //l1.setForeground(new Color(111,222,0));
        jf.getContentPane().add(l1);

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
        l4.setBounds(23, 155, 250, 60);
        Font font2 = new Font("楷体", Font.BOLD, 25);
        l4.setFont(font2);
        l4.setForeground(new Color(30, 144, 255));
        jf.getContentPane().add(l4);

        JLabel l8 = new JLabel("      基本信息");
        l8.setBounds(23, 185, 250, 60);
        Font font3 = new Font("楷体", Font.BOLD, 25);
        l8.setFont(font3);
        l8.setForeground(new Color(94, 38, 18));
        jf.getContentPane().add(l4);

        String name = "1";
        JLabel l2 = new JLabel(" 姓名：" + name);
        l2.setBounds(30, 310, 250, 60);
        Font font1 = new Font("微软雅黑", Font.PLAIN, 18);
        l2.setFont(font1);
        l2.setForeground(new Color(0, 0, 0));
        jf.getContentPane().add(l2);
        String card = "";
        JLabel l3 = new JLabel(" 卡号：" + card);
        l3.setBounds(30, 380, 250, 60);
        l3.setFont(font1);
        l3.setForeground(new Color(0, 0, 0));
        jf.getContentPane().add(l3);

        //label背景
        JLabel l11 = new JLabel();
        ImageIcon icon4 = new ImageIcon("src/image/PPT背景图5.jpg");
        l11.setIcon(icon4);
        l11.setBounds(15, 120, 285, 620);
        jf.getContentPane().add(l11);
        //东南大学标志图片
        JLabel logo = new JLabel();
        ImageIcon icon1 = new ImageIcon("src/image/logo-mini.png");
        logo.setIcon(icon1);
        logo.setBounds(315, 5, 210, 65);
        jf.getContentPane().add(logo);
        //右上角图标
        JLabel pic1 = new JLabel();
        ImageIcon icon2 = new ImageIcon("src/image/student.png");
        pic1.setIcon(icon2);
        pic1.setBounds(1100, 15, 25, 25);
        jf.getContentPane().add(pic1);

        JButton btnNewButton_6 = new JButton("安全返回");
        btnNewButton_6.setBounds(1040, 125, 100, 30);
        Font myfont2 = new Font("微软雅黑", Font.PLAIN, 12);
        btnNewButton_6.setFont(myfont2);
        btnNewButton_6.setBackground(new Color(248, 248, 255));
        //btnNewButton_1.setForeground(new Color(248, 248, 255));
        btnNewButton_6.setContentAreaFilled(true);//设置按钮透明
        //btnNewButton_6.setBorder(null);//取消边框

        jf.getContentPane().add(btnNewButton_6);

        //横向图片
        JLabel l12 = new JLabel();
        ImageIcon icon5 = new ImageIcon("src/image/banner3.png");
        l12.setIcon(icon5);
        l12.setBounds(310, 70, 1000, 125);
        jf.getContentPane().add(l12);

        //文字
        /*JLabel l13 = new JLabel("     功能选择 ");
        l13.setBounds(320, 200, 200, 75);
        Font font13 = new Font("微软雅黑", Font.BOLD, 25);
        l13.setFont(font13);
        //l13.setForeground(new Color(111,222,0));
        jf.getContentPane().add(l13);*/

        //左侧面板
        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 310, 784);
        p1.setBackground(new Color(135, 206, 250, 180));
        jf.getContentPane().add(p1);


        //文本编辑框（输入课程编号或课程名字）
        JLabel lblNewLabel = new JLabel("已选课程:");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 35));
        lblNewLabel.setBounds(400, 125, 275, 35);
        jf.add(lblNewLabel);

        /*JTextField textField = new JTextField();
        textField.setFont(new Font("宋体", Font.BOLD, 12));
        textField.setBounds(550, 125, 275, 35);
        jf.add(textField);
        textField.setColumns(10);*/
        //五个按钮
        //右下面板
       /* JLabel l31 = new JLabel();
        ImageIcon icon31 = new ImageIcon("src/image/icon_72 (1).png");
        l31.setIcon(icon31);
        l31.setBounds(449, 290, 300, 72);
        jf.getContentPane().add(l31);
        JButton btnNewButton_1 = new JButton("学籍管理");
        btnNewButton_1.setBounds(335, 362, 300, 128);
        Font myfont1 = new Font("微软雅黑", Font.BOLD, 26);
        btnNewButton_1.setFont(myfont1);
        btnNewButton_1.setBackground(new Color(220, 220, 220));
        //btnNewButton_1.setForeground(new Color(248, 248, 255));
        //btnNewButton_1.setBorder(null);//取消边框
        jf.getContentPane().add(btnNewButton_1);
        JPanel p21 = new JPanel();
        p21.setBounds(335, 290, 300, 200);
        p21.setBackground(new Color(248, 248, 255));
        jf.getContentPane().add(p21);

        JLabel l32 = new JLabel();
        ImageIcon icon32 = new ImageIcon("src/image/icon_72 (3).png");
        l32.setIcon(icon32);
        l32.setBounds(754, 290, 300, 72);
        jf.getContentPane().add(l32);
        JButton btnNewButton_2 = new JButton("选课系统");
        btnNewButton_2.setBounds(640, 362, 300, 128);
        btnNewButton_2.setFont(myfont);
        btnNewButton_2.setBackground(new Color(220, 220, 220));
        //btnNewButton_2.setBorder(null);//取消边框
        //btnNewButton_1.setForeground(new Color(248, 248, 255));
        jf.getContentPane().add(btnNewButton_2);
        JPanel p22 = new JPanel();
        p22.setBounds(640, 290, 300, 200);
        p22.setBackground(new Color(248, 248, 255));
        jf.getContentPane().add(p22);


        JLabel l33 = new JLabel();
        ImageIcon icon33 = new ImageIcon("src/image/icon_72 (5).png");
        l33.setIcon(icon33);
        l33.setBounds(1059, 290, 300, 72);
        jf.getContentPane().add(l33);
        JButton btnNewButton_3 = new JButton("商店系统");
        btnNewButton_3.setBounds(945, 362, 300, 128);
        btnNewButton_3.setFont(myfont);
        btnNewButton_3.setBackground(new Color(220, 220, 220));
        //btnNewButton_3.setBorder(null);//取消边框
        //btnNewButton_1.setForeground(new Color(248, 248, 255));
        jf.getContentPane().add(btnNewButton_3);
        JPanel p23 = new JPanel();
        p23.setBounds(945, 290, 300, 200);
        p23.setBackground(new Color(248, 248, 255));
        jf.getContentPane().add(p23);

        JLabel l34 = new JLabel();
        ImageIcon icon34 = new ImageIcon("src/image/icon_72 (4).png");
        l34.setIcon(icon34);
        l34.setBounds(449, 500, 300, 72);
        jf.getContentPane().add(l34);
        JButton btnNewButton_4 = new JButton("图书馆系统");
        btnNewButton_4.setBounds(335, 572, 300, 128);
        btnNewButton_4.setFont(myfont);
        btnNewButton_4.setBackground(new Color(220, 220, 220));
        //btnNewButton_4.setBorder(null);//取消边框
        //btnNewButton_1.setForeground(new Color(248, 248, 255));
        jf.getContentPane().add(btnNewButton_4);
        JPanel p24 = new JPanel();
        p24.setBounds(335, 500, 300, 200);
        p24.setBackground(new Color(248, 248, 255));
        jf.getContentPane().add(p24);

        JLabel l35 = new JLabel();
        ImageIcon icon35 = new ImageIcon("src/image/icon_72 (6).png");
        l35.setIcon(icon35);
        l35.setBounds(754, 500, 300, 72);
        jf.getContentPane().add(l35);
        JButton btnNewButton_5 = new JButton("站内通信");
        btnNewButton_5.setBounds(640, 572, 300, 128);
        btnNewButton_5.setFont(myfont);
        btnNewButton_5.setBackground(new Color(220, 220, 220));
        //btnNewButton_5.setBorder(null);//取消边框
        //btnNewButton_1.setForeground(new Color(248, 248, 255));
        jf.getContentPane().add(btnNewButton_5);
        JPanel p25 = new JPanel();
        p25.setBounds(640, 500, 300, 200);
        p25.setBackground(new Color(248, 248, 255));
        jf.getContentPane().add(p25);
*/
        //右下面板
        JPanel p3 = new JPanel();
        p3.setBounds(330, 200, 920, 585);
        p3.setBackground(new Color(211, 211, 211, 100));
        jf.getContentPane().add(p3);


        //右侧面板
        JPanel p2 = new JPanel();
        p2.setBounds(300, 0, 950, 1000);
        p2.setBackground(new Color(245, 245, 245, 180));
        jf.getContentPane().add(p2);

        JLabel l15 = new JLabel();
        ImageIcon icon6 = new ImageIcon("src/image/background4.jpg");
        l15.setIcon(icon6);
        l15.setBounds(410, 20, 1273, 784);
        jf.getContentPane().add(l15);

        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

}
