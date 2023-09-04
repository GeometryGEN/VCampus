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

    /**
     * 主面板
     *
     * @param width  宽度
     * @param height 高度
     * @param type   类型
     * @throws IOException ioexception
     */
    public main_panel(int width, int height,int type) throws IOException {
        double width_r=(double)(width)/1920;
        double height_r=(double)(height)/1080;
        mjp=new JPanel();
        //设置屏幕大小、背景颜色
        mjp.setBounds(0,0,width,height);
        mjp.setBackground(new Color(255,255,255));
        //设置绝对布局
        mjp.setLayout(null);

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
        guide.setBounds(0,0,500,500);
        mjp.add(guide);

        if(type!=3){
            //侧边按钮面板
            buttonPanel=new button_panel();
            buttonPanel.setBounds((int)(width_r*1920/3+0),(int)((height-135*height_r)),(int)(170*width_r),(int)(400*height_r));
            mjp.add(buttonPanel);
            //添加好友按钮
            JButton addFriend= new RoundJButton();
            addFriend.setFocusPainted(false);
            addFriend.setText("   添加好友   ");
            addFriend.setBounds(0,-20,(int)(170*width_r),(int)(50*height_r));
            addFriend.setBackground(new Color(30,111,255));
            addFriend.setForeground(Color.white);
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
            functionChoose.back_from_student_status.setBounds(0,20,(int)(170*width_r),(int)(50*height_r));
            functionChoose.back_from_student_status.setBackground(new Color(96,190,41));
            functionChoose.back_from_student_status.setForeground(new Color(255,255,255));
            functionChoose.back_from_student_status.setFont(new Font("微软雅黑",Font.PLAIN,(int)(22*width_r)));
            buttonPanel.add(functionChoose.back_from_student_status);
            functionChoose.back_from_student_status.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    functionChoose.jf.remove(functionChoose.jf.getContentPane());
                    functionChoose.jf.setContentPane(functionChoose.fc_panel);
                    functionChoose.jf.setTitle("functionChoose");
                }
            });
        }
        else{
            //侧边按钮面板
            buttonPanel=new button_panel();
            buttonPanel.setBounds(0,0,(int)(170*width_r),(int)(400*height_r));
            mjp.add(buttonPanel);
            //返回功能选择模块
            functionChoose.back_from_student_status=new RoundJButton();
            functionChoose.back_from_student_status.setFocusPainted(false);
            functionChoose.back_from_student_status.setText("返回功能选择");
            functionChoose.back_from_student_status.setBounds(0,(int)(0*height_r),(int)(170*width_r),(int)(50*height_r));
            functionChoose.back_from_student_status.setBackground(new Color(96,190,41));
            functionChoose.back_from_student_status.setForeground(new Color(255,255,255));
            functionChoose.back_from_student_status.setFont(new Font("微软雅黑",Font.PLAIN,(int)(22*width_r)));
            buttonPanel.add(functionChoose.back_from_student_status);
            functionChoose.back_from_student_status.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    functionChoose.jf.remove(functionChoose.jf.getContentPane());
                    functionChoose.jf.setContentPane(functionChoose.fc_panel);
                    functionChoose.jf.setTitle("functionChoose");
                }
            });
        }

        //好友列表
        Client_qicq.Require_friend_list();
        friend_list friend_list_panel=new friend_list(1920/3,1080,width_r,height_r,0,0);
        mjp.add(friend_list_panel.jPanel);
        friend_list_panel.jPanel.setVisible(true);
        functionChoose.back_from_student_status.setVisible(false);
        functionChoose.back_from_student_status.setVisible(true);
        mjp.updateUI();
    }
}
