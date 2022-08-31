package UIviewer.SelectCourse;
import UIhandler.Currirulum.Client_curriculum;

import UIviewer.login.functionChoose;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static UIhandler.Currirulum.Client_curriculum.RequireallCourse;


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

        Scheduling f2=new Scheduling();
        panel.add(f2,"f2");

        CurrentCourse_Man f3=new CurrentCourse_Man();
        panel.add(f3,"f3");


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
                try {
                    RequireallCourse();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        add(btnNewButton_2);


        //按钮4
        JButton btnNewButton_4 = new JButton("审核课程");
        btnNewButton_4.setBounds(640, 50, 200, 50);
        btnNewButton_4.setFont(myfont);
        btnNewButton_4.setBackground(new Color(250, 240, 230));
        btnNewButton_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel,"f1");
                try {
                    Client_curriculum.Require_all_application();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
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
