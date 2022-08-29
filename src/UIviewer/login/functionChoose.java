package UIviewer.login;
import ClientToServer.ClientToServer;
import UIhandler.Library.Client_library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

import UIviewer.QQ.main_panel;
import UIviewer.Shopping.shoppinghall;
import UIviewer.Shopping.shop;

import UIhandler.QICQ.Client_qicq;
import UIviewer.Library.AllBooks;
import UIviewer.Library.readLib;
import UIviewer.Library.adminLib;
import UIviewer.status_manage.manage_status;
import UIviewer.status_manage.student_status;
import net.coobird.thumbnailator.Thumbnails;

public class functionChoose {
    public static JButton back_from_student_status;
    public static JFrame jf;
    public static JPanel fc_panel;
    public static void functionChooseUI(ClientToServer ucs) {
        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int width=(int ) screensize.getWidth(); //得到宽度
        int height=(int ) screensize.getHeight();//获得高度
        double width_r=(double)(width)/1273;
        double height_r=(double)(height)/784;
        jf = new JFrame("functionChoose");
        jf.setSize(width,height);
        //jf.setSize(1273,784);
        fc_panel = new JPanel();
        fc_panel.setLayout(null);
        fc_panel.setBounds(0,0,width,height);
        fc_panel.setBackground(new Color(245,245,245, 180));
        jf.setContentPane(fc_panel);

        //两个修改参数
        //所有的width乘上1920/1273*width_r

        //小头像
        JLabel touxiang = new JLabel();
        ImageIcon icon = new ImageIcon("src/image/头像.png");
        int icon1_width= 75;
        int icon1_height=75;
        try {
            Thumbnails.of(new File("src/image/头像.png"))
                    .size((int)(icon1_width*width_r), (int)(icon1_height*height_r))
                    .toFile(new File("src/image/头像_min.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        touxiang.setIcon(new ImageIcon("src/image/头像_min.png"));
        touxiang.setBounds((int) (20*width_r), (int) (20*height_r), (int) (75*width_r), (int) (75*height_r));
        fc_panel.add(touxiang);


        //文字
        JLabel l1 = new JLabel("  你好！");
        l1.setBounds((int) (100*width_r), (int) (20*height_r), (int) (200*width_r), (int) (75*height_r));
        Font font = new Font("楷体", Font.BOLD, (int) (22*width_r));
        l1.setFont(font);
        fc_panel.add(l1);

        //信息面板
        JLabel l4 = new JLabel("      基本信息");
        l4.setBounds((int) (23*width_r), (int) (155*height_r), (int) (250*width_r), (int) (60*height_r));
        Font font2 = new Font("楷体", Font.BOLD, (int) (25*width_r));
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
        l2.setBounds((int) (30*width_r), (int) (210*height_r), (int) (250*width_r), (int) (60*height_r));
        Font font1 = new Font("微软雅黑", Font.PLAIN, (int) (18*width_r));
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
        l3.setBounds((int) (30*width_r), (int) (250*height_r), (int) (250*width_r), (int) (60*height_r));
        l3.setFont(font1);
        l3.setForeground(new Color(0,0,0));
        fc_panel.add(l3);


        //label背景
        JLabel l11 = new JLabel();
        ImageIcon icon4 = new ImageIcon("src/image/label2.png");
        int icon2_width= 285;
        int icon2_height=400;
        try {
            Thumbnails.of(new File("src/image/label2.png"))
                    .size((int)(icon2_width*width_r), (int)(icon2_height*height_r))
                    .toFile(new File("src/image/label2_min.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        l11.setIcon(new ImageIcon("src/image/label2_min.png"));
        l11.setBounds((int) (15*width_r), (int) (130*height_r), (int) (285*width_r), (int) (400*height_r));
        fc_panel.add(l11);

        //东南大学标志图片
        JLabel logo = new JLabel();
        ImageIcon icon1 = new ImageIcon("src/image/logo-mini.png");
        int icon3_width= 210;
        int icon3_height=65;
        try {
            Thumbnails.of(new File("src/image/logo-mini.png"))
                    .size((int)(icon3_width*width_r), (int)(icon3_height*height_r))
                    .toFile(new File("src/image/logo-mini_min.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logo.setIcon(new ImageIcon("src/image/logo-mini_min.png"));
        logo.setBounds((int) (315*width_r), (int) (5*height_r), (int) (210*width_r), (int) (65*height_r));
        fc_panel.add(logo);


        //右上角图标
        JLabel pic1 = new JLabel();
        ImageIcon icon2 = new ImageIcon("src/image/student.png");
        int icon4_width= 25;
        int icon4_height=25;
        try {
            Thumbnails.of(new File("src/image/student.png"))
                    .size((int)(icon4_width*width_r), (int)(icon4_height*height_r))
                    .toFile(new File("src/image/student_min.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pic1.setIcon(new ImageIcon("src/image/student_min.png"));
        pic1.setBounds((int) (1100*width_r), (int) (15*height_r), (int) (25*width_r), (int) (25*height_r));
        fc_panel.add(pic1);


        JButton btnNewButton_6 = new JButton("安全退出");
        btnNewButton_6.setBounds((int) (1140*width_r), (int) (15*height_r), (int) (100*width_r), (int) (30*height_r));
        Font myfont2 = new Font("微软雅黑", Font.PLAIN, (int) (12*width_r));
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
        int icon5_width= 1020;
        int icon5_height=125;
        try {
            Thumbnails.of(new File("src/image/banner3.png"))
                    .size((int)(icon5_width*width_r), (int)(icon5_height*height_r))
                    .toFile(new File("src/image/banner3_min.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        l12.setIcon(new ImageIcon("src/image/banner3_min.png"));
        l12.setBounds((int) (310*width_r), (int) (70*height_r), (int) (1020*width_r), (int) (125*height_r));
        fc_panel.add(l12);

        //文字
        JLabel l13 = new JLabel("     功能选择 ");
        l13.setBounds((int) (320*width_r), (int) (200*height_r), (int) (200*width_r), (int) (75*height_r));
        Font font13 = new Font("微软雅黑", Font.BOLD, (int) (25*width_r));
        l13.setFont(font13);
        fc_panel.add(l13);

        //左侧面板
        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, (int) (310*width_r), (int) (784*height_r));
        p1.setBackground(new Color(135,206,250, 180));
        fc_panel.add(p1);

        //五个按钮
        //右下面板，学籍管理模块
        JLabel l31 = new JLabel();
        ImageIcon icon31 = new ImageIcon("src/image/icon_72 (1).png");
        int icon6_width= 300;
        int icon6_height=72;
        try {
            Thumbnails.of(new File("src/image/icon_72 (1).png"))
                    .size((int)(icon6_width*width_r), (int)(icon6_height*height_r))
                    .toFile(new File("src/image/icon_72 (1)_min.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        l31.setIcon(new ImageIcon("src/image/icon_72 (1)_min.png"));
        l31.setBounds((int) (449*width_r), (int) (290*height_r), (int) (300*width_r), (int) (72*height_r));
        fc_panel.add(l31);

        JButton btnNewButton_1 = new JButton("学籍管理");
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    jf.setBounds(0,0,width,height);
                    jf.remove(fc_panel);
                    if(ucs.getID().equals("1"))
                        jf.setContentPane(new student_status(ucs,width,height));
                    else if(ucs.getID().equals("3")){
                        jf.setContentPane(new manage_status(ucs,width,height));
                    }
                    jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jf.setVisible(true);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton_1.setBounds((int) (335*width_r), (int) (362*height_r), (int) (300*width_r), (int) (128*height_r));
        Font myfont = new Font("微软雅黑", Font.BOLD, (int) (26*width_r));
        btnNewButton_1.setFont(myfont);
        btnNewButton_1.setBackground(new Color(220,220,220));
        btnNewButton_1.setFocusPainted(false);
        fc_panel.add(btnNewButton_1);
        JPanel p21 = new JPanel();
        p21.setBounds((int) (335*width_r), (int) (290*height_r), (int) (300*width_r), (int) (200*height_r));
        p21.setBackground(new Color(248,248,255));
        fc_panel.add(p21);

        JLabel l32 = new JLabel();
        ImageIcon icon32 = new ImageIcon("src/image/icon_72 (3).png");
        int icon7_width= 300;
        int icon7_height=72;
        try {
            Thumbnails.of(new File("src/image/icon_72 (3).png"))
                    .size((int)(icon7_width*width_r), (int)(icon7_height*height_r))
                    .toFile(new File("src/image/icon_72 (3)_min.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        l32.setIcon(new ImageIcon("src/image/icon_72 (3)_min.png"));
        l32.setBounds((int) (754*width_r), (int) (290*height_r), (int) (300*width_r), (int) (72*height_r));
        fc_panel.add(l32);
        JButton btnNewButton_2 = new JButton("选课系统");
        btnNewButton_2.setFocusPainted(false);
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    if(ucs.getID()=="1")
                    {
                        Client_library.setId(ucs.getIDcard());
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
        btnNewButton_2.setBounds((int) (640*width_r), (int) (362*height_r), (int) (300*width_r), (int) (128*height_r));
        btnNewButton_2.setFont(myfont);
        btnNewButton_2.setBackground(new Color(220,220,220));
        fc_panel.add(btnNewButton_2);

        JPanel p22 = new JPanel();
        p22.setBounds((int) (640*width_r), (int) (290*height_r), (int) (300*width_r), (int) (200*height_r));
        p22.setBackground(new Color(248,248,255));
        fc_panel.add(p22);

        JLabel l33 = new JLabel();
        ImageIcon icon33 = new ImageIcon("src/image/icon_72 (5).png");
        int icon8_width= 300;
        int icon8_height=72;
        try {
            Thumbnails.of(new File("src/image/icon_72 (5).png"))
                    .size((int)(icon8_width*width_r), (int)(icon8_height*height_r))
                    .toFile(new File("src/image/icon_72 (5)_min.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        l33.setIcon(new ImageIcon("src/image/icon_72 (5)_min.png"));
        l33.setBounds((int) (1059*width_r), (int) (290*height_r), (int) (300*width_r), (int) (72*height_r));
        fc_panel.add(l33);

        JButton btnNewButton_3 = new JButton("商店系统");
        btnNewButton_3.setFocusPainted(false);
        btnNewButton_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    shoppinghall.shoppingUI(ucs);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton_3.setBounds((int) (945*width_r), (int) (362*height_r), (int) (300*width_r), (int) (128*height_r));
        btnNewButton_3.setFont(myfont);
        btnNewButton_3.setBackground(new Color(220,220,220));
        //btnNewButton_3.setBorder(null);//取消边框
        //btnNewButton_1.setForeground(new Color(248, 248, 255));
        fc_panel.add(btnNewButton_3);
        JPanel p23 = new JPanel();
        p23.setBounds((int) (945*width_r), (int) (290*height_r), (int) (300*width_r), (int) (200*height_r));
        p23.setBackground(new Color(248,248,255));
        fc_panel.add(p23);

        JLabel l34 = new JLabel();
        ImageIcon icon34 = new ImageIcon("src/image/icon_72 (4).png");
        int icon9_width= 300;
        int icon9_height=72;
        try {
            Thumbnails.of(new File("src/image/icon_72 (4).png"))
                    .size((int)(icon9_width*width_r), (int)(icon9_height*height_r))
                    .toFile(new File("src/image/icon_72 (4)_min.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        l34.setIcon(new ImageIcon("src/image/icon_72 (4)_min.png"));
        l34.setBounds((int) (449*width_r), (int) (500*height_r), (int) (300*width_r), (int) (72*height_r));
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
                        Client_library.setId(ucs.getIDcard());
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
        btnNewButton_4.setBounds((int) (335*width_r), (int) (572*height_r), (int) (300*width_r), (int) (128*height_r));
        btnNewButton_4.setFont(myfont);
        btnNewButton_4.setBackground(new Color(220,220,220));
        //btnNewButton_4.setBorder(null);//取消边框
        //btnNewButton_1.setForeground(new Color(248, 248, 255));
        fc_panel.add(btnNewButton_4);
        JPanel p24 = new JPanel();
        p24.setBounds((int) (335*width_r), (int) (500*height_r), (int) (300*width_r), (int) (200*height_r));
        p24.setBackground(new Color(248,248,255));
        fc_panel.add(p24);

        JLabel l35 = new JLabel();
        ImageIcon icon35 = new ImageIcon("src/image/icon_72 (6).png");
        int icon10_width= 300;
        int icon10_height=72;
        try {
            Thumbnails.of(new File("src/image/icon_72 (6).png"))
                    .size((int)(icon9_width*width_r), (int)(icon9_height*height_r))
                    .toFile(new File("src/image/icon_72 (6)_min.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        l35.setIcon(new ImageIcon("src/image/icon_72 (6)_min.png"));
        l35.setBounds((int) (754*width_r), (int) (500*height_r), (int) (300*width_r), (int) (72*height_r));
        fc_panel.add(l35);
        JButton btnNewButton_5 = new JButton("站内通信");
        btnNewButton_5.setFocusPainted(false);
        btnNewButton_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    Client_qicq.setId(ucs.getIDcard());
                    if(ucs.getID()=="1"||ucs.getID()=="2")
                    {
                        jf.setContentPane(new main_panel(ucs,width,height));
                    }
                    else
                    {
                        jf.setContentPane(new main_panel(ucs,width,height));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton_5.setBounds((int) (640*width_r), (int) (572*height_r), (int) (300*width_r), (int) (128*height_r));
        btnNewButton_5.setFont(myfont);
        btnNewButton_5.setBackground(new Color(220,220,220));
        //btnNewButton_5.setBorder(null);//取消边框
        //btnNewButton_1.setForeground(new Color(248, 248, 255));
        fc_panel.add(btnNewButton_5);
        JPanel p25 = new JPanel();
        p25.setBounds((int) (640*width_r), (int) (500*height_r), (int) (300*width_r), (int) (200*height_r));
        p25.setBackground(new Color(248,248,255));
        fc_panel.add(p25);

        //右下面板
        JPanel p3 = new JPanel();
        p3.setBounds((int) (330*width_r), (int) (285*height_r), (int) (920*width_r), (int) (420*height_r));
        p3.setBackground(new Color(211,211,211,100));
        fc_panel.add(p3);

        //右侧面板
        JPanel p2 = new JPanel();
        p2.setBounds((int) (300*width_r), 0, (int) (950*width_r), (int) (790*height_r));
        p2.setBackground(new Color(245,245,245, 180));
        fc_panel.add(p2);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);
    }

}
