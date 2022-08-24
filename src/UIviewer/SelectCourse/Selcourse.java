package UIviewer.SelectCourse;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Selcourse {

    private JPanel Sel_main;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Selcourse");
        frame.setSize(1273,784);
        //东南大学标志图片
        //文字
        JLabel l1=new JLabel("欢迎使用东南大学选课系统!");
        l1.setBounds(500,120,390,80);
        Font font = new Font("黑体", Font.BOLD, 27);
        l1.setFont(font);
        //l1.setForeground(new Color(111,222,0));
        frame.getContentPane().add(l1);

        //六个按钮
        // 按钮1
        JButton btnNewButton_1 = new JButton("查询课程信息");
        btnNewButton_1.setBounds(120, 380, 260, 90);
        Font myfont = new Font("微软雅黑 ",Font.BOLD,18);
        btnNewButton_1.setFont(myfont);
        btnNewButton_1.setBackground(new Color(	220 ,220, 220));
        frame.getContentPane().add(btnNewButton_1);

        // 按钮2
        JButton btnNewButton_2 = new JButton("查看已选课程");
        btnNewButton_2.setBounds(520, 380, 260, 90);
        btnNewButton_2.setFont(myfont);
        btnNewButton_2.setBackground(new Color(	250 ,255, 240));
        frame.getContentPane().add(btnNewButton_2);

        // 按钮3
        JButton btnNewButton_3 = new JButton("选课帮助");
        btnNewButton_3.setBounds(920, 380, 260, 90);
        btnNewButton_3.setFont(myfont);
        btnNewButton_3.setBackground(new Color(	250 ,240, 230));
        frame.getContentPane().add(btnNewButton_3);

        //按钮4
        JButton btnNewButton_4 = new JButton("选课界面");
        btnNewButton_4.setBounds(120, 600, 260, 90);
        btnNewButton_4.setFont(myfont);
        btnNewButton_4.setBackground(new Color(	220 ,220, 220));
        frame.getContentPane().add(btnNewButton_4);

        //按钮5
        JButton btnNewButton_5 = new JButton("我的课表");
        btnNewButton_5.setBounds(520, 600, 260, 90);
        btnNewButton_5.setFont(myfont);
        btnNewButton_5.setBackground(new Color(	250 ,255, 240));
        frame.getContentPane().add(btnNewButton_5);

        //按钮6
        JButton btnNewButton_6 = new JButton("退出");
        btnNewButton_6.setBounds(920, 600, 260, 90);
        btnNewButton_6.setFont(myfont);
        btnNewButton_6.setBackground(new Color(	250 ,240, 230));
        frame.getContentPane().add(btnNewButton_6);

        //东南大学标志图片
        JLabel l15 = new JLabel();
        ImageIcon icon6 = new ImageIcon("src/image/background3.jpg");
        l15.setIcon(icon6);
        l15.setBounds(700, 700, 1273, 784);
        frame.getContentPane().add(l15);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
