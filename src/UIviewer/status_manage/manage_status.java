package UIviewer.status_manage;

import ClientToServer.ClientToServer;
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
import net.coobird.thumbnailator.Thumbnails;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import ClientToServer.myInfo;

/**
 * 管理状态
 *
 * @author Zhangyang_Ge
 * @date 2022/09/03
 */
public class manage_status {
    static JButton jb_back_to_search;
    static public JPanel search_panel;
    static public JPanel status_jpanel;
    static public JPanel manage_panel;
    public static final JTextField search_text = new RoundJTextField(15);
    final static JButton lswitch = new JButton();
    public static boolean color_switch = true;
    static String name;

    //public static JPanel panel1=new JPanel();
    static void getName(String a) {
        name = a;
    }

    /**
     * 管理状态
     *
     * @param width  宽度
     * @param height 高度
     * @throws Exception 异常
     */
    public manage_status(int width, int height) throws Exception {
        String name = myInfo.getName();
        getName(name);
        manage_panel = new JPanel();
        double width_r = (double) (width) / 1273;
        double height_r = (double) (height) / 790;
        functionChoose.back_from_student_status = new RoundJButton();
        functionChoose.back_from_student_status.setText("退出学籍管理");
        functionChoose.back_from_student_status.setBounds((int) (1100 * width_r), (int) (100 * height_r), (int) (160 * width_r), (int) (50 * height_r));
        //functionChoose.back_from_student_status.setBackground(new Color(199,84,80));
        functionChoose.back_from_student_status.setForeground(new Color(0, 0, 0));
        functionChoose.back_from_student_status.setFont(new Font("微软雅黑", Font.PLAIN, (int) (18 * width_r)));
        manage_panel.add(functionChoose.back_from_student_status);
//        Font myfont2 = new Font("微软雅黑", Font.PLAIN, (int) (12 * width_r));
//        lswitch.setBounds((int) (40 * width_r), (int) (800 * height_r), (int) (150 * width_r), (int) (50 * height_r));
//        lswitch.setFont(myfont2);
//        if (color_switch) {
//            lswitch.setBackground(new Color(200, 224, 228));
//            lswitch.setForeground(new Color(0, 0, 0));
//        } else {
//            lswitch.setBackground(new Color(68, 84, 105));
//            lswitch.setForeground(new Color(255, 255, 255));
//        }
//        lswitch.setContentAreaFilled(true);
//        lswitch.setFocusPainted(false);
//        manage_panel.add(lswitch);

        functionChoose.back_from_student_status.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //  Client_status.resetS();
                functionChoose.jf.remove(manage_status.manage_panel);
                functionChoose.jf.setContentPane(functionChoose.fc_panel);
            }
        });
 //       if (color_switch) {
            JLabel logo = new JLabel();
            ImageIcon icon = new ImageIcon("src/image/xueji2_bg.png");
            int icon1_width = 600;
            int icon1_height = 75;
            try {
                Thumbnails.of(new File("src/image/xueji2_bg.png"))
                        .size((int) (icon1_width * width_r), (int) (icon1_height * height_r))
                        .toFile(new File("src/image/xueji2_bgmin.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            logo.setIcon(new ImageIcon("src/image/xueji2_bgmin.png"));
            logo.setBounds((int) (30 * width_r), (int) (10 * height_r), (int) (600 * width_r), (int) (75 * height_r));
            manage_panel.add(logo);
            //文字
            JLabel l1 = new JLabel("你好！" + name);
            l1.setBounds((int) (1100 * width_r), (int) (30 * height_r), (int) (200 * width_r), (int) (55 * height_r));
            l1.setForeground(new Color(7, 8, 9));
            Font font = new Font("楷体", Font.BOLD, (int) (20 * width_r));
            l1.setFont(font);
            manage_panel.add(l1);
            JPanel p1 = new JPanel();
            //上方面板
            p1.setBounds(0, 0, (int) (1279 * width_r), (int) (100 * height_r));
            p1.setBackground(new Color(125, 182, 191));
            manage_panel.add(p1);
            JPanel p2 = new JPanel();
            p2.setBounds(0, (int) (100 * height_r), (int) (1280 * width_r), (int) (50 * height_r));
            p2.setBackground(new Color(164, 204, 210));
            manage_panel.add(p2);
//        }else {
//            JLabel logo = new JLabel();
//            ImageIcon icon = new ImageIcon("src/image/xueji1_bg.png");
//            int icon1_width = 600;
//            int icon1_height = 75;
//            try {
//                Thumbnails.of(new File("src/image/xueji1_bg.png"))
//                        .size((int) (icon1_width * width_r), (int) (icon1_height * height_r))
//                        .toFile(new File("src/image/xueji1_bgmin.png"));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            logo.setIcon(new ImageIcon("src/image/xueji1_bgmin.png"));
//            logo.setBounds((int) (30 * width_r), (int) (10 * height_r), (int) (600 * width_r), (int) (75 * height_r));
//            manage_panel.add(logo);
//            //文字
//            JLabel l1 = new JLabel("你好！" + name);
//            l1.setBounds((int) (1100 * width_r), (int) (30 * height_r), (int) (200 * width_r), (int) (55 * height_r));
//            l1.setForeground(new Color(248, 248, 255));
//            Font font = new Font("楷体", Font.BOLD, (int) (20 * width_r));
//            l1.setFont(font);
//            manage_panel.add(l1);
//            JPanel p1 = new JPanel();
//            //上方面板
//            p1.setBounds(0, 0, (int) (1279 * width_r), (int) (100 * height_r));
//            p1.setBackground(new Color(42, 52, 65));
//            manage_panel.add(p1);
//            JPanel p2 = new JPanel();
//            p2.setBounds(0, (int) (100*height_r), (int) (1280*width_r), (int) (50*height_r));
//            p2.setBackground(new Color(68,84,105));
//            manage_panel.add(p2);
//        }

            //设置屏幕大小、背景颜色
            manage_panel.setBounds(0, 0, width, (int) (height_r * 800));
            // if(color_switch){
            manage_panel.setBackground(new Color(200, 224, 228));
//    }
//        else{
//            manage_panel.setBackground(new Color(68,84,105));
//        }
            // if(color_switch){
            functionChoose.jf.getJMenuBar().setBackground(new Color(125, 182, 191));
            functionChoose.jf.getJMenuBar().getMenu(0).setForeground(new Color(255, 255, 255));
            // }
//        else{
//            functionChoose.jf.getJMenuBar().setBackground(new Color(68,84,105));
//            functionChoose.jf.getJMenuBar().getMenu(0).setForeground(new Color(255,255,255));
//        }
            //设置绝对布局
            manage_panel.setLayout(null);
//        if(color_switch){
//            lswitch.setText("日间");
//        }else{
//            lswitch.setText("夜间");
//        }


            //SEU logo
//        JLabel logo = new JLabel();
            int icon1_width11 = 160;
            int icon1_height11 = 50;

//        try {
//            Thumbnails.of(new File("src/image/student_manage_logo.png"))
//                    .size((int)(icon1_width*width_r), (int)(icon1_height*width_r))
//                    .toFile(new File("src/image/student_manage_logo_min.png"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        logo.setIcon(new ImageIcon("src/image/student_manage_logo_min.png"));
//        manage_panel.add(logo);
//        logo.setBounds((int)(30*width_r),(int)(5*height_r),(int)(icon1_width*width_r),(int)(icon1_height*height_r));
//        //标题
//        JLabel title=new JLabel("学生基本信息管理");
//        title.setBounds((int)((40+icon1_width)*width_r), (int)(3*height_r), (int)(300*width_r), (int)(icon1_height*height_r));
//        Font title_font = new Font("微软雅黑", Font.BOLD, (int)(31*width_r));
//        title.setFont(title_font);
//        if(color_switch)
//        {
//            title.setForeground(new Color(0, 0, 0));
//        }else {
//            title.setForeground(new Color(255,255,255));
//        }
//        manage_panel.add(title);
            //搜索面板
            search_panel = new JPanel();
            // if(color_switch){
            search_panel.setBackground(new Color(200, 224, 228));
            //}
//        else{
//            search_panel.setBackground(new Color(68,84,105));
//        }
            search_panel.setBorder(BorderFactory.createEtchedBorder());
            search_panel.setLayout(null);//设置绝对布局
            search_panel.setBounds((int) ((60 + icon1_width11) * width_r), (int) ((47 + icon1_height) * height_r), (int) (width - 2 * (60 + icon1_width11) * width_r), (int) ((1080 - 70 - icon1_height) * height_r));
            manage_panel.add(search_panel);
            //图标
//        JLabel logo2=new JLabel();
            int icon2_width = 320;
            int icon2_height = 100;
//        try {
//            Thumbnails.of(new File("src/image/student_manage_logo.png"))
//                    .size((int)(icon2_width*width_r), (int)(icon2_height*width_r))
//                    .toFile(new File("src/image/student_manage_logo_mini.png"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        logo2.setIcon(new ImageIcon("src/image/student_manage_logo_mini.png"));
//        search_panel.add(logo2);
//        logo2.setBounds((int)((width-2*(60+icon1_width)*width_r)/2-icon2_width/2*width_r),(int)(200*height_r),(int)(icon2_width*width_r),(int)(icon2_height*height_r));
            //搜索框
            JLabel l11 = new JLabel("您正在对学籍信息进行查询！");
            JLabel l12 = new JLabel("请在下方输入您要查询的学籍信息！");
            Font font11 = new Font("宋体", Font.BOLD, 20);
            l11.setBounds((int) (350 * width_r), (int) (350 * height_r), (int) (500 * width_r), (int) (50 * height_r));
            search_panel.add(l11);
            l11.setFont(font11);
            l12.setFont(font11);
            l12.setBounds((int) (80 * width_r), (int) (250 * height_r), (int) (500 * width_r), (int) (50 * height_r));
            search_panel.add(l12);
            search_text.setBounds((int) (100 * width_r), (int) (300 * height_r), (int) (500 * width_r), (int) (50 * height_r));
            search_text.setFont(new Font("微软雅黑", Font.PLAIN, (int) (35 / 1.5 * width_r)));
            search_text.setHorizontalAlignment(JTextField.CENTER);
            search_text.addFocusListener(new JTextFieldHintListener(search_text, "请输入要查询学生的一卡通号"));
            search_panel.add(search_text);
//        JPanel p = new JPanel();
//        p.setBounds((int) (60*width_r), (int) (250*height_r), (int) (730*width_r), (int) (200*height_r));
//        p.setBackground(new Color(120,124,125,200 ));
//        search_panel.add(p);
            //搜索按钮
            JButton search_button = new RoundJButton();
            search_button.setText("查询");
            search_button.setBounds((int) (630 * width_r), (int) (300 * height_r), (int) (100 * width_r), (int) (50 * height_r));
            search_button.setBackground(new Color(220, 250, 230));
            search_button.setForeground(new Color(7, 8, 9));
            search_button.setFont(new Font("微软雅黑", Font.PLAIN, (int) (18 * width_r)));
            search_panel.add(search_button);
            search_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //学生信息视图
                    try {
                        Client_status.requireInfo(search_text.getText());
                        //  search_text.setHorizontalAlignment(JTextField.CENTER);
                        //search_text.addFocusListener(new JTextFieldHintListener(search_text, "请输入要查询学生的一卡通号"));
                    /*status_jpanel = student_status.status_panel(width_r,height_r,width-2*(60+icon1_width)*width_r,(1080-70-icon1_height)*height_r,search_text.getText());
                    status_jpanel.setBounds((int)((60+icon1_width)*width_r),(int)((47+icon1_height)*height_r), (int)(width-2*(60+icon1_width)*width_r),(int)((1080-70-icon1_height)*height_r));
                    add(status_jpanel,0);
                    search_panel.setVisible(false);
                    status_jpanel.setVisible(true);*/
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

            //返回功能选择模块


//        //信息面板上透明条
//        JPanel white_front_slice=new JPanel();
//        if(color_switch) {
//            white_front_slice.setBackground(new Color(164,204,210));
//        }else{
//            white_front_slice.setBackground(new Color(106,113,122));
//        }
//        white_front_slice.setBounds((int)((90+icon1_width)*width_r),(int)((7+icon1_height)*height_r), (int)(width-2*(90+icon1_width)*width_r),(int)(40*height_r));
//        manage_panel.add(white_front_slice);
//        white_front_slice.setLayout(null);//设置绝对布局
//        //文字
//        JLabel front_title=new JLabel("学生基本信息管理");
//        front_title.setBounds((int)(20*width_r), (int)(0*height_r), (int)(300*width_r), (int)(40*height_r));
//        Font front_title_font = new Font("微软雅黑", Font.PLAIN, (int)(19*width_r));
//        front_title.setFont(front_title_font);
//        if(color_switch){
//            front_title.setForeground(new Color(0,0,0));
//        }else{
//            front_title.setForeground(new Color(255,255,255));
//        }
//        white_front_slice.add(front_title);


            //上方蓝色背景
            JPanel blue_back = new JPanel();
            //  if(color_switch){
            blue_back.setBackground(new Color(125, 182, 191));
//        }else {
//            blue_back.setBackground(new Color(42,52,65));
//        }
            blue_back.setBounds(0, 0, width, height * 3 / 5);
            manage_panel.add(blue_back);
//        lswitch.addActionListener((e)->{
//            color_switch=!color_switch;
//            if(color_switch){
//                blue_back.setBackground(new Color(125,182,191));
//                manage_panel.setBackground(new Color(200,224,228));
//                lswitch.setText("日间");
//                lswitch.setBackground(new Color(200,224,228));
//                lswitch.setForeground(new Color(0,0,0));
//                //title.setForeground(new Color(0, 0, 0));
//                search_panel.setBackground(new Color(200,224,228));
////                white_front_slice.setBackground(new Color(164,204,210));
////                front_title.setForeground(new Color(0,0,0));
//                functionChoose.jf.getJMenuBar().setBackground(new Color(125,182,191));
//                functionChoose.jf.getJMenuBar().getMenu(0).setForeground(new Color(255,255,255));
//            }else{
//                manage_panel.setBackground(new Color(68,84,105));
//                lswitch.setText("夜间");
//                lswitch.setBackground(new Color(68,84,105));
//                lswitch.setForeground(new Color(255,255,255));
////                title.setForeground(new Color(255, 255, 255));
//                search_panel.setBackground(new Color(68,84,105));
//                blue_back.setBackground(new Color(42,52,65));
////                white_front_slice.setBackground(new Color(106,113,122));
////                front_title.setForeground(new Color(0,0,0));
//                functionChoose.jf.getJMenuBar().setBackground(new Color(68,84,105));
//                //functionChoose.jf.getJMenuBar().setOpaque(true);
//                functionChoose.jf.getJMenuBar().getMenu(0).setForeground(new Color(255,255,255));
//
//            }
//
//        });

        }

//    public static void main(String[] args) {
//        JFrame frame = new JFrame("manage_status");
//        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
//        int width=(int ) screensize.getWidth(); //得到宽度
//        int height=(int ) screensize.getHeight();//获得高度
//        frame.setBounds(0,0,width,height);
//        frame.setContentPane(new manage_status(ucs,width,height));
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//    }
    }

