package UIviewer.Library;
import ClientToServer.ClientToServer;
import UIhandler.Library.Client_library;
import UIviewer.login.functionChoose;
import net.coobird.thumbnailator.Thumbnails;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import ClientToServer.myInfo;
import UIhandler.Library.Client_library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import UIhandler.QICQ.Client_qicq;
import UIhandler.Shop.Client_shop;
import UIhandler.StatusManagement.Client_status;
import UIviewer.QQ.main_panel;
import UIviewer.SelectCourse.Selcourse;
import UIviewer.SelectCourse.Selcourse_director;
import UIviewer.SelectCourse.Selcourse_teacher;
import UIviewer.Shopping.shopAdmin;
import UIviewer.Shopping.shopCustomer;
import UIviewer.login.LoginFrame;
import UIviewer.login.functionChoose;
import UIviewer.status_manage.manage_status;
import net.coobird.thumbnailator.Thumbnails;
import ClientToServer.myInfo;
import UIhandler.StatusManagement.Client_status.*;

import static UIviewer.login.functionChoose.jf;

/**
 * 管理员界面
 *
 * @author Liu Lewei
 * @date 2023/09/02
 */
public class adminLib extends JPanel {
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;
    static String name;
    public static JPanel panel = new JPanel();

    /**
     * 得到名字
     *
     * @param a 名字
     */
    static void getName(String a)
    {
        name=a;
    }
    public static CardLayout cardLayout=new CardLayout();

