package UIviewer.SelectCourse;

import UIhandler.Currirulum.Client_curriculum;
import UIviewer.login.functionChoose;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.channels.spi.AbstractInterruptibleChannel;

public class Selcourse_teacher extends JFrame {
    private JPanel Sel_main;

    public static CardLayout cardLayout=new CardLayout();
    public static JPanel panel=new JPanel();
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Selcourse_teacher frame = new Selcourse_teacher();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
    public Selcourse_teacher()
    {
        setTitle("Selcourse_teacher");
        setBounds(0,0,1273,790);
        Sel_main=new JPanel();
        setContentPane(Sel_main);
        Sel_main.setLayout(null);

        panel.setBounds(0,100,1273,790);
        Sel_main.add(panel);
        panel.setLayout(cardLayout);
        ConsultCourse_Info f1=new ConsultCourse_Info();
        panel.add(f1,"f1");

        ConsultCourse_stuInfo f2=new ConsultCourse_stuInfo();
        panel.add(f2,"f2");

        Check_Coustatus f3=new Check_Coustatus();
        panel.add(f3,"f3");

        Declare_Course f4=new Declare_Course();
        panel.add(f4,"f4");

        My_Coursetable f5=new My_Coursetable();
        panel.add(f5,"f5");

        //六个按钮
        // 按钮1
        JButton btnNewButton_1 = new JButton("查询课程信息");
        btnNewButton_1.setBounds(40, 50, 160, 50);
        Font myfont = new Font("微软雅黑 ", Font.BOLD, 18);
        btnNewButton_1.setFont(myfont);
        btnNewButton_1.setBackground(new Color(220, 220, 220));
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel,"f1");
            }
        });
       Sel_main.add(btnNewButton_1);

        // 按钮2
        JButton btnNewButton_2 = new JButton("查询选课情况");
        btnNewButton_2.setBounds(220, 50, 160, 50);
        btnNewButton_2.setFont(myfont);
        btnNewButton_2.setBackground(new Color(250, 255, 240));
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel,"f2");
            }
        });
        Sel_main.add(btnNewButton_2);

        // 按钮3
        JButton btnNewButton_3 = new JButton("申报课程状态");
        btnNewButton_3.setBounds(400, 50, 160, 50);
        btnNewButton_3.setFont(myfont);
        btnNewButton_3.setBackground(new Color(250, 240, 230));
        btnNewButton_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Client_curriculum.Require_my_apply();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        Sel_main.add(btnNewButton_3);

        //按钮4
        JButton btnNewButton_4 = new JButton("申报课程");
        btnNewButton_4.setBounds(580, 50, 160, 50);
        btnNewButton_4.setFont(myfont);
        btnNewButton_4.setBackground(new Color(220, 220, 220));
        btnNewButton_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel,"f4");
            }
        });
        Sel_main.add(btnNewButton_4);

        //按钮5
        JButton btnNewButton_5 = new JButton("我的课表");
        btnNewButton_5.setBounds(760, 50, 160, 50);
        btnNewButton_5.setFont(myfont);
        btnNewButton_5.setBackground(new Color(250, 255, 240));
        btnNewButton_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel,"f5");
            }
        });
        Sel_main.add(btnNewButton_5);

        //按钮6
        JButton btnNewButton_6 = new JButton("退出");
        btnNewButton_6.setBounds(940, 50, 160, 50);
        btnNewButton_6.setFont(myfont);
        btnNewButton_6.setBackground(new Color(250, 240, 230));
        btnNewButton_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionChoose.jf.setContentPane(functionChoose.fc_panel);
                functionChoose.jf.setTitle("functionChoose");
                setVisible(false);
            }

        });
        Sel_main.add(btnNewButton_6);

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
