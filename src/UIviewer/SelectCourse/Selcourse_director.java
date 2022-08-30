package UIviewer.SelectCourse;

import UIhandler.Currirulum.Client_curriculum;
import UIviewer.Shop.main_shop;
import UIviewer.login.functionChoose;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Selcourse_director extends JFrame {
    private JPanel Sel_main;
    public static CardLayout cardLayout=new CardLayout();
    public static JPanel panel=new JPanel();
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Selcourse_director frame = new Selcourse_director();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public Selcourse_director()
    {
        setTitle("Selcourse_director");
        setBounds(0,0,1273,790);
        Sel_main=new JPanel();
        setContentPane(Sel_main);
        Sel_main.setLayout(null);
        panel.setBounds(0,100,1273,790);
        Sel_main.add(panel);
        panel.setLayout(cardLayout);

        Check_Course f1=new Check_Course();
        panel.add(f1,"f1");

        Stu_Info f2=new Stu_Info();
        panel.add(f2,"f2");

        CurrentCourse_Man f3=new CurrentCourse_Man();
        panel.add(f3,"f3");

        //东南大学标志图片
        //文字
        /*JLabel l1 = new JLabel("欢迎使用东南大学选课系统!");
        l1.setBounds(480, 50, 390, 280);
        Font font = new Font("黑体", Font.BOLD, 27);
        l1.setFont(font);
        //l1.setForeground(new Color(111,222,0));
        frame.getContentPane().add(l1);*/

        //六个按钮
        // 按钮1
        JButton btnNewButton_1 = new JButton("课程信息管理");
        btnNewButton_1.setBounds(40, 50, 200, 50);
        Font myfont = new Font("微软雅黑 ", Font.BOLD, 18);
        btnNewButton_1.setFont(myfont);
        btnNewButton_1.setBackground(new Color(250, 240, 230));
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel,"f3");
            }
        });
        add(btnNewButton_1);

        // 按钮2
        JButton btnNewButton_2 = new JButton("排课");
        btnNewButton_2.setBounds(340, 50, 200, 50);
        btnNewButton_2.setFont(myfont);
        btnNewButton_2.setBackground(new Color(245, 222, 179));
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout.show(panel,"f2");
            }
        });
        add(btnNewButton_2);

        /*// 按钮3
        JButton btnNewButton_3 = new JButton("选课帮助");
        btnNewButton_3.setBounds(1000, 380, 260, 90);
        btnNewButton_3.setFont(myfont);
        btnNewButton_3.setBackground(new Color(221, 160, 221));
        frame.getContentPane().add(btnNewButton_3);*/

        //按钮4
        JButton btnNewButton_4 = new JButton("审核课程");
        btnNewButton_4.setBounds(640, 50, 200, 50);
        btnNewButton_4.setFont(myfont);
        btnNewButton_4.setBackground(new Color(250, 240, 230));
        btnNewButton_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel,"f1");
            }
        });
        add(btnNewButton_4);

        //按钮5
        JButton btnNewButton_5 = new JButton("退出");
        btnNewButton_5.setBounds(940, 50, 200, 50);
        btnNewButton_5.setFont(myfont);
        btnNewButton_5.setBackground(new Color(245, 222, 179));

        btnNewButton_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                functionChoose.jf.setContentPane(functionChoose.fc_panel);
                functionChoose.jf.setTitle("functionChoose");
            }
        });
        add(btnNewButton_5);

       /* //按钮6
        JButton btnNewButton_6 = new JButton("退出");
        btnNewButton_6.setBounds(1000, 600, 260, 90);
        btnNewButton_6.setFont(myfont);
        btnNewButton_6.setBackground(new Color(221, 160, 221));
        frame.getContentPane().add(btnNewButton_6);*/

        //东南大学标志图片
        JLabel logo = new JLabel();
        ImageIcon icon1 = new ImageIcon("src/image/background2.jpg");
        logo.setIcon(icon1);
        logo.setBounds(0, 0, 1273, 790);
        Sel_main.add(logo);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
