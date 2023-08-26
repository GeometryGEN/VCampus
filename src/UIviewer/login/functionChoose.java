package UIviewer.login;
import ClientToServer.ClientToServer;
import DAO.Shop.Product;
import UIhandler.Library.Client_library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import UIhandler.Shop.Client_shop;
import UIhandler.StatusManagement.Client_status;
import UIviewer.QQ.main_panel;
import UIviewer.SelectCourse.Selcourse;
import UIviewer.SelectCourse.Selcourse_director;
import UIviewer.SelectCourse.Selcourse_teacher;


import UIhandler.QICQ.Client_qicq;
import UIviewer.Library.AllBooks;
import UIviewer.Library.readLib;
import UIviewer.Library.adminLib;
import UIviewer.Shopping.shopAdmin;
import UIviewer.Shopping.shopCustomer;
import UIviewer.status_manage.manage_status;
import UIviewer.status_manage.student_status;
import net.coobird.thumbnailator.Thumbnails;
import ClientToServer.myInfo;

/**
 * 功能选择
 *
 * @author Chen_GuanZhi
 * @date 2022/09/03
 */
public class functionChoose {

    public static JButton back_from_student_status;
    public static JFrame jf;
    public static JPanel fc_panel;
    public static boolean color_switch;

    /**
     * 功能选择界面
     */
    public static void functionChooseUI(boolean color_switch) {
        color_switch=true;
        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int width=(int) screensize.getWidth(); //得到宽度
        int height=(int) screensize.getHeight();//获得高度
        System.out.println(width);
        System.out.println(height);
        double width_r=(double)(width)/1273;
        double height_r=(double)(height)/784;
        jf = new JFrame("欢迎使用VCampus虚拟校园系统，请选择您的服务！");
        jf.setSize(width,height);
        jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //jf.setSize(1273,784);
        fc_panel = new JPanel();
        fc_panel.setLayout(null);
        fc_panel.setBounds(0,0, (int) (width*1.2), (int) (height*1.2));
        if(color_switch) {
            fc_panel.setBackground(new Color(200,224,228,180));
        }else{
            fc_panel.setBackground(new Color(51, 51, 51, 180));
        }
        jf.setContentPane(fc_panel);

        //向好友发送上线消息
        try {
            Client_qicq.setId(myInfo.getId());
            Client_qicq.I_am_online();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //右边面板
            //小头像
        JLabel touxiang = new JLabel();
        ImageIcon icon = new ImageIcon("src/image/默认头像.png");
        int icon1_width=160;
        int icon1_height=160;
        try {
            Thumbnails.of(new File("src/image/默认头像.png"))
                    .size((int)(icon1_width*width_r), (int)(icon1_height*height_r))
                    .toFile(new File("src/image/头像_min.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        touxiang.setIcon(new ImageIcon("src/image/头像_min.png"));
        touxiang.setBounds((int) (1015*width_r), (int) (60*height_r), (int) (160*width_r), (int) (160*height_r));
        fc_panel.add(touxiang);
            //信息面板
        Font font2 = new Font("楷体", Font.BOLD, (int) (35*width_r));
        String name= myInfo.getName();
        JLabel l2 = new JLabel(" 姓名: "+name);
        l2.setBounds((int) (1000*width_r), (int) (240*height_r), (int) (250*width_r), (int) (60*height_r));
        Font font1 = new Font("微软雅黑", Font.PLAIN, (int) (18*width_r));
        l2.setFont(font1);
        if(color_switch){
            l2.setForeground(new Color(0,0,0));
        }else{
            l2.setForeground(new Color(255,255,255));
        }
        fc_panel.add(l2);
        String card=myInfo.getId();
        JLabel l3 = new JLabel(" 卡号: "+card);
        l3.setBounds((int) (1000*width_r), (int) (280*height_r), (int) (250*width_r), (int) (60*height_r));
        l3.setFont(font1);
        if(color_switch){
            l3.setForeground(new Color(0,0,0));
        }else{
            l3.setForeground(new Color(255,255,255));
        }
        fc_panel.add(l3);
        int iden=myInfo.getType();
        String identify=null;
        if(iden==1)
        {identify="学生";}
        if(iden==2)
        {identify="教师";}
        if(iden==3)
        {identify="管理员";}
        JLabel l21 = new JLabel(" 身份："+identify);
        l21.setBounds((int) (1000*width_r), (int) (320*height_r), (int) (250*width_r), (int) (60*height_r));
        l21.setFont(font1);
        if(color_switch){
            l21.setForeground(new Color(0,0,0));
        }else{
            l21.setForeground(new Color(255,255,255));
        }
        fc_panel.add(l21);
            //退出按钮（位置未知！！！）
        JButton btnNewButton_6 = new JButton("退出");
        btnNewButton_6.setBounds((int) (1100*width_r), (int) (800*height_r), (int) (100*width_r), (int) (30*height_r));
        Font myfont2 = new Font("微软雅黑", Font.PLAIN, (int) (12*width_r));
        btnNewButton_6.setFont(myfont2);
        if(color_switch){
            btnNewButton_6.setBackground(new Color(125,182,191));
            btnNewButton_6.setForeground(new Color(0,0,0));
        }else{
            btnNewButton_6.setBackground(new Color(42,52,65));
            btnNewButton_6.setForeground(new Color(255,255,255));
        }
        btnNewButton_6.setContentAreaFilled(true);
        btnNewButton_6.setFocusPainted(false);
        fc_panel.add(btnNewButton_6);
        btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    try {
                        Client_qicq.I_am_offline();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    ClientToServer.logout();
                    jf.dispose();
                    LoginFrame.jf.setVisible(true);
                    LoginFrame.passwordField.setText("");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
            //日/夜切换按钮
            //label背景
        JLabel l11 = new JLabel();
        ImageIcon icon4 = new ImageIcon("src/image/label2.png");
        int icon4_width=300;
        int icon4_height=900;
        try {
            if(color_switch){
                Thumbnails.of(new File("src/image/label2.png"))
                        .size((int)(icon4_width*width_r), (int)(icon4_height*height_r))
                        .toFile(new File("src/image/label2_min.png"));
            }else{
                Thumbnails.of(new File("src/image/label2(1).png"))
                        .size((int)(icon4_width*width_r), (int)(icon4_height*height_r))
                        .toFile(new File("src/image/label2_min.png"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        l11.setIcon(new ImageIcon("src/image/label2_min.png"));
        l11.setBounds((int) (950*width_r), (int)(5*height_r), (int) (300*width_r), (int) (725*height_r));
        fc_panel.add(l11);

        //五个按钮
            //教育管理
            JLabel l51 =new JLabel("教育管理");
            Font font4=new Font("楷体",Font.BOLD,(int)(26*width_r));
            l51.setFont(font4);
            if(color_switch){
                l51.setForeground(new Color(0,0,0));
            }else{
                l51.setForeground(new Color(255,255,255));
            }
            l51.setBounds((int)(130*width_r),(int)(210*height_r),(int)(250*width_r),(int)(50*height_r));
            fc_panel.add(l51);
                //学籍管理
                JButton btnNewButton_1 = new JButton("学籍管理");
                btnNewButton_1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        try {
                            //jf.setBounds(0,0,width,height);
                            jf.remove(fc_panel);
                            Client_status.ini();
                            if(myInfo.getType()==1) {
                                Client_status.stu_enter();
                            }
                            else if(myInfo.getType()==3){
                                jf.setContentPane(new manage_status(width,height).manage_panel);
                                jf.setTitle("admin_status_management");
                            } else {
                                JOptionPane.showMessageDialog(null,"抱歉，您暂无学籍管理权限！");
                            }

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                btnNewButton_1.setBounds((int) (80*width_r), (int) (410*height_r), (int) (200*width_r), (int) (28*height_r));
                Font myfont = new Font("宋体", Font.BOLD, (int) (20*width_r));
                btnNewButton_1.setFont(myfont);
                if(color_switch){
                    btnNewButton_1.setBackground(new Color(245,245,245));
                    btnNewButton_1.setForeground(new Color(0,0,0));
                }else{
                    btnNewButton_1.setBackground(new Color(50,50,50));
                    btnNewButton_1.setForeground(new Color(245,245,245));
                }
                btnNewButton_1.setFocusPainted(false);
                fc_panel.add(btnNewButton_1);

                JLabel l31 = new JLabel();
                ImageIcon icon31 = new ImageIcon("src/image/学籍管理.png");
                int icon6_width=170;
                int icon6_height=170;
                try {
                    Thumbnails.of(new File("src/image/学籍管理.png"))
                            .size((int)(icon6_width*width_r), (int)(icon6_height*height_r))
                            .toFile(new File("src/image/学籍管理_min.png"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                l31.setIcon(new ImageIcon("src/image/学籍管理_min.png"));
                l31.setBounds((int) (95*width_r), (int) (250*height_r), (int) (icon6_width*width_r), (int) (icon6_height*height_r));
                fc_panel.add(l31);
                //选课系统
                JButton btnNewButton_2 = new JButton("选课系统");
                btnNewButton_2.setFocusPainted(false);
                btnNewButton_2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        try {
                            jf.remove(fc_panel);
                            if(myInfo.getType()==1)
                            {
                                jf.setContentPane(new Selcourse());
                                jf.setTitle("Selcourse");
                            }
                            else if(myInfo.getType()==2)
                            {
                                jf.setContentPane(new Selcourse_teacher());
                                jf.setTitle("Selcourse_teacher");
                            }
                            else {
                                jf.setContentPane(new Selcourse_director());
                                jf.setTitle("Selcourse_director");
                            }

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                btnNewButton_2.setBounds((int) (80*width_r), (int) (595*height_r), (int) (200*width_r), (int) (28*height_r));
                btnNewButton_2.setFont(myfont);
                if(color_switch){
                    btnNewButton_2.setBackground(new Color(245,245,245));
                    btnNewButton_2.setForeground(new Color(0,0,0));
                }else{
                    btnNewButton_2.setBackground(new Color(50,50,50));
                    btnNewButton_2.setForeground(new Color(245,245,245));
                }
                btnNewButton_2.setFocusPainted(false);
                fc_panel.add(btnNewButton_2);

                JLabel l32 = new JLabel();
                ImageIcon icon32 = new ImageIcon("src/image/选课系统.png");
                int icon7_width=170;
                int icon7_height=170;
                try {
                    Thumbnails.of(new File("src/image/选课系统.png"))
                            .size((int)(icon7_width*width_r), (int)(icon7_height*height_r))
                            .toFile(new File("src/image/选课系统_min.png"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                l32.setIcon(new ImageIcon("src/image/选课系统_min.png"));
                l32.setBounds((int) (95*width_r), (int) (440*height_r), (int) (icon7_width*width_r), (int) (icon7_height*height_r));
                fc_panel.add(l32);
            //信息交流
        JLabel l52 =new JLabel("信息交流");
        l52.setFont(font4);
        if(color_switch){
            l52.setForeground(new Color(0,0,0));
        }else{
            l52.setForeground(new Color(255,255,255));
        }
        l52.setBounds((int)(425*width_r),(int)(210*height_r),(int)(250*width_r),(int)(50*height_r));
        fc_panel.add(l52);
            //电子商务
        JLabel l53 =new JLabel("电子商务");
        l53.setFont(font4);
        if(color_switch){
            l53.setForeground(new Color(0,0,0));
        }else{
            l53.setForeground(new Color(255,255,255));
        }
        l53.setBounds((int)(720*width_r),(int)(210*height_r),(int)(250*width_r),(int)(50*height_r));
        fc_panel.add(l53);


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
                    jf.remove(fc_panel);
                    if(myInfo.getType()!=3)
                    {
                        Client_shop.setId(String.valueOf(myInfo.getType()));
                        Client_shop.setIdcard(myInfo.getId());
                        jf.setContentPane(new shopCustomer());
                        jf.setTitle("shopCustomer");
                    }
                    else
                    {
                        Client_shop.setId(String.valueOf(myInfo.getType()));
                        Client_shop.setIdcard(myInfo.getId());
                        jf.setContentPane(new shopAdmin());
                        jf.setTitle("shopAdmin");
                    }
                    jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jf.setVisible(true);
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
                    jf.remove(fc_panel);
                    Client_library.setId(myInfo.getId());
                    if(myInfo.getType()!=3)
                    {
                        jf.setContentPane(new readLib());
                        jf.setTitle("readLib");
                        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        jf.setVisible(true);
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
                    Client_qicq.setId(myInfo.getId());
                    if(myInfo.getType()!=3)
                    {
                        jf.setContentPane(new main_panel(width,height,myInfo.getType()).mjp);
                        jf.setTitle("userqq");
                    }
                    else
                    {
                        jf.setContentPane(new main_panel(width,height,myInfo.getType()).mjp);
                        jf.setTitle("adminqq");
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

        JButton btnNewButton_7 = new JButton("敬请期待");
        btnNewButton_7.setFocusPainted(false);
        btnNewButton_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JOptionPane.showMessageDialog(null,"正在开发中，敬请期待！");
            }
        });
        JLabel l37 = new JLabel();
        ImageIcon icon37 = new ImageIcon("src/image/icon_72 (2).png");
        try {
            Thumbnails.of(new File("src/image/icon_72 (2).png"))
                    .size((int)(icon9_width*width_r), (int)(icon9_height*height_r))
                    .toFile(new File("src/image/icon_72 (2)_min.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        l37.setIcon(new ImageIcon("src/image/icon_72 (2)_min.png"));
        l37.setBounds((int) (1059*width_r), (int) (500*height_r), (int) (300*width_r), (int) (72*height_r));
        fc_panel.add(l37);
        btnNewButton_7.setBounds((int) (945*width_r), (int) (572*height_r), (int) (300*width_r), (int) (128*height_r));
        btnNewButton_7.setFont(myfont);
        btnNewButton_7.setBackground(new Color(220,220,220));
        fc_panel.add(btnNewButton_7);
        JPanel p27 = new JPanel();
        p27.setBounds((int) (945*width_r), (int) (500*height_r), (int) (300*width_r), (int) (200*height_r));
        p27.setBackground(new Color(248,248,255));
        fc_panel.add(p27);
            //背景*3
        JLabel l41=new JLabel();
        ImageIcon icon41=new ImageIcon("src/image/label3(1).png");
        int icon41_width=275;
        int icon41_height=520;
        try{
            if(color_switch){
                Thumbnails.of(new File("src/image/label3.png"))
                        .size((int)(icon41_width*width_r), (int)(icon41_height*height_r))
                        .toFile(new File("src/image/label3(1)_min.png"));
            }else{
                Thumbnails.of(new File("src/image/label3(1).png"))
                        .size((int)(icon41_width*width_r), (int)(icon41_height*height_r))
                        .toFile(new File("src/image/label3(1)_min.png"));
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        l41.setIcon(new ImageIcon("src/image/label3(1)_min.png"));
        l41.setBounds((int) (50*width_r), (int) (175*height_r), (int) (icon41_width*width_r), (int) (icon41_height*height_r));
        fc_panel.add(l41);

        JLabel l42=new JLabel();
        try{
            if(color_switch){
                Thumbnails.of(new File("src/image/label3.png"))
                        .size((int)(icon41_width*width_r), (int)(icon41_height*height_r))
                        .toFile(new File("src/image/label3(1)_min.png"));
            }else{
                Thumbnails.of(new File("src/image/label3(1).png"))
                        .size((int)(icon41_width*width_r), (int)(icon41_height*height_r))
                        .toFile(new File("src/image/label3(1)_min.png"));
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        l42.setIcon(new ImageIcon("src/image/label3(1)_min.png"));
        l42.setBounds((int) (345*width_r), (int) (175*height_r), (int) (icon41_width*width_r), (int) (icon41_height*height_r));
        fc_panel.add(l42);

        JLabel l43=new JLabel();
        try{
            if(color_switch){
                Thumbnails.of(new File("src/image/label3.png"))
                        .size((int)(icon41_width*width_r), (int)(icon41_height*height_r))
                        .toFile(new File("src/image/label3(1)_min.png"));
            }else{
                Thumbnails.of(new File("src/image/label3(1).png"))
                        .size((int)(icon41_width*width_r), (int)(icon41_height*height_r))
                        .toFile(new File("src/image/label3(1)_min.png"));
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        l43.setIcon(new ImageIcon("src/image/label3(1)_min.png"));
        l43.setBounds((int) (640*width_r), (int) (175*height_r), (int) (icon41_width*width_r), (int) (icon41_height*height_r));
        fc_panel.add(l43);

        //校徽横幅
        JLabel l15=new JLabel();
        ImageIcon icon22=new ImageIcon("src/image/banner3.png");
        int icon22_width=2700;
        int icon22_height=120;
        try {
            Thumbnails.of(new File("src/image/banner3.png"))
                    .size((int)(icon22_width*width_r), (int)(icon22_height*height_r))
                    .toFile(new File("src/image/banner3_min.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        l15.setIcon(new ImageIcon("src/image/banner3_min.png"));
        l15.setBounds((int)(20*width_r), (int)(35*height_r), (int) (icon22_width*width_r), (int) (icon22_height*height_r));
        fc_panel.add(l15);


        //上侧背景
        JPanel p2 = new JPanel();
        p2.setBounds(0, 0, (int) (1800*width_r), (int) (125*height_r));
        if(color_switch){
            p2.setBackground(new Color(245,245,245));
        }else{
            p2.setBackground(new Color(50,50,50));
        }
        fc_panel.add(p2);

        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);
    }
}