    /**
     * 管理员图书馆主界面
     */
    public adminLib(){
            String name=myInfo.getName();
            getName(name);
        functionChoose.jf.getJMenuBar().setBackground(new Color(68,84,105));
        functionChoose.jf.getJMenuBar().getMenu(0).setForeground(new Color(255,255,255));
        setBounds(0,0, (int) (1273*width_r), (int) (790*height_r));
        setLayout(null);
        panel.setBounds(0, (int) (150*height_r), (int) (1273*width_r), (int) (790*height_r));
        add(panel);
//		给主要显示面板添加布局方式
        panel.setLayout(cardLayout);
//		创建相应面板类的对象
        AllBooks f1=new AllBooks();`
//		将面板添加到住面板中，注意:add()方法里有两个参数，第一个是要添加的对象，第二个给这个对象所放置的卡片
//		起个名字，后面调用显示的时候要用到这个名字
        panel.add(f1,"f1");
        AddDeleteBook f2=new AddDeleteBook();
        panel.add(f2,"f2");
        giveTicket f3=new giveTicket();
        panel.add(f3,"f3");


        //图书馆标志与背景
        JLabel logo = new JLabel();
        ImageIcon icon = new ImageIcon("src/image/logonew.png");
            int icon1_width= 600;
            int icon1_height=75;
            try {
                Thumbnails.of(new File("src/image/logonew.png"))
                        .size((int)(icon1_width*width_r), (int)(icon1_height*height_r))
                        .toFile(new File("src/image/logonew_min.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            logo.setIcon(new ImageIcon("src/image/logonew_min.png"));
        logo.setBounds((int) (30*width_r), (int) (10*height_r), (int) (600*width_r), (int) (75*height_r));
        add(logo);

//        JPanel guide =new JPanel();
//        //学籍管理
//        JButton btnNewButton_1 = new JButton("学籍管理");
//        btnNewButton_1.setFocusPainted(false);
//        guide.add(btnNewButton_1);
//        btnNewButton_1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
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
//        //校园超市
//        JButton btnNewButton_3 = new JButton("校园超市");
//        btnNewButton_3.setFocusPainted(false);
//        btnNewButton_3.addActionListener(new ActionListener() {
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
//        guide.add(btnNewButton_3);
//        //选课系统
//        JButton btnNewButton_4 = new JButton("选课系统");
//        btnNewButton_4.setFocusPainted(false);
//        btnNewButton_4.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // TODO Auto-generated method stub
//                try {
//                    if(myInfo.getType()==1)
//                    {
//                        functionChoose.jf.setContentPane(new Selcourse());
//                        functionChoose.jf.setTitle("Selcourse");
//                    }
//                    else if(myInfo.getType()==2)
//                    {
//
//                        functionChoose.jf.setContentPane(new Selcourse_teacher());
//                        functionChoose.jf.setTitle("Selcourse_teacher");
//                    }
//                    else {
//                        functionChoose.jf.setContentPane(new Selcourse_director());
//                        functionChoose.jf.setTitle("Selcourse_director");
//                    }
//
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });
//        guide.add(btnNewButton_4);
//        //站内通信
//        JButton btnNewButton_5 = new JButton("站内通信");
//        btnNewButton_5.setFocusPainted(false);
//        btnNewButton_5.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                functionChoose.jf.remove(panel);
//                try {
//                    Client_qicq.setId(myInfo.getId());
//                    if(myInfo.getType()!=3)
//                    {
//                        functionChoose.jf.setContentPane(new main_panel(width,height,myInfo.getType(),true).mjp);
//                        functionChoose.jf.setTitle("userqq");
//                    }
//                    else
//                    {
//                        functionChoose.jf.setContentPane(new main_panel(width,height,myInfo.getType(),true).mjp);
//                        functionChoose.jf.setTitle("adminqq");
//                    }
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });
//        guide.add(btnNewButton_5);
//        //敬请期待
//        JButton btnNewButton_7 = new JButton("敬请期待");
//        btnNewButton_7.setFocusPainted(false);
//        btnNewButton_7.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // TODO Auto-generated method stub
//                JOptionPane.showMessageDialog(null,"正在开发中，敬请期待！");
//            }
//        });
//        guide.add(btnNewButton_7);
//        //导航条
//        guide.setBounds(0,0,500,500);
//        add(guide);

       //文字
            JLabel l1 = new JLabel("你好！"+name);
            l1.setBounds((int) (1100*width_r), (int) (30*height_r), (int) (200*width_r), (int) (55*height_r));
            l1.setForeground(new Color(248, 248, 255));
            Font font = new Font("楷体", Font.BOLD, (int) (20*width_r));
            l1.setFont(font);
            add(l1);

        //上方面板
        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, (int) (1280*width_r), (int) (100*height_r));
        p1.setBackground(new Color(42,52,65));
        add(p1);

        //按钮
        JButton b1=new JButton("查看图书状态");
        b1.setBounds((int) (0*width_r), (int) (100*height_r), (int) (200*width_r), (int) (50*height_r));
        Font myfont1 = new Font("微软雅黑", Font.BOLD, (int) (18*width_r));
        b1.setFont(myfont1);
        b1.setContentAreaFilled(false);//设置按钮透明
        b1.setFocusPainted(false);
        b1.setForeground(new Color(248, 248, 255));
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                try {
                    Client_library.RequireshowAllBooks();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                /*while(AllBooks.tableDate==null) ;
                AllBooks f5=new AllBooks();
                panel.add(f5,"f5");
                cardLayout.show(panel, "f5");*/
            }
        });
        add(b1);

        JButton b2=new JButton("录入/删除书籍");
        b2.setBounds((int) (200*width_r), (int) (100*height_r), (int) (200*width_r), (int) (50*height_r));
        b2.setFont(myfont1);
        b2.setContentAreaFilled(false);//设置按钮透明
        b2.setFocusPainted(false);
        b2.setForeground(new Color(248, 248, 255));
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                cardLayout.show(panel, "f2");
            }
        });
        add(b2);

        JButton b3=new JButton("开罚单");
        b3.setBounds((int) (400*width_r), (int) (100*height_r), (int) (200*width_r), (int) (50*height_r));
        b3.setFont(myfont1);
        b3.setContentAreaFilled(false);//设置按钮透明
        b3.setFocusPainted(false);
        b3.setForeground(new Color(248, 248, 255));
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                cardLayout.show(panel, "f3");
            }
        });
        add(b3);

        JButton b4=new JButton("退出图书馆");
        b4.setBounds((int) (1100*width_r), (int) (100*height_r), (int) (173*width_r), (int) (50*height_r));
        b4.setFont(myfont1);
        b4.setContentAreaFilled(false);//设置按钮透明
        b4.setFocusPainted(false);
        b4.setForeground(new Color(248, 248, 255));
        b4.setBorder(null);
            b4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    jf.getJMenuBar().setBackground(new Color(125,182,191));
                    //jf.getJMenuBar().getMenu(0).setForeground(Color.white);
                    functionChoose.jf.setContentPane(functionChoose.fc_panel);
                    functionChoose.jf.setTitle("functionChoose");
                    cardLayout.show(panel, "f1");
                }
            });
        add(b4);

        //按钮面板
        JPanel p2 = new JPanel();
        p2.setBounds(0, (int) (100*height_r), (int) (1280*width_r), (int) (50*height_r));
        p2.setBackground(new Color(68,84,105));
        add(p2);

    }
}