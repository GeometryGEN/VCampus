package UIviewer.SelectCourse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Check_Course extends JPanel{

    public Check_Course()
    {
        setLayout(null);
        JPanel p11=new JPanel();
        p11.setBounds(0,0,1273,784);


        //文字
        JLabel l1 = new JLabel("  你好！");
        l1.setBounds(170, 100, 100, 75);
        Font font = new Font("楷体", Font.BOLD, 22);
        l1.setFont(font);
        //l1.setForeground(new Color(111,222,0));
        add(l1);


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



        //左侧面板
        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 310, 784);
        p1.setBackground(new Color(135, 206, 250, 180));
        add(p1);


        //文本编辑框（输入课程编号或课程名字）
        JLabel lblNewLabel = new JLabel("课程审核");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 35));
        lblNewLabel.setBounds(400, 75, 275, 35);
        add(lblNewLabel);

        JLabel lblNewLabel2 = new JLabel("课程编号:");
        lblNewLabel2.setFont(new Font("宋体", Font.BOLD, 25));
        lblNewLabel2.setBounds(370, 225, 275, 35);
        add(lblNewLabel2);

        JTextField textField1 = new JTextField();
        textField1.setFont(new Font("宋体", Font.BOLD, 18));
        textField1.setBounds(520, 225, 375, 35);
        add(textField1);
        textField1.setColumns(10);

        JButton btnNewButton_10 = new JButton("审核通过");
        btnNewButton_10.setBounds(420, 425, 150, 40);
        Font myfont9 = new Font("微软雅黑", Font.PLAIN, 18);
        btnNewButton_10.setFont(myfont9);
        btnNewButton_10.setBackground(new Color(248, 248, 255));
        btnNewButton_10.setContentAreaFilled(true);//设置按钮透明
        add(btnNewButton_10);

        JButton btnNewButton_11 = new JButton("退回申请");
        btnNewButton_11.setBounds(780, 425, 150, 40);
        Font myfont12 = new Font("微软雅黑", Font.PLAIN, 18);
        btnNewButton_11.setFont(myfont12);
        btnNewButton_11.setBackground(new Color(248, 248, 255));
        btnNewButton_11.setContentAreaFilled(true);//设置按钮透明
        add(btnNewButton_11);



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
