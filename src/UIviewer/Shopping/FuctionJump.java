package UIviewer.Shopping;

import ClientToServer.myInfo;
import UIhandler.Library.Client_library;
import UIhandler.QICQ.Client_qicq;
import UIhandler.StatusManagement.Client_status;
import UIviewer.Library.readLib;
import UIviewer.QQ.main_panel;
import UIviewer.SelectCourse.Selcourse;
import UIviewer.SelectCourse.Selcourse_director;
import UIviewer.SelectCourse.Selcourse_teacher;
import UIviewer.login.functionChoose;
import UIviewer.status_manage.manage_status;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static UIviewer.Shopping.shopCustomer.cardLayout;
import static UIviewer.Shopping.shopCustomer.panel;
import static UIviewer.Shopping.shopCustomer.panel2;

public class FuctionJump {
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度

    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;
    //int width=500;
    //int height=500;

    Color color1=new Color(233,244,255);
    Color color2=new Color(23,58,26);
    Color color3=new Color(57,94,50);
    Color color4=new Color(72,115,78);
    Color color5=new Color(211,229,210);
    Color color6=new Color(243,211,160);
    Font myfont1=new Font("微软雅黑", Font.BOLD, 19);
    Font myfont2=new Font("微软雅黑", Font.BOLD, 20);
    Color white=color2;

    public FuctionJump(){

        System.out.println(width);
        System.out.println(height);

        //setOpaque(false);
        //setBackground(new Color(0, 0, 0, 0)); // 设置透明背景颜色
        //setBackground(color6);
        //setLayout(null);
        //学籍管理
        JButton btnNewButton_1 = new JButton("学籍");
        btnNewButton_1.setFont(myfont1);
        btnNewButton_1.setForeground(color2);
        btnNewButton_1.setOpaque(false);
        btnNewButton_1.setContentAreaFilled(false);
        btnNewButton_1.setBorderPainted(false);
        btnNewButton_1.setFocusPainted(false);
        btnNewButton_1.setBounds(0, 0,80, 30);
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(myInfo.getType()==1) {
                    try {
                        Client_status.stu_enter();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else if(myInfo.getType()==3){
                    try {
                        functionChoose.jf.setContentPane(new manage_status(width,height).manage_panel);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    functionChoose.jf.setTitle("admin_status_management");
                } else {
                    JOptionPane.showMessageDialog(null,"抱歉，您暂无学籍管理权限！");
                }
            }
        });
        panel2.add(btnNewButton_1);
        //图书管理
        JButton btnNewButton_2 = new JButton("图书");
        btnNewButton_2.setFont(myfont1);
        btnNewButton_2.setForeground(color2);
        btnNewButton_2.setOpaque(false);
        btnNewButton_2.setContentAreaFilled(false);
        btnNewButton_2.setBorderPainted(false);
        btnNewButton_2.setFocusPainted(false);
        btnNewButton_2.setBounds(0,30,80, 30);
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionChoose.jf.remove(panel);
                try {
                    Client_qicq.setId(myInfo.getId());
                    if(myInfo.getType()!=3)
                    {
                        functionChoose.jf.setContentPane(new readLib());
                        functionChoose.jf.setTitle("readLib");
                        functionChoose.jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        functionChoose.jf.setVisible(true);
                    }
                    else
                    {
                        //Client_library.RequireshowAllBooks();
                        Client_library.admin_enter();
                        //jf.setContentPane(new adminLib());
                        //jf.setTitle("adminLib");
                        //jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        //jf.setVisible(true);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel2.add(btnNewButton_2);
        //选课系统
        JButton btnNewButton_4 = new JButton("选课");
        btnNewButton_4.setFont(myfont1);
        btnNewButton_4.setForeground(color2);
        btnNewButton_4.setOpaque(false);
        btnNewButton_4.setContentAreaFilled(false);
        btnNewButton_4.setBorderPainted(false);
        btnNewButton_4.setFocusPainted(false);
        btnNewButton_4.setBounds(0, 60,80, 30);
        btnNewButton_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    if(myInfo.getType()==1)
                    {
                        functionChoose.jf.setContentPane(new Selcourse());
                        functionChoose.jf.setTitle("Selcourse");
                    }
                    else if(myInfo.getType()==2)
                    {

                        functionChoose.jf.setContentPane(new Selcourse_teacher());
                        functionChoose.jf.setTitle("Selcourse_teacher");
                    }
                    else {
                        functionChoose.jf.setContentPane(new Selcourse_director());
                        functionChoose.jf.setTitle("Selcourse_director");
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel2.add(btnNewButton_4);
        //站内通信
        JButton btnNewButton_5 = new JButton("通信");
        btnNewButton_5.setFont(myfont1);
        btnNewButton_5.setForeground(color2);
        btnNewButton_5.setOpaque(false);
        btnNewButton_5.setContentAreaFilled(false);
        btnNewButton_5.setBorderPainted(false);
        btnNewButton_5.setFocusPainted(false);
        btnNewButton_5.setBounds(0, 90,80, 30);
        btnNewButton_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionChoose.jf.remove(panel);
                try {
                    Client_qicq.setId(myInfo.getId());
                    if(myInfo.getType()!=3)
                    {
                        functionChoose.jf.setContentPane(new main_panel(width,height,myInfo.getType()).mjp);
                        functionChoose.jf.setTitle("userqq");
                    }
                    else
                    {
                        functionChoose.jf.setContentPane(new main_panel(width,height,myInfo.getType()).mjp);
                        functionChoose.jf.setTitle("adminqq");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel2.add(btnNewButton_5);
        //敬请期待
        JButton btnNewButton_7 = new JButton("期待…");
        btnNewButton_7.setFont(myfont1);
        btnNewButton_7.setForeground(color2);
        btnNewButton_7.setOpaque(false);
        btnNewButton_7.setContentAreaFilled(false);
        btnNewButton_7.setBorderPainted(false);
        btnNewButton_7.setFocusPainted(false);
        btnNewButton_7.setBounds(0, 120, 90, 30);
        btnNewButton_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JOptionPane.showMessageDialog(null,"正在开发中，敬请期待！");
            }
        });
        panel2.add(btnNewButton_7);
        //导航条
        //setBounds(0,0,1500,1500);
    }

    public static void main(String[] args) throws Exception {
        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int width=(int) screensize.getWidth(); //得到宽度
        int height=(int) screensize.getHeight();//获得高度
        JFrame jf=new JFrame("shopCustomer");
        jf.setSize(width,height);
        jf.setBackground(Color.GRAY);
        jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //FuctionJump f1=new FuctionJump();
        //f1.setBounds(0,0,500,500);
        //jf.setContentPane(new FuctionJump());
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);

    };
}
