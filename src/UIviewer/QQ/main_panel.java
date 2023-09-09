package UIviewer.QQ;

import DAO.QICQ.Friend;
import UIhandler.Library.Client_library;
import UIhandler.QICQ.Client_qicq;
import UIviewer.Library.readLib;
import UIviewer.login.functionChoose;
import UIviewer.status_manage.RoundJButton;
import message.Message;
import message.MessageType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import ClientToServer.myInfo;
import UIhandler.StatusManagement.Client_status.*;
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

import static ClientToServer.ClientToServer.oos;
import static UIviewer.login.functionChoose.jf;

/**
 * 主面板
 *
 * @author Zhangyang_Ge
 * @date 2022/09/03
 */


public class main_panel {
    public static JPanel mjp;
    public static JButton close_button;
    public HashMap<String, ArrayList<Friend>> friend;
    public static chat_panel cpn;
    static button_panel buttonPanel;
    public static RoundJButton color_choose=new RoundJButton();

    Color color1=new Color(31,66,71);
    Color color2=new Color(125,182,191);
    Color color3=new Color(111,150,134);
    Color color4=new Color(207,219,212);
    Font myfont1=new Font("等线", Font.BOLD, 17);
    Font myfont2=new Font("等线", Font.BOLD, 15);

    //buttonpanel放功能选择按钮
    //jsp主面板放buttonpanel
    /**
     * 主面板
     *
     * @param width  宽度
     * @param height 高度
     * @param type   类型
     * @throws IOException ioexception
     */
    public main_panel(int width, int height,int type,boolean color_switch1) throws IOException {
        jf.getJMenuBar().setBackground(color2);
        jf.getJMenuBar().getMenu(0).setForeground(color1);

        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        width=(int) screensize.getWidth(); //得到宽度
        height=(int) screensize.getHeight();//获得高度
        final boolean[] color_switch = {color_switch1};
        double width_r=(double)(width)/1920;
        double height_r=(double)(height)/1080;
        mjp=new JPanel();
        //设置屏幕大小、背景颜色
        mjp.setBounds(0,0,width,height);
        if(color_switch[0]){
            mjp.setBackground(new Color(255,255,255));
        }else{
            mjp.setBackground(new Color(0,0,0));
        }
        //设置绝对布局
        mjp.setLayout(null);

        if(type!=3){
            //侧边按钮面板
            buttonPanel=new button_panel();
            buttonPanel.setBounds((int)(width/6-width_r*100),(int)((height-310*height_r)),(int)(width_r*200),(int)(200*height_r));
            buttonPanel.setOpaque(false);
            //buttonPanel.setBounds((int)(175),(int)((height-135*height_r-100)),(int)(170*width_r+20),(int)(120+40*height_r));
            if(color_switch[0]){
                buttonPanel.setBackground(new Color(200,224,228));
            }else{
                buttonPanel.setBackground(new Color(68,84,105));
            }
            mjp.add(buttonPanel);

            //添加好友按钮
            JButton addFriend= new RoundJButton();
            addFriend.setFocusPainted(false);
            addFriend.setText("添加好友");
            addFriend.setBounds(5,10,(int)(170*width_r+10),(int)(40*height_r));
            if(color_switch[0]){
                addFriend.setBackground(new Color(125,182,191));
                addFriend.setForeground(Color.black);
            }else{
                addFriend.setBackground(new Color(42,52,65));
                addFriend.setForeground(Color.white);
            }
            addFriend.setFont(new Font("微软雅黑",Font.PLAIN,(int)(22*width_r)));
            addFriend.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    add_friend.add_friend();
                }
            });
            //
            buttonPanel.add(addFriend);
            //返回功能选择模块
            functionChoose.back_from_student_status=new RoundJButton();
            functionChoose.back_from_student_status.setFocusPainted(false);
            functionChoose.back_from_student_status.setText("返回功能选择");
            functionChoose.back_from_student_status.setBounds(5,60,(int)(170*width_r+10),(int)(40*height_r));
            if(color_switch[0]){
                functionChoose.back_from_student_status.setBackground(new Color(125,182,191));
                functionChoose.back_from_student_status.setForeground(Color.black);
            }else{
                functionChoose.back_from_student_status.setBackground(new Color(42,52,65));
                functionChoose.back_from_student_status.setForeground(Color.white);
            }
            functionChoose.back_from_student_status.setFont(new Font("微软雅黑",Font.PLAIN,(int)(22*width_r)));
            buttonPanel.add(functionChoose.back_from_student_status);
            functionChoose.back_from_student_status.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    functionChoose.jf.remove(functionChoose.jf.getContentPane());
                    functionChoose.jf.setContentPane(functionChoose.fc_panel);
                    functionChoose.jf.setTitle("functionChoose");
                    functionChoose.color_switch=!color_switch[0];
                    functionChoose.lswitch.doClick();
                }
            });
            //日夜切换按钮
            color_choose.setFocusPainted(false);
            color_choose.setBounds(5,110,(int)(170*width_r+10),(int)(40*height_r));
            if(color_switch[0]){
                color_choose.setText("日间");
                color_choose.setBackground(new Color(125,182,191));
                color_choose.setForeground(Color.black);
            }else{
                color_choose.setText("夜间");
                color_choose.setBackground(new Color(42,52,65));
                color_choose.setForeground(Color.white);
            }
            color_choose.setFont(new Font("微软雅黑",Font.PLAIN,(int)(22*width_r)));
            color_choose.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    color_switch[0] =!color_switch[0];
                    functionChoose.color_switch=color_switch[0];
                    if(color_switch[0]){
                        mjp.setBackground(new Color(255,255,255));
                        buttonPanel.setBackground(new Color(200,224,228));
                        addFriend.setBackground(new Color(125,182,191));
                        addFriend.setForeground(Color.black);
                        functionChoose.back_from_student_status.setBackground(new Color(125,182,191));
                        functionChoose.back_from_student_status.setForeground(Color.black);
                        color_choose.setText("日间");
                        color_choose.setBackground(new Color(125,182,191));
                        color_choose.setForeground(Color.black);
                        functionChoose.back_from_student_status.setBackground(new Color(125,182,191));
                        functionChoose.back_from_student_status.setForeground(Color.black);
                        friend_list.jPanel.setBorder(BorderFactory.createLineBorder(new Color(244,244,244)));
                        friend_list.jPanel.setBackground(new Color(255,255,255));
                        friend_list.roll_panel.setBackground(new Color(200,224,228));
                    }else{
                        mjp.setBackground(new Color(0,0,0));
                        buttonPanel.setBackground(new Color(68,84,105));
                        addFriend.setBackground(new Color(42,52,65));
                        addFriend.setForeground(Color.white);
                        functionChoose.back_from_student_status.setBackground(new Color(42,52,65));
                        functionChoose.back_from_student_status.setForeground(Color.white);
                        color_choose.setText("夜间");
                        color_choose.setBackground(new Color(42,52,65));
                        color_choose.setForeground(Color.white);
                        functionChoose.back_from_student_status.setBackground(new Color(42,52,65));
                        functionChoose.back_from_student_status.setForeground(Color.white);
                        friend_list.jPanel.setBackground(new Color(0,0,0));
                        friend_list.jPanel.setBorder(BorderFactory.createLineBorder(new Color(1,1,1)));
                        friend_list.roll_panel.setBackground(new Color(68,84,105));
                    }
                }
            });
            buttonPanel.add(color_choose);
        }
        else{
            //侧边按钮面板
            buttonPanel=new button_panel();
            buttonPanel.setBounds((int)(width/3-width_r*490),(int)((height-310*height_r)),(int)(width_r*200),(int)(200*height_r));
            //buttonPanel.setBounds((int)(width/3-width_r*200),(int)((height-500*height_r)),(int)(width_r*200),(int)(235*height_r));
            if(color_switch[0]){
                buttonPanel.setBackground(new Color(200,224,228));
            }else{
                buttonPanel.setBackground(new Color(68,84,105));
            }
            mjp.add(buttonPanel);
            //返回功能选择模块
            functionChoose.back_from_student_status=new RoundJButton();
            functionChoose.back_from_student_status.setFocusPainted(false);
            functionChoose.back_from_student_status.setText("返回功能选择");
            functionChoose.back_from_student_status.setBounds(5,60,(int)(170*width_r+10),(int)(40*height_r));
            if(color_switch[0]){
                functionChoose.back_from_student_status.setBackground(new Color(125,182,191));
                functionChoose.back_from_student_status.setForeground(Color.black);
            }else{
                functionChoose.back_from_student_status.setBackground(new Color(42,52,65));
                functionChoose.back_from_student_status.setForeground(Color.white);
            }
            functionChoose.back_from_student_status.setFont(new Font("微软雅黑",Font.PLAIN,(int)(22*width_r)));
            buttonPanel.add(functionChoose.back_from_student_status);
            functionChoose.back_from_student_status.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jf.getJMenuBar().setBackground(new Color(125,182,191));
                    jf.getJMenuBar().getMenu(0).setForeground(new Color(31,66,71));
                    functionChoose.jf.remove(functionChoose.jf.getContentPane());
                    functionChoose.jf.setContentPane(functionChoose.fc_panel);
                    functionChoose.jf.setTitle("functionChoose");
                }
            });
            //日夜切换按钮
            color_choose.setFocusPainted(false);
            color_choose.setBounds(5,110,(int)(170*width_r+10),(int)(40*height_r));
            if(color_switch[0]){
                color_choose.setText("日间");
                color_choose.setBackground(new Color(125,182,191));
                color_choose.setForeground(Color.black);
            }else{
                color_choose.setText("夜间");
                color_choose.setBackground(new Color(42,52,65));
                color_choose.setForeground(Color.white);
            }
            color_choose.setFont(new Font("微软雅黑",Font.PLAIN,(int)(22*width_r)));
            color_choose.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    color_switch[0] =!color_switch[0];
                    functionChoose.color_switch=color_switch[0];
                    if(color_switch[0]){
                        mjp.setBackground(new Color(255,255,255));
                        buttonPanel.setBackground(new Color(200,224,228));
                        functionChoose.back_from_student_status.setBackground(new Color(125,182,191));
                        functionChoose.back_from_student_status.setForeground(Color.black);
                        color_choose.setText("日间");
                        color_choose.setBackground(new Color(125,182,191));
                        color_choose.setForeground(Color.black);
                        buttonPanel.setBackground(new Color(200,224,228));
                        functionChoose.back_from_student_status.setBackground(new Color(125,182,191));
                        functionChoose.back_from_student_status.setForeground(Color.black);
                        friend_list.jPanel.setBorder(BorderFactory.createLineBorder(new Color(244,244,244)));
                        friend_list.jPanel.setBackground(new Color(255,255,255));
                        friend_list.roll_panel.setBackground(new Color(200,224,228));
                    }else{
                        mjp.setBackground(new Color(0,0,0));
                        buttonPanel.setBackground(new Color(68,84,105));
                        functionChoose.back_from_student_status.setBackground(new Color(42,52,65));
                        functionChoose.back_from_student_status.setForeground(Color.white);
                        color_choose.setText("夜间");
                        color_choose.setBackground(new Color(42,52,65));
                        color_choose.setForeground(Color.white);
                        buttonPanel.setBackground(new Color(68,84,105));
                        functionChoose.back_from_student_status.setBackground(new Color(42,52,65));
                        functionChoose.back_from_student_status.setForeground(Color.white);
                        friend_list.jPanel.setBackground(new Color(0,0,0));
                        friend_list.jPanel.setBorder(BorderFactory.createLineBorder(new Color(1,1,1)));
                        friend_list.roll_panel.setBackground(new Color(68,84,105));
                    }
                }
            });
            buttonPanel.add(color_choose);
        }

        /*
        //导航条
        JPanel guide =new JPanel();
        //学籍管理
        JButton btnNewButton_1 = new JButton("学籍管理");
        btnNewButton_1.setFocusPainted(false);
        guide.add(btnNewButton_1);
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
        //图书管理
        JButton btnNewButton_2 = new JButton("图书管理");
        btnNewButton_2.setFocusPainted(false);
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionChoose.jf.remove(mjp);
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
        guide.add(btnNewButton_2);
        //校园超市
        JButton btnNewButton_3 = new JButton("校园超市");
        btnNewButton_3.setFocusPainted(false);
        btnNewButton_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    if(myInfo.getType()!=3)
                    {
                        Client_shop.setId(String.valueOf(myInfo.getType()));
                        Client_shop.setIdcard(myInfo.getId());
                        functionChoose.jf.setContentPane(new shopCustomer());
                        functionChoose.jf.setTitle("shopCustomer");
                    }
                    else
                    {
                        Client_shop.setId(String.valueOf(myInfo.getType()));
                        Client_shop.setIdcard(myInfo.getId());
                        functionChoose.jf.setContentPane(new shopAdmin());
                        functionChoose.jf.setTitle("shopAdmin");
                    }
                    functionChoose.jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    functionChoose.jf.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        guide.add(btnNewButton_3);
        //选课系统
        JButton btnNewButton_4 = new JButton("选课系统");
        btnNewButton_4.setFocusPainted(false);
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
        guide.add(btnNewButton_4);
        //敬请期待
        JButton btnNewButton_7 = new JButton("敬请期待");
        btnNewButton_7.setFocusPainted(false);
        btnNewButton_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JOptionPane.showMessageDialog(null,"正在开发中，敬请期待！");
            }
        });
        guide.add(btnNewButton_7);
        //导航条
        guide.setBounds(200,0,700,20);
        mjp.add(guide);

         */
        //好友列表
        Client_qicq.Require_friend_list();
        friend_list friend_list_panel=new friend_list(width/3,height,width_r,height_r,0,0, color_switch[0]);
        mjp.add(friend_list_panel.jPanel);
        friend_list_panel.jPanel.setVisible(true);
        functionChoose.back_from_student_status.setVisible(false);
        functionChoose.back_from_student_status.setVisible(true);
        mjp.updateUI();
        //mjp.setLayout(null);
    }
}
