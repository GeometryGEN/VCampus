package UIviewer.status_manage;

import ClientToServer.ClientToServer;
import DAO.StatusManagement.ImageAndTable;
import UIhandler.Library.Client_library;
import UIhandler.QICQ.Client_qicq;
import UIhandler.Shop.Client_shop;
import UIhandler.StatusManagement.Client_status;
import UIviewer.Library.readLib;
import UIviewer.QQ.main_panel;
import UIviewer.SelectCourse.Selcourse;
import UIviewer.SelectCourse.Selcourse_director;
import UIviewer.SelectCourse.Selcourse_teacher;
import UIviewer.Shopping.shopAdmin;
import UIviewer.Shopping.shopCustomer;
import UIviewer.login.functionChoose;
import User.Student;
import net.coobird.thumbnailator.Thumbnails;
import ClientToServer.ManageClientToServerThread;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import ClientToServer.myInfo;
import UIviewer.login.functionChoose.*;

/**
 * 学生地位
 *
 * @author Zhangyang_Ge
 * @date 2022/09/03
 */
public class student_status extends JPanel {

    public static boolean color_switch=true;
    static JPanel status = new JPanel();
    final static JButton lswitch = new JButton();
    static JLabel name_label=new JLabel();
    static JPanel basicInformation_table;
            //= new student_status_table(width_r, height_r, width - (icon1_width + 60) * width_r, height - 140 * height_r, iat.student,color_switch);
    //
    /**
     * 状态面板
     *
     * @param width_r  宽度r
     * @param height_r 高r
     * @param width    宽度
     * @param height   高度
     * @param iat      iat
     * @return {@link JPanel}
     * @throws Exception 异常
     *///信息面板
    public static JPanel status_panel(double width_r, double height_r, double width, double height, ImageAndTable iat) throws Exception {

        if(color_switch){
        status.setBackground(new Color(200,224,228));}
        else{
            status.setBackground(new Color(68,84,105));
            }
        status.setBorder(BorderFactory.createEtchedBorder());//使用组件的当前背景颜色创建具有“蚀刻”外观的边框，以突出显示和着色
        status.setLayout(null);//设置绝对布局
        //个人照片
        JLabel image = new JLabel();
        int icon1_width = 160;
        int icon1_height = 320;
        String IDcard = iat.student.getStudent_idcard();
        //    Client_status.setId(myInfo.getId());  //否则查找学生，id为自身的，识别线程
        //Client_status.getphoto(IDcard);
        if (iat.image != null) {
            FileOutputStream fileOutputStream = new FileOutputStream("src/image/status/" + IDcard + ".jpg");
            fileOutputStream.write(iat.image);
            try {
                Thumbnails.of(new File("src/image/status/" + IDcard + ".jpg"))
                        .size((int) (icon1_width * width_r), (int) (icon1_height * width_r))
                        .toFile(new File("src/image/status/" + IDcard + "_min.jpg"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            image.setIcon(new ImageIcon("src/image/status/" + IDcard + "_min.jpg"));
        }
        status.add(image);
        image.setBounds((int) (40 * width_r), (int) (145 * height_r), (int) (icon1_width * width_r), (int) (icon1_height * height_r));
        //头像下名字
        String name = iat.student.getStudent_name();
        name_label.setText(name);
        name_label.setHorizontalAlignment(SwingConstants.CENTER);
       // JLabel name_label = new JLabel(name, JLabel.CENTER);
        name_label.setBounds((int) (57 * width_r), (int) ((155 + icon1_height) * height_r), (int) (110 * width_r), (int) (45 * height_r));
        Font name_font = new Font("微软雅黑", Font.PLAIN, (int) (26 * width_r));
        name_label.setFont(name_font);
        if(color_switch)
        {
            name_label.setForeground(new Color(0, 0, 0));
        }else {
            name_label.setForeground(new Color(255,255,255));
        }
        status.add(name_label);

        //添加基本信息表格
       // JPanel
        basicInformation_table = new student_status_table(width_r, height_r, width - (icon1_width + 60) * width_r, height - 140 * height_r, iat.student,color_switch);
        //JPanel basicInformation_table = new student_status_table(width_r, height_r, width - (icon1_width + 60) * width_r, height - 140 * height_r, iat.student);
        basicInformation_table.setBounds((int) ((icon1_width + 60) * width_r), (int) (85 * height_r), (int) (width - (icon1_width + 100) * width_r), (int) (height - 140 * height_r));
        status.add(basicInformation_table);
//        JPanel  statusInformation_table=new student_status_table(width_r,height_r,width-(icon1_width+60)*width_r,height-140*height_r,iat.student);
//        statusInformation_table.setBounds((int)((icon1_width+60)*width_r),(int)(85*height_r), (int)(width-(icon1_width+100)*width_r),(int)(height-140*height_r));
//        status.add(statusInformation_table);

        if(color_switch){
            lswitch.setText("日间");
        }else{
            lswitch.setText("夜间");
        }
//        Font myfont2 = new Font("微软雅黑", Font.PLAIN, (int) (12*width_r));
//        lswitch.setBounds((int)(40*width_r),(int)(700*height_r),(int)(150*width_r),(int)(50*height_r));
//        lswitch.setFont(myfont2);
//        if(student_status.color_switch){
//            lswitch.setBackground(new Color(200,224,228));
//            lswitch.setForeground(new Color(0,0,0));
//        }else{
//            lswitch.setBackground(new Color(68,84,105));
//            lswitch.setForeground(new Color(255,255,255));
//        }
//        lswitch.setContentAreaFilled(true);
//        lswitch.setFocusPainted(false);
//        status.add(lswitch);
//        lswitch.addActionListener((e)->{
//            color_switch=!color_switch;
//            if(color_switch){
//
//                name_label.setForeground(new Color(0, 0, 0));
//                lswitch.setText("日间");
//                lswitch.setBackground(new Color(200,224,228));
//                lswitch.setForeground(new Color(0,0,0));
//            }
//            else{
//                status.setBackground(new Color(68,84,105));
//                name_label.setForeground(new Color(255,255,255));
//                lswitch.setText("夜间");
//                lswitch.setBackground(new Color(68,84,105));
//                lswitch.setForeground(new Color(255,255,255));
//            }
//        });

        return status;
    }

    /**
     * 学生地位
     *
     * @param width  宽度
     * @param height 高度
     * @param iat    iat
     * @throws Exception 异常
     */
//    public student_status(int width, int height, ImageAndTable iat,boolean color_switch) throws Exception {
    public student_status(int width, int height, ImageAndTable iat) throws Exception {
        double width_r = (double) (width) / 1920;
        double height_r = (double) (height) / 1080;
        //设置屏幕大小、背景颜色
        setBounds(0, 0, width, height);
        if(color_switch)
        {
            setBackground(new Color(200,224,228));
        }
        else{
            setBackground(new Color(68,84,105));
        }
        //设置绝对布局
        setLayout(null);
/*
        //导航条
        JPanel guide=new JPanel();

            //学籍管理
            JButton btnNewButton_1 = new JButton("学籍管理");
            btnNewButton_1.setFocusPainted(false);
            guide.add(btnNewButton_1);
            btnNewButton_1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    functionChoose.jf.remove(status);
                    functionChoose.jf.setContentPane(functionChoose.fc_panel);
                }
            });

            //图书管理
            JButton btnNewButton_2 = new JButton("图书管理");
            btnNewButton_2.setFocusPainted(false);
            btnNewButton_2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    functionChoose.jf.remove(status);
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
            //站内通信
            JButton btnNewButton_5 = new JButton("站内通信");
            btnNewButton_5.setFocusPainted(false);
            btnNewButton_5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    functionChoose.jf.remove(status);
                    try {
                        Client_qicq.setId(myInfo.getId());
                        if(myInfo.getType()!=3)
                        {
                            functionChoose.jf.setContentPane(new main_panel(width,height,myInfo.getType(),true).mjp);
                            functionChoose.jf.setTitle("userqq");
                        }
                        else
                        {
                            functionChoose.jf.setContentPane(new main_panel(width,height,myInfo.getType(),true).mjp);
                            functionChoose.jf.setTitle("adminqq");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            guide.add(btnNewButton_5);
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
            add(guide);
            */

        //SEU logo
        JLabel logo = new JLabel();
        int icon1_width = 160;
        int icon1_height = 50;
        try {
            Thumbnails.of(new File("src/image/student_manage_logo.png"))
                    .size((int) (icon1_width * width_r), (int) (icon1_height * width_r))
                    .toFile(new File("src/image/student_manage_logo_min.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logo.setIcon(new ImageIcon("src/image/student_manage_logo_min.png"));
        add(logo);
        logo.setBounds((int) (30 * width_r), (int) (5 * height_r), (int) (icon1_width * width_r), (int) (icon1_height * height_r));
        //标题
        JLabel title = new JLabel("学生基本信息");
        title.setBounds((int) ((40 + icon1_width) * width_r), (int) (3 * height_r), (int) (300 * width_r), (int) (icon1_height * height_r));
        Font title_font = new Font("微软雅黑", Font.BOLD, (int) (31 * width_r));
        title.setFont(title_font);
        if(color_switch){
            title.setForeground(new Color(0,0,0));
        }else{
            title.setForeground(new Color(255,255,255));
        }

        add(title);

        //信息面板
        JPanel status_jpanel = status_panel(width_r, height_r, width - 2 * (60 + icon1_width) * width_r, (1080 - 70 - icon1_height) * height_r, iat);
        status_jpanel.setBounds((int) ((60 + icon1_width) * width_r), (int) ((47 + icon1_height) * height_r), (int) (width - 2 * (60 + icon1_width) * width_r), (int) ((1080 - 70 - icon1_height) * height_r));
        add(status_jpanel);

        //信息面板上透明条
        JPanel white_front_slice = new JPanel();
        if(color_switch) {
            white_front_slice.setBackground(new Color(164,204,210));
        }else{
            white_front_slice.setBackground(new Color(106,113,122));
        }
        white_front_slice.setBounds((int) ((90 + icon1_width) * width_r), (int) ((7 + icon1_height) * height_r), (int) (width - 2 * (90 + icon1_width) * width_r), (int) (40 * height_r));
        add(white_front_slice);
        white_front_slice.setLayout(null);//设置绝对布局
        //文字
        JLabel front_title = new JLabel("学生基本信息");
        front_title.setBounds((int) (20 * width_r), (int) (0 * height_r), (int) (300 * width_r), (int) (40 * height_r));
        Font front_title_font = new Font("微软雅黑", Font.PLAIN, (int) (19 * width_r));
        front_title.setFont(front_title_font);
        if(color_switch) {
            front_title.setForeground(new Color(240, 241, 249));
        }else {
            front_title.setForeground(new Color(15,15,6));
        }
        white_front_slice.add(front_title);
        Font myfont2 = new Font("微软雅黑", Font.PLAIN, (int) (12*width_r));
        lswitch.setBounds((int)(40*width_r),(int)(700*height_r),(int)(150*width_r),(int)(50*height_r));
        lswitch.setFont(myfont2);
        if(student_status.color_switch){
            lswitch.setBackground(new Color(200,224,228));
            lswitch.setForeground(new Color(0,0,0));
        }else{
            lswitch.setBackground(new Color(68,84,105));
            lswitch.setForeground(new Color(255,255,255));
        }
        lswitch.setContentAreaFilled(true);
        lswitch.setFocusPainted(false);
        add(lswitch);
        //上方蓝色背景
        JPanel blue_back = new JPanel();
        if(color_switch){
            blue_back.setBackground(new Color(125,182,191));
        }else {
            blue_back.setBackground(new Color(42,52,65));
        }
        blue_back.setBounds(0, 0, width, height * 3/ 5);
        add(blue_back);
        lswitch.addActionListener((e)->{
            color_switch=!color_switch;
            if(color_switch){
                status.setBackground(new Color(200,224,228));
                setBackground(new Color(200,224,228));
                lswitch.setText("日间");
                lswitch.setBackground(new Color(200,224,228));
                lswitch.setForeground(new Color(0,0,0));
                title.setForeground(new Color(0,0,0));
                white_front_slice.setBackground(new Color(164,204,210));
                front_title.setForeground(new Color(240, 241, 249));
                blue_back.setBackground(new Color(125,182,191));
                name_label.setForeground(new Color(0, 0, 0));
               // student_status_table.text.setBackground(new Color(200,200,200));
                student_status_table.title_label1.setForeground(new Color(102,102,102));
                student_status_table.title_label2.setForeground(new Color(102, 102, 102));
                student_status_table.text1.setBackground(new Color(200,200,200));
                student_status_table.text1.setForeground(new Color(51, 51, 51));
                student_status_table.text3.setBackground(new Color(200,200,200));
                student_status_table.text3.setForeground(new Color(51, 51, 51));
                student_status_table.text5.setBackground(new Color(200,200,200));
                student_status_table.text5.setForeground(new Color(51, 51, 51));
                student_status_table.text7.setBackground(new Color(200,200,200));
                student_status_table.text7.setForeground(new Color(51, 51, 51));
                student_status_table.text9.setBackground(new Color(200,200,200));
                student_status_table.text9.setForeground(new Color(51, 51, 51));
                student_status_table.text11.setBackground(new Color(200,200,200));
                student_status_table.text11.setForeground(new Color(51, 51, 51));
                student_status_table.text13.setBackground(new Color(200,200,200));
                student_status_table.text13.setForeground(new Color(51, 51, 51));
                student_status_table.text15.setBackground(new Color(200,200,200));
                student_status_table.text15.setForeground(new Color(51, 51, 51));
                student_status_table.text17.setBackground(new Color(200,200,200));
                student_status_table.text17.setForeground(new Color(51, 51, 51));
                student_status_table.text19.setBackground(new Color(200,200,200));
                student_status_table.text19.setForeground(new Color(51, 51, 51));
                student_status_table.text21.setBackground(new Color(200,200,200));
                student_status_table.text21.setForeground(new Color(51, 51, 51));
                student_status_table.text23.setBackground(new Color(200,200,200));
                student_status_table.text23.setForeground(new Color(51, 51, 51));
                student_status_table.text25.setBackground(new Color(200,200,200));
                student_status_table.text25.setForeground(new Color(51, 51, 51));
                student_status_table.text27.setBackground(new Color(200,200,200));
                student_status_table.text27.setForeground(new Color(51, 51, 51));
                student_status_table.text29.setBackground(new Color(200,200,200));
                student_status_table.text29.setForeground(new Color(51, 51, 51));
                student_status_table.text31.setBackground(new Color(200,200,200));
                student_status_table.text31.setForeground(new Color(51, 51, 51));
                student_status_table.text2.setBackground(new Color(200,224,228));
                student_status_table.text2.setForeground(new Color(51, 51, 51));
                student_status_table.text4.setBackground(new Color(200,224,228));
                student_status_table.text4.setForeground(new Color(51, 51, 51));
                student_status_table.text6.setBackground(new Color(200,224,228));
                student_status_table.text6.setForeground(new Color(51, 51, 51));
                student_status_table.text8.setBackground(new Color(200,224,228));
                student_status_table.text8.setForeground(new Color(51, 51, 51));
                student_status_table.text10.setBackground(new Color(200,224,228));
                student_status_table.text10.setForeground(new Color(51, 51, 51));
                student_status_table.text12.setBackground(new Color(200,224,228));
                student_status_table.text12.setForeground(new Color(51, 51, 51));
                student_status_table.text14.setBackground(new Color(200,224,228));
                student_status_table.text14.setForeground(new Color(51, 51, 51));
                student_status_table.text16.setBackground(new Color(200,224,228));
                student_status_table.text16.setForeground(new Color(51, 51, 51));
                student_status_table.text18.setBackground(new Color(200,224,228));
                student_status_table.text18.setForeground(new Color(51, 51, 51));
                student_status_table.text20.setBackground(new Color(200,224,228));
                student_status_table.text20.setForeground(new Color(51, 51, 51));
                student_status_table.text22.setBackground(new Color(200,224,228));
                student_status_table.text22.setForeground(new Color(51, 51, 51));
                student_status_table.text24.setBackground(new Color(200,224,228));
                student_status_table.text24.setForeground(new Color(51, 51, 51));
                student_status_table.text26.setBackground(new Color(200,224,228));
                student_status_table.text26.setForeground(new Color(51, 51, 51));
                student_status_table.text28.setBackground(new Color(200,224,228));
                student_status_table.text28.setForeground(new Color(51, 51, 51));
                student_status_table.text30.setBackground(new Color(200,224,228));
                student_status_table.text30.setForeground(new Color(51, 51, 51));
                student_status_table.text32.setBackground(new Color(200,224,228));
                student_status_table.text32.setForeground(new Color(51, 51, 51));
                basicInformation_table. setBackground(new Color(200,224,228));


            }
            else{
                status.setBackground(new Color(68,84,105));
                setBackground(new Color(68,84,105));
                lswitch.setText("夜间");
                lswitch.setBackground(new Color(68,84,105));
                lswitch.setForeground(new Color(255,255,255));
                title.setForeground(new Color(255,255,255));
                white_front_slice.setBackground(new Color(106,113,122));
                front_title.setForeground(new Color(15,15,6));
                blue_back.setBackground(new Color(42,52,65));
                name_label.setForeground(new Color(255,255,255));
                student_status_table.text1.setBackground(new Color(100,108,114));
                student_status_table.text1.setForeground(new Color(204,204,204));
                student_status_table.text3.setBackground(new Color(100,108,114));
                student_status_table.text3.setForeground(new Color(204,204,204));
                student_status_table.text5.setBackground(new Color(100,108,114));
                student_status_table.text5.setForeground(new Color(204,204,204));
                student_status_table.text7.setBackground(new Color(100,108,114));
                student_status_table.text7.setForeground(new Color(204,204,204));
                student_status_table.text9.setBackground(new Color(100,108,114));
                student_status_table.text9.setForeground(new Color(204,204,204));
                student_status_table.text11.setBackground(new Color(100,108,114));
                student_status_table.text11.setForeground(new Color(204,204,204));
                student_status_table.text13.setBackground(new Color(100,108,114));
                student_status_table.text13.setForeground(new Color(204,204,204));
                student_status_table.text15.setBackground(new Color(100,108,114));
                student_status_table.text15.setForeground(new Color(204,204,204));
                student_status_table.text17.setBackground(new Color(100,108,114));
                student_status_table.text17.setForeground(new Color(204,204,204));
                student_status_table.text19.setBackground(new Color(100,108,114));
                student_status_table.text19.setForeground(new Color(204,204,204));
                student_status_table.text21.setBackground(new Color(100,108,114));
                student_status_table.text21.setForeground(new Color(204,204,204));
                student_status_table.text23.setBackground(new Color(100,108,114));
                student_status_table.text23.setForeground(new Color(204,204,204));
                student_status_table.text25.setBackground(new Color(100,108,114));
                student_status_table.text25.setForeground(new Color(204,204,204));
                student_status_table.text27.setBackground(new Color(100,108,114));
                student_status_table.text27.setForeground(new Color(204,204,204));
                student_status_table.text29.setBackground(new Color(100,108,114));
                student_status_table.text29.setForeground(new Color(204,204,204));
                student_status_table.text31.setBackground(new Color(100,108,114));
                student_status_table.text31.setForeground(new Color(204,204,204));
                student_status_table.text2.setBackground(new Color(68,84,105));
                student_status_table.text2.setForeground(new Color(204,204,204));
                student_status_table.text4.setBackground(new Color(68,84,105));
                student_status_table.text4.setForeground(new Color(204,204,204));
                student_status_table.text6.setBackground(new Color(68,84,105));
                student_status_table.text6.setForeground(new Color(204,204,204));
                student_status_table.text8.setBackground(new Color(68,84,105));
                student_status_table.text8.setForeground(new Color(204,204,204));
                student_status_table.text10.setBackground(new Color(68,84,105));
                student_status_table.text10.setForeground(new Color(204,204,204));
                student_status_table.text12.setBackground(new Color(68,84,105));
                student_status_table.text12.setForeground(new Color(204,204,204));
                student_status_table.text14.setBackground(new Color(68,84,105));
                student_status_table.text14.setForeground(new Color(204,204,204));
                student_status_table.text16.setBackground(new Color(68,84,105));
                student_status_table.text16.setForeground(new Color(204,204,204));
                student_status_table.text18.setBackground(new Color(68,84,105));
                student_status_table.text18.setForeground(new Color(204,204,204));
                student_status_table.text20.setBackground(new Color(68,84,105));
                student_status_table.text20.setForeground(new Color(204,204,204));
                student_status_table.text22.setBackground(new Color(68,84,105));
                student_status_table.text22.setForeground(new Color(204,204,204));
                student_status_table.text24.setBackground(new Color(68,84,105));
                student_status_table.text24.setForeground(new Color(204,204,204));
                student_status_table.text26.setBackground(new Color(68,84,105));
                student_status_table.text26.setForeground(new Color(204,204,204));
                student_status_table.text28.setBackground(new Color(68,84,105));
                student_status_table.text28.setForeground(new Color(204,204,204));
                student_status_table.text30.setBackground(new Color(68,84,105));
                student_status_table.text30.setForeground(new Color(204,204,204));
                student_status_table.text32.setBackground(new Color(68,84,105));
                student_status_table.text32.setForeground(new Color(204,204,204));
                basicInformation_table.setBackground(new Color(68,84,105));


                student_status_table.title_label1.setForeground(new Color(170,170,170));
                student_status_table.title_label2.setForeground(new Color(170,170,170));

            }
        });

    }

}


