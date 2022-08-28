package UIviewer.login;
import ClientToServer.ClientToServer;
import UIhandler.Library.Client_library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import UIviewer.Library.AllBooks;
import UIviewer.Library.readLib;
import UIviewer.Library.adminLib;
import UIviewer.status_manage.manage_status;
import UIviewer.status_manage.student_status;

public class functionChoose {
    public static JButton back_from_student_status;
    public static JFrame jf;
    public static JPanel fc_panel;
    public static void functionChooseUI(ClientToServer ucs) {
        jf = new JFrame("functionChoose");
        jf.setSize(1273,784);
        fc_panel = new JPanel();
        fc_panel.setLayout(null);
        fc_panel.setBounds(0,0,1273,784);
        jf.setContentPane(fc_panel);

        //小头像
        JLabel touxiang = new JLabel();
        ImageIcon icon = new ImageIcon("src/image/头像.png");
        touxiang.setIcon(icon);
        touxiang.setBounds(20, 20, 75, 75);
        fc_panel.add(touxiang);

        //文字
        JLabel l1 = new JLabel("  你好！");
        l1.setBounds(100, 20, 200, 75);
        Font font = new Font("楷体", Font.BOLD, 22);
        l1.setFont(font);
        fc_panel.add(l1);

        //信息面板
        JLabel l4 = new JLabel("      基本信息");
        l4.setBounds(23, 155, 250, 60);
        Font font2 = new Font("楷体", Font.BOLD, 25);
        l4.setFont(font2);
        l4.setForeground(new Color(30,144,255));
        fc_panel.add(l4);
        String name=null;
        if(ucs.getID().equals("1"))
            name=ucs.getS().getStudent_name();
        else if(ucs.getID().equals("2"))
            name=ucs.getT().getTeacher_name();
        else if(ucs.getID().equals("3"))
            name=ucs.getA().getAdmin_name();
        JLabel l2 = new JLabel(" 姓名："+name);
        l2.setBounds(30, 210, 250, 60);
        Font font1 = new Font("微软雅黑", Font.PLAIN, 18);
        l2.setFont(font1);
        l2.setForeground(new Color(0,0,0));
        fc_panel.add(l2);
        String card=null;
        if(ucs.getID().equals("1"))
            card=ucs.getS().getStudent_idcard();
        else if(ucs.getID().equals("2"))
            card=ucs.getT().getTeacher_idcard();
        else if(ucs.getID().equals("3"))
            card=ucs.getA().getAdmin_idcard();
        JLabel l3 = new JLabel(" 卡号："+card);
        l3.setBounds(30, 250, 250, 60);
        l3.setFont(font1);
        l3.setForeground(new Color(0,0,0));
        fc_panel.add(l3);

        //label背景
        JLabel l11 = new JLabel();
        ImageIcon icon4 = new ImageIcon("src/image/label2.png");
        l11.setIcon(icon4);
        l11.setBounds(15, 130, 285, 400);
        fc_panel.add(l11);

        //东南大学标志图片
        JLabel logo = new JLabel();
        ImageIcon icon1 = new ImageIcon("src/image/logo-mini.png");
        logo.setIcon(icon1);
        logo.setBounds(315, 5, 210, 65);
        fc_panel.add(logo);
        //右上角图标
        JLabel pic1 = new JLabel();
        ImageIcon icon2 = new ImageIcon("src/image/student.png");
        pic1.setIcon(icon2);
        pic1.setBounds(1100, 15, 25, 25);
        fc_panel.add(pic1);

        JButton btnNewButton_6 = new JButton("安全退出");
        btnNewButton_6.setBounds(1140, 15, 100, 30);
        Font myfont2 = new Font("微软雅黑", Font.PLAIN, 12);
        btnNewButton_6.setFont(myfont2);
        btnNewButton_6.setBackground(new Color(248,248,255));
        btnNewButton_6.setContentAreaFilled(false);//设置按钮透明
        btnNewButton_6.setFocusPainted(false);
        fc_panel.add(btnNewButton_6);

        btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    ucs.logout();
                    jf.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        //横向图片
        JLabel l12 = new JLabel();
        ImageIcon icon5 = new ImageIcon("src/image/banner3.png");
        l12.setIcon(icon5);
        l12.setBounds(310, 70, 1000, 125);
        fc_panel.add(l12);

        //文字
        JLabel l13 = new JLabel("     功能选择 ");
        l13.setBounds(320, 200, 200, 75);
        Font font13 = new Font("微软雅黑", Font.BOLD, 25);
        l13.setFont(font13);
        fc_panel.add(l13);

        //左侧面板
        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 310, 784);
        p1.setBackground(new Color(135,206,250, 180));
        fc_panel.add(p1);

        //五个按钮
        //右下面板，学籍管理模块
        JLabel l31 = new JLabel();
        ImageIcon icon31 = new ImageIcon("src/image/icon_72 (1).png");
        l31.setIcon(icon31);
        l31.setBounds(449, 290, 300, 72);
        fc_panel.add(l31);
        JButton btnNewButton_1 = new JButton("学籍管理");
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    JButton jb = new JButton();
                    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
                    int width=(int ) screensize.getWidth(); //得到宽度
                    int height=(int ) screensize.getHeight();//获得高度
                    jf.setBounds(0,0,width,height);
                    jf.remove(fc_panel);
                    if(ucs.getID().equals("1"))
                        jf.setContentPane(new student_status(ucs,width,height));
                    else if(ucs.getID().equals("3")){
                        jf.setContentPane(new manage_status(ucs,width,height));
                    }
                    jb.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            jf.getContentPane().setVisible(false);
                        }
                    });
                    jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jf.setVisible(true);
                    //返回功能选择模块
