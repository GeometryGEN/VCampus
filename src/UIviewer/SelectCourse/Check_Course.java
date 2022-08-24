package UIviewer.SelectCourse;

import javax.swing.*;
import java.awt.*;

public class Check_Course {

    public static void main(String[] args) {
        JFrame jf = new JFrame("Check_Course");
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


        //信息面板
        JLabel l4 = new JLabel("      基本信息");
        l4.setBounds(23, 185, 250, 60);
        Font font2 = new Font("楷体", Font.BOLD, 25);
        l4.setFont(font2);
        l4.setForeground(new Color(94, 38, 18));
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


        JButton btnNewButton_6 = new JButton("安全返回");
        btnNewButton_6.setBounds(1030, 125, 100, 30);
        Font myfont2 = new Font("微软雅黑", Font.PLAIN, 12);
        btnNewButton_6.setFont(myfont2);
        btnNewButton_6.setBackground(new Color(248, 248, 255));
        //btnNewButton_1.setForeground(new Color(248, 248, 255));
        btnNewButton_6.setContentAreaFilled(true);//设置按钮透明
        //btnNewButton_6.setBorder(null);//取消边框

        jf.getContentPane().add(btnNewButton_6);


        //左侧面板
        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 310, 784);
        p1.setBackground(new Color(135, 206, 250, 180));
        jf.getContentPane().add(p1);


        //文本编辑框（输入课程编号或课程名字）
        JLabel lblNewLabel = new JLabel("课程审核:");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 35));
        lblNewLabel.setBounds(400, 125, 275, 35);
        jf.add(lblNewLabel);


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

        //横向图片
        JLabel l16 = new JLabel();
        ImageIcon icon7 = new ImageIcon("src/image/background4.jpg");
        l16.setIcon(icon7);
        l16.setBounds(410, 20, 1273, 784);
        jf.getContentPane().add(l16);

        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

}
