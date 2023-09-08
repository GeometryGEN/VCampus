package UIviewer.SelectCourse;
import ClientToServer.myInfo;
import UIhandler.Currirulum.Client_curriculum;
import UIhandler.Library.Client_library;
import UIhandler.QICQ.Client_qicq;
import UIhandler.Shop.Client_shop;
import UIhandler.StatusManagement.Client_status;
import UIviewer.Library.readLib;
import UIviewer.QQ.main_panel;
import UIviewer.Shopping.shopAdmin;
import UIviewer.Shopping.shopCustomer;
import UIviewer.login.functionChoose;
import UIviewer.status_manage.manage_status;
import net.coobird.thumbnailator.Thumbnails;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import UIhandler.StatusManagement.Client_status.*;
import UIviewer.status_manage.manage_status.*;
import UIviewer.login.functionChoose.*;


import static UIhandler.Currirulum.Client_curriculum.RequireallCourse;

/**
 * selcourse导演
 *
 * @author Chen_GuanZhi
 * @date 2022/09/03
 */
public class Selcourse_director extends JPanel {
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;
    static String name;
    public static CardLayout cardLayout=new CardLayout();
    public static JPanel panel=new JPanel();
    static void getName(String a)
    {
        name=a;
    }
    /**
     * selcourse导演
     */
    public Selcourse_director()
    {
        functionChoose.jf.getJMenuBar().setBackground(new Color(68,84,105));
        functionChoose.jf.getJMenuBar().getMenu(0).setForeground(new Color(255,255,255));
//        //导航条
//        JPanel guide=new JPanel();
//        //学籍管理
//        JButton btnNewButton_11 = new JButton("学籍管理");
//        btnNewButton_11.setFocusPainted(false);
//        guide.add(btnNewButton_11);
//        btnNewButton_11.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                functionChoose.jf.remove(panel);
//                if(myInfo.getType()==1) {
//                    try {
//                        Client_status.stu_enter();
//                    } catch (Exception ex) {
//                        throw new RuntimeException(ex);
//                    }
//                }
//                else if(myInfo.getType()==3){
//                    try {
//                        functionChoose.jf.setContentPane(new manage_status(width,height).manage_panel);
//                    } catch (Exception ex) {
//                        throw new RuntimeException(ex);
//                    }
//                    functionChoose.jf.setTitle("admin_status_management");
//                } else {
//                    JOptionPane.showMessageDialog(null,"抱歉，您暂无学籍管理权限！");
//                }
//            }
//        });
//        guide.add(btnNewButton_11);
//        //图书管理
//        JButton btnNewButton_22 = new JButton("图书管理");
//        btnNewButton_22.setFocusPainted(false);
//        btnNewButton_22.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                functionChoose.jf.remove(panel);
//                try {
//                    Client_qicq.setId(myInfo.getId());
//                    if(myInfo.getType()!=3)
//                    {
//                        functionChoose.jf.setContentPane(new readLib());
//                        functionChoose.jf.setTitle("readLib");
//                        functionChoose.jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                        functionChoose.jf.setVisible(true);
//                    }
//                    else
//                    {
//                        //Client_library.RequireshowAllBooks();
//                        Client_library.admin_enter();
//                        //jf.setContentPane(new adminLib());
//                        //jf.setTitle("adminLib");
//                        //jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                        //jf.setVisible(true);
//                    }
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });
//        guide.add(btnNewButton_22);
//        //校园超市
//        JButton btnNewButton_33 = new JButton("校园超市");
//        btnNewButton_33.setFocusPainted(false);
//        btnNewButton_33.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // TODO Auto-generated method stub
//                try {
//                    if(myInfo.getType()!=3)
//                    {
//                        Client_shop.setId(String.valueOf(myInfo.getType()));
//                        Client_shop.setIdcard(myInfo.getId());
//                        functionChoose.jf.setContentPane(new shopCustomer());
//                        functionChoose.jf.setTitle("shopCustomer");
//                    }
//                    else
//                    {
//                        Client_shop.setId(String.valueOf(myInfo.getType()));
//                        Client_shop.setIdcard(myInfo.getId());
//                        functionChoose.jf.setContentPane(new shopAdmin());
//                        functionChoose.jf.setTitle("shopAdmin");
//                    }
//                    functionChoose.jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                    functionChoose.jf.setVisible(true);
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });
//        guide.add(btnNewButton_33);
//        //站内通信
//        JButton btnNewButton_55 = new JButton("站内通信");
//        btnNewButton_55.setFocusPainted(false);
//        btnNewButton_55.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                functionChoose.jf.remove(panel);
//                try {
//                    Client_qicq.setId(myInfo.getId());
//                    if(myInfo.getType()!=3)
//                    {
//                        functionChoose.jf.setContentPane(new main_panel(width,height,myInfo.getType()).mjp);
//                        functionChoose.jf.setTitle("userqq");
//                    }
//                    else
//                    {
//                        functionChoose.jf.setContentPane(new main_panel(width,height,myInfo.getType()).mjp);
//                        functionChoose.jf.setTitle("adminqq");
//                    }
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });
//        guide.add(btnNewButton_55);
//        //敬请期待
//        JButton btnNewButton_77 = new JButton("敬请期待");
//        btnNewButton_77.setFocusPainted(false);
//        btnNewButton_77.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // TODO Auto-generated method stub
//                JOptionPane.showMessageDialog(null,"正在开发中，敬请期待！");
//            }
//        });
//        guide.add(btnNewButton_77);
//        //导航条
//        guide.setBounds(0,0,500,500);
//        add(guide);
        String name=myInfo.getName();
        getName(name);
        setBounds(0,0,(int)(1273*width_r),(int)(790*height_r));
        setLayout(null);
        panel.setBounds(0,(int)(150*height_r),(int)(1273*width_r),(int)(790*height_r));
        add(panel);
        panel.setLayout(cardLayout);