//                    back_from_status.addActionListener(new ActionListener() {
//                        @Override
//                        public void actionPerformed(ActionEvent e) {
//
//                        }
//                    });

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton_1.setBounds(335, 362, 300, 128);
        Font myfont = new Font("微软雅黑", Font.BOLD, 26);
        btnNewButton_1.setFont(myfont);
        btnNewButton_1.setBackground(new Color(220,220,220));
        btnNewButton_1.setFocusPainted(false);
        fc_panel.add(btnNewButton_1);
        JPanel p21 = new JPanel();
        p21.setBounds(335, 290, 300, 200);
        p21.setBackground(new Color(248,248,255));
        fc_panel.add(p21);

        JLabel l32 = new JLabel();
        ImageIcon icon32 = new ImageIcon("src/image/icon_72 (3).png");
        l32.setIcon(icon32);
        l32.setBounds(754, 290, 300, 72);
        fc_panel.add(l32);
        JButton btnNewButton_2 = new JButton("选课系统");
        btnNewButton_2.setFocusPainted(false);
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {


                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton_2.setBounds(640, 362, 300, 128);
        btnNewButton_2.setFont(myfont);
        btnNewButton_2.setBackground(new Color(220,220,220));
        fc_panel.add(btnNewButton_2);
        JPanel p22 = new JPanel();
        p22.setBounds(640, 290, 300, 200);
        p22.setBackground(new Color(248,248,255));
        fc_panel.add(p22);

        JLabel l33 = new JLabel();
        ImageIcon icon33 = new ImageIcon("src/image/icon_72 (5).png");
        l33.setIcon(icon33);
        l33.setBounds(1059, 290, 300, 72);
        fc_panel.add(l33);
        JButton btnNewButton_3 = new JButton("商店系统");
        btnNewButton_3.setFocusPainted(false);
        btnNewButton_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {


                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton_3.setBounds(945, 362, 300, 128);
        btnNewButton_3.setFont(myfont);
        btnNewButton_3.setBackground(new Color(220,220,220));
        //btnNewButton_3.setBorder(null);//取消边框
        //btnNewButton_1.setForeground(new Color(248, 248, 255));
        fc_panel.add(btnNewButton_3);
        JPanel p23 = new JPanel();
        p23.setBounds(945, 290, 300, 200);
        p23.setBackground(new Color(248,248,255));
        fc_panel.add(p23);

        JLabel l34 = new JLabel();
        ImageIcon icon34 = new ImageIcon("src/image/icon_72 (4).png");
        l34.setIcon(icon34);
        l34.setBounds(449, 500, 300, 72);
        fc_panel.add(l34);
        JButton btnNewButton_4 = new JButton("图书馆系统");
        btnNewButton_4.setFocusPainted(false);
        btnNewButton_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    if(ucs.getID()=="1"||ucs.getID()=="2")
                    {
                        readLib.readLibUI(ucs);
                    }
                    else
                    {
                        Client_library.setId(ucs.getIDcard());

                        Client_library.RequireshowAllBooks();
                        while (AllBooks.tableDate==null);
                        adminLib.adminLibUI(ucs);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton_4.setBounds(335, 572, 300, 128);
        btnNewButton_4.setFont(myfont);
        btnNewButton_4.setBackground(new Color(220,220,220));
        //btnNewButton_4.setBorder(null);//取消边框
        //btnNewButton_1.setForeground(new Color(248, 248, 255));
        fc_panel.add(btnNewButton_4);
        JPanel p24 = new JPanel();
        p24.setBounds(335, 500, 300, 200);
        p24.setBackground(new Color(248,248,255));
        fc_panel.add(p24);

        JLabel l35 = new JLabel();
        ImageIcon icon35 = new ImageIcon("src/image/icon_72 (6).png");
        l35.setIcon(icon35);
        l35.setBounds(754, 500, 300, 72);
        fc_panel.add(l35);
        JButton btnNewButton_5 = new JButton("站内通信");
        btnNewButton_5.setFocusPainted(false);
        btnNewButton_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {


                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton_5.setBounds(640, 572, 300, 128);
        btnNewButton_5.setFont(myfont);
        btnNewButton_5.setBackground(new Color(220,220,220));
        //btnNewButton_5.setBorder(null);//取消边框
        //btnNewButton_1.setForeground(new Color(248, 248, 255));
        fc_panel.add(btnNewButton_5);
        JPanel p25 = new JPanel();
        p25.setBounds(640, 500, 300, 200);
        p25.setBackground(new Color(248,248,255));
        fc_panel.add(p25);

        //右下面板
        JPanel p3 = new JPanel();
        p3.setBounds(330, 285, 920, 420);
        p3.setBackground(new Color(211,211,211,100));
        fc_panel.add(p3);

        //右侧面板
        JPanel p2 = new JPanel();
        p2.setBounds(300, 0, 950, 784);
        p2.setBackground(new Color(245,245,245, 180));
        fc_panel.add(p2);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);
    }

}
