package UIviewer.SelectCourse;

import UIhandler.Currirulum.Client_curriculum;
import UIviewer.Shop.Consult_goods;
import UIviewer.login.functionChoose;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class Selcourse extends JFrame {

    private JPanel main_win;
    public static CardLayout cardLayout=new CardLayout();
    public static JPanel panel=new JPanel();
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Selcourse frame = new Selcourse();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public Selcourse()
    {
        setTitle("Selcourse");
        setBounds(0,0,1273,790);
        main_win=new JPanel();
       setContentPane(main_win);
       main_win.setLayout(null);

        panel.setBounds(0,100,1273,790);
        main_win.add(panel);
        panel.setLayout(cardLayout);
        ConsultCourse_Info f1=new ConsultCourse_Info();
        panel.add(f1,"f1");
        ConsultCourse_Chosen f2=new ConsultCourse_Chosen();
        panel.add(f2,"f2");
        ChooseCourse_guidance f3=new ChooseCourse_guidance();
        panel.add(f3,"f3");
        Choosing_Course f4=new Choosing_Course();
        panel.add(f4,"f4");
        My_Coursetable f5=new My_Coursetable();
        panel.add(f5,"f5");


        //六个按钮
        // 按钮1
        JButton btnNewButton_1 = new JButton("查询课程信息");
        btnNewButton_1.setBounds(40, 50, 160, 50);
        Font myfont = new Font("微软雅黑 ",Font.BOLD,18);
        btnNewButton_1.setFont(myfont);
        btnNewButton_1.setBackground(new Color(	220 ,220, 220));
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel,"f1");
            }
        });
        main_win.add(btnNewButton_1);


        // 按钮2
        JButton btnNewButton_2 = new JButton("查看已选课程");
        btnNewButton_2.setBounds(220, 50, 160, 50);
        btnNewButton_2.setFont(myfont);
        btnNewButton_2.setBackground(new Color(	250 ,255, 240));
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel,"f2");
            }
        });
        main_win.add(btnNewButton_2);


        // 按钮3
        JButton btnNewButton_3 = new JButton("选课帮助");
        btnNewButton_3.setBounds(400, 50, 160, 50);
        btnNewButton_3.setFont(myfont);
        btnNewButton_3.setBackground(new Color(	250 ,240, 230));
        btnNewButton_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel,"f3");
            }
        });
        main_win.add(btnNewButton_3);

        //按钮4
        JButton btnNewButton_4 = new JButton("选课界面");
        btnNewButton_4.setBounds(580, 50, 160, 50);
        btnNewButton_4.setFont(myfont);
        btnNewButton_4.setBackground(new Color(	220 ,220, 220));
        btnNewButton_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Client_curriculum.RequireallCourse();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                cardLayout.show(panel,"f4");
            }
        });
        main_win.add(btnNewButton_4);

        //按钮5
        JButton btnNewButton_5 = new JButton("我的课表");
        btnNewButton_5.setBounds(760, 50, 160, 50);
        btnNewButton_5.setFont(myfont);
        btnNewButton_5.setBackground(new Color(	250 ,255, 240));
        btnNewButton_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel,"f5");
            }
        });
        main_win.add(btnNewButton_5);

        //按钮6
        JButton btnNewButton_6 = new JButton("退出");
        btnNewButton_6.setBounds(940, 50, 160, 50);
        btnNewButton_6.setFont(myfont);
        btnNewButton_6.setBackground(new Color(	250 ,240, 230));

        btnNewButton_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionChoose.jf.setContentPane(functionChoose.fc_panel);
                functionChoose.jf.setTitle("functionChoose");
                setVisible(false);
            }
        });
        main_win.add(btnNewButton_6);

        /*JPanel p2=new JPanel();
        p2.setBounds(0,100,1273,784);
        main_win.add(p2);*/

        //东南大学标志图片
        JLabel l15 = new JLabel();
        ImageIcon icon6 = new ImageIcon("src/image/background2.jpg");
        l15.setIcon(icon6);
        l15.setBounds(0, 0, 1273, 790);
        main_win.add(l15);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setVisible(true);
    }


}