//        try {
//            RequireallCourse();
//        } catch (IOException ex) {
//            throw new RuntimeException(ex);
//        }

//        ConsultCourse_Info f3=new ConsultCourse_Info();
//        panel.add(f3,"f3");
        Scheduling f2=new Scheduling();
        panel.add(f2,"f2");
        Check_Course f1=new Check_Course();
        panel.add(f1,"f1");



        JLabel logo = new JLabel();
        ImageIcon icon = new ImageIcon("src/image/xuanke1_bg.png");
        int icon1_width= 600;
        int icon1_height=75;
        try {
            Thumbnails.of(new File("src/image/xuanke1_bg.png"))
                    .size((int)(icon1_width*width_r), (int)(icon1_height*height_r))
                    .toFile(new File("src/image/xuanke1_bgmin.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logo.setIcon(new ImageIcon("src/image/xuanke1_bgmin.png"));
        logo.setBounds((int) (30*width_r), (int) (10*height_r), (int) (600*width_r), (int) (75*height_r));
        add(logo);
        //文字
        JLabel l1 = new JLabel("你好！"+name);
        l1.setBounds((int) (1100*width_r), (int) (30*height_r), (int) (200*width_r), (int) (55*height_r));
        l1.setForeground(new Color(248, 248, 255));
        Font font = new Font("楷体", Font.BOLD, (int) (20*width_r));
        l1.setFont(font);
        add(l1);
        JPanel p1 = new JPanel();
        //上方面板
        p1.setBounds(0, 0, (int) (1279*width_r), (int) (100*height_r));
        p1.setBackground(new Color(42,52,65));
        add(p1);



        /*CurrentCourse_Man f3=new CurrentCourse_Man();
        panel.add(f3,"f3");*/


        Font myfont = new Font("微软雅黑 ", Font.BOLD, 18);


        // 按钮2
        JButton btnNewButton_2 = new JButton("排课");
        btnNewButton_2.setBounds((int)(0*width_r), (int)(100*height_r), (int)(160*width_r), (int)(50*height_r));
        btnNewButton_2.setFont(myfont);
        btnNewButton_2.setFocusPainted(false);
        btnNewButton_2.setForeground(new Color(220, 220, 220));
        btnNewButton_2.setContentAreaFilled(false);
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
        btnNewButton_4.setBounds((int)(160*width_r), (int)(100*height_r), (int)(160*width_r), (int)(50*height_r));
        btnNewButton_4.setFont(myfont);
        btnNewButton_4.setFocusPainted(false);
        btnNewButton_4.setForeground(new Color(220, 220, 220));
        btnNewButton_4.setContentAreaFilled(false);
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
        btnNewButton_5.setBounds((int) (1100*width_r), (int) (100*height_r), (int) (173*width_r), (int) (50*height_r));
        btnNewButton_5.setFont(myfont);
        btnNewButton_5.setFocusPainted(false);
        btnNewButton_5.setBackground(new Color(245, 222, 179));
        btnNewButton_5.setForeground(new Color(220, 220, 220));
        btnNewButton_5.setContentAreaFilled(false);
        btnNewButton_5.setBorder(null);
        btnNewButton_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionChoose.jf.setContentPane(functionChoose.fc_panel);
                functionChoose.jf.setTitle("functionChoose");
                setVisible(false);
            }
        });
        add(btnNewButton_5);


//        //东南大学标志图片
//        JLabel l15 = new JLabel();
//        ImageIcon icon6 = new ImageIcon("src/image/background2.jpg");
//        int icon6_width= 1273;
//        int icon6_height=790;
//        try {
//            Thumbnails.of(new File("src/image/background2.jpg"))
//                    .size((int)(icon6_width*width_r), (int)(icon6_height*height_r))
//                    .keepAspectRatio(false)
//                    .toFile(new File("src/image/background2_min.jpg"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        l15.setIcon(new ImageIcon("src/image/background2_min.jpg"));
//        l15.setBounds(0, 0, (int)(1273*width_r), (int)(790*height_r));
//        add(l15);
//        setVisible(true);
        //按钮面板
        JPanel p2 = new JPanel();
        p2.setBounds(0, (int) (100*height_r), (int) (1280*width_r), (int) (50*height_r));
        p2.setBackground(new Color(68,84,105));
        add(p2);
    }

}
