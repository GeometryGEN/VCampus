package UIviewer.status_manage;

import ClientToServer.ClientToServer;
import DAO.StatusManagement.ImageAndTable;
import UIhandler.Shop.Client_shop;
import UIhandler.StatusManagement.Client_status;
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

/**
 * 学生地位
 *
 * @author Zhangyang_Ge
 * @date 2022/09/03
 */
public class student_status extends JPanel {

    public static boolean color_switch=functionChoose.color_switch;
    static JPanel status = new JPanel();
    public static JButton lswitch = new JButton();
    static JLabel name_label=new JLabel();
    static JPanel basicInformation_table;
    static String name;
    static int icon1_width = 160;
    static int icon1_height = 320;
    //public static JPanel panel1=new JPanel();
    static void getName(String a)
    {
        name=a;
    }
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
        status.setBackground(new Color(200, 224, 228));
        }
        else{
            status.setBackground(new Color(68,84,105));
        }
        status.setBorder(BorderFactory.createEtchedBorder());//使用组件的当前背景颜色创建具有“蚀刻”外观的边框，以突出显示和着色
        status.setLayout(null);//设置绝对布局
        //个人照片
        JLabel image = new JLabel();
        String IDcard = iat.student.getStudent_idcard();
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
        basicInformation_table = new student_status_table(width_r, height_r, width - (icon1_width + 60) * width_r, height - 140 * height_r, iat.student, color_switch);
        basicInformation_table.setBounds((int) ((icon1_width + 60) * width_r), (int) (85 * height_r), (int) (width - (icon1_width + 100) * width_r), (int) (height - 140 * height_r));
        status.add(basicInformation_table);

        if(color_switch){
            lswitch.setText("日间");
        }else{
            lswitch.setText("夜间");
        }
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
        status.add(lswitch);
        lswitch.addActionListener((e)->{
            color_switch=!color_switch;
            if(color_switch){

                name_label.setForeground(new Color(0, 0, 0));
                lswitch.setText("日间");
               lswitch.setBackground(new Color(200,224,228));
               lswitch.setForeground(new Color(0,0,0));
            }
            else{
                status.setBackground(new Color(68,84,105));
                name_label.setForeground(new Color(255,255,255));
                lswitch.setText("夜间");
                lswitch.setBackground(new Color(68,84,105));
              lswitch.setForeground(new Color(255,255,255));
          }
       });

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
        final boolean[] color_switch = {functionChoose.color_switch};
        String name=myInfo.getName();
        getName(name);
        double width_r = (double) (width) / 1920;
        double height_r = (double) (height) / 1080;
        JLabel logo = new JLabel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JLabel l1 = new JLabel("你好！"+name);
        if(color_switch[0]){
            ImageIcon icon = new ImageIcon("src/image/xueji2_bg.png");
            int icon1_width= 900;
            int icon1_height=115;
            try {
                Thumbnails.of(new File("src/image/xueji2_bg.png"))
                        .size((int)(icon1_width*width_r), (int)(icon1_height*height_r))
                        .toFile(new File("src/image/xueji2_bgmin.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            logo.setIcon(new ImageIcon("src/image/xueji2_bgmin.png"));
            logo.setBounds((int) (45*width_r), (int) (15*height_r), (int) (900*width_r), (int) (113*height_r));
            add(logo);
            //文字
            l1.setBounds((int) (1650*width_r), (int) (40*height_r), (int) (300*width_r), (int) (83*height_r));
            l1.setForeground(new Color(7,8,9));
            Font font = new Font("楷体", Font.BOLD, (int) (30*width_r));
            l1.setFont(font);
            add(l1);
            //上方面板
            p1.setBounds(0, 0, (int) (1920*width_r), (int) (150*height_r));
            p1.setBackground(new Color(125,182,191));
            add(p1);
            p2.setBounds(0, (int) (100*height_r), (int) (1920*width_r), (int) (50*height_r));
            p2.setBackground(new Color(155,190,200));
            add(p2);
        }else {
            ImageIcon icon = new ImageIcon("src/image/xueji1_bg.png");
            int icon1_width = 900;
            int icon1_height = 115;
            try {
                Thumbnails.of(new File("src/image/xueji1_bg.png"))
                        .size((int) (icon1_width * width_r), (int) (icon1_height * height_r))
                       .toFile(new File("src/image/xueji1_bgmin.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            logo.setIcon(new ImageIcon("src/image/xueji1_bgmin.png"));
            logo.setBounds((int) (45*width_r), (int) (15*height_r), (int) (900*width_r), (int) (113*height_r));
            add(logo);
            //文字
           l1.setBounds((int) (1100 * width_r), (int) (30 * height_r), (int) (200 * width_r), (int) (55 * height_r));
           l1.setForeground(new Color(248, 248, 255));
           Font font = new Font("楷体", Font.BOLD, (int) (30 * width_r));
           l1.setFont(font);
          add(l1);
          //上方面板
            p1.setBounds(0, 0, (int) (1920*width_r), (int) (150*height_r));
           p1.setBackground(new Color(42, 52, 65));
          add(p1);
            p2.setBounds(0, (int) (100*height_r), (int) (1920*width_r), (int) (50*height_r));
            p2.setBackground(new Color(68,84,105));
            add(p2);
       }
        //设置屏幕大小、背景颜色
        setBounds(0, 0, width, height);
        if(color_switch[0])
        {
            setBackground(new Color(200,224,228));
        }
        else{
            setBackground(new Color(68,84,105));
        }
        //设置绝对布局
        setLayout(null);

        //SEU logo
        int icon1_width11 = 160;
        int icon1_height11 = 50;

        //信息面板
        JPanel status_jpanel = status_panel(width_r, height_r, width - 2 * (60 + icon1_width11) * width_r, (1080 - 70 - icon1_height11) * height_r, iat);
        status_jpanel.setBounds((int) ((60 + icon1_width11) * width_r), (int) ((47 + icon1_height11) * height_r), (int) (width - 2 * (60 + icon1_width11) * width_r), (int) ((1080 - 70 - icon1_height11) * height_r));
        add(status_jpanel);
        //上方蓝色背景
        JPanel blue_back = new JPanel();
        if(color_switch[0]){
            blue_back.setBackground(new Color(125,182,191));
        }else {
           blue_back.setBackground(new Color(42,52,65));
       }
        blue_back.setBounds(0, 0, width, height * 3/ 5);
        add(blue_back);
        lswitch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color_switch[0] =!color_switch[0];
                functionChoose.lswitch.doClick();
                if(color_switch[0]){
                    status.setBackground(new Color(200,224,228));
                    setBackground(new Color(200,224,228));
                    lswitch.setText("日间");
                    lswitch.setBackground(new Color(200,224,228));
                    lswitch.setForeground(new Color(0,0,0));
                    blue_back.setBackground(new Color(125,182,191));
                    name_label.setForeground(new Color(0, 0, 0));
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
                    l1.setForeground(new Color(7,8,9));
                    p1.setBackground(new Color(125,182,191));
                    p2.setBackground(new Color(155,190,200));
                    basicInformation_table. setBackground(new Color(200,224,228));
                    logo.setIcon(new ImageIcon("src/image/xueji2_bgmin.png"));
                }
                else {
                    status.setBackground(new Color(68, 84, 105));
                    setBackground(new Color(68, 84, 105));
                    lswitch.setText("夜间");
                    lswitch.setBackground(new Color(68, 84, 105));
                    lswitch.setForeground(new Color(255, 255, 255));
                    blue_back.setBackground(new Color(42, 52, 65));
                    name_label.setForeground(new Color(255, 255, 255));
                    student_status_table.text1.setBackground(new Color(100, 108, 114));
                    student_status_table.text1.setForeground(new Color(204, 204, 204));
                    student_status_table.text3.setBackground(new Color(100, 108, 114));
                    student_status_table.text3.setForeground(new Color(204, 204, 204));
                    student_status_table.text5.setBackground(new Color(100, 108, 114));
                    student_status_table.text5.setForeground(new Color(204, 204, 204));
                    student_status_table.text7.setBackground(new Color(100, 108, 114));
                    student_status_table.text7.setForeground(new Color(204, 204, 204));
                    student_status_table.text9.setBackground(new Color(100, 108, 114));
                    student_status_table.text9.setForeground(new Color(204, 204, 204));
                    student_status_table.text11.setBackground(new Color(100, 108, 114));
                    student_status_table.text11.setForeground(new Color(204, 204, 204));
                    student_status_table.text13.setBackground(new Color(100, 108, 114));
                    student_status_table.text13.setForeground(new Color(204, 204, 204));
                    student_status_table.text15.setBackground(new Color(100, 108, 114));
                    student_status_table.text15.setForeground(new Color(204, 204, 204));
                    student_status_table.text17.setBackground(new Color(100, 108, 114));
                    student_status_table.text17.setForeground(new Color(204, 204, 204));
                    student_status_table.text19.setBackground(new Color(100, 108, 114));
                    student_status_table.text19.setForeground(new Color(204, 204, 204));
                    student_status_table.text21.setBackground(new Color(100, 108, 114));
                    student_status_table.text21.setForeground(new Color(204, 204, 204));
                    student_status_table.text23.setBackground(new Color(100, 108, 114));
                    student_status_table.text23.setForeground(new Color(204, 204, 204));
                    student_status_table.text25.setBackground(new Color(100, 108, 114));
                    student_status_table.text25.setForeground(new Color(204, 204, 204));
                    student_status_table.text27.setBackground(new Color(100, 108, 114));
                    student_status_table.text27.setForeground(new Color(204, 204, 204));
                    student_status_table.text29.setBackground(new Color(100, 108, 114));
                    student_status_table.text29.setForeground(new Color(204, 204, 204));
                    student_status_table.text31.setBackground(new Color(100, 108, 114));
                    student_status_table.text31.setForeground(new Color(204, 204, 204));
                    student_status_table.text2.setBackground(new Color(68, 84, 105));
                    student_status_table.text2.setForeground(new Color(204, 204, 204));
                    student_status_table.text4.setBackground(new Color(68, 84, 105));
                    student_status_table.text4.setForeground(new Color(204, 204, 204));
                    student_status_table.text6.setBackground(new Color(68, 84, 105));
                    student_status_table.text6.setForeground(new Color(204, 204, 204));
                    student_status_table.text8.setBackground(new Color(68, 84, 105));
                    student_status_table.text8.setForeground(new Color(204, 204, 204));
                    student_status_table.text10.setBackground(new Color(68, 84, 105));
                    student_status_table.text10.setForeground(new Color(204, 204, 204));
                    student_status_table.text12.setBackground(new Color(68, 84, 105));
                    student_status_table.text12.setForeground(new Color(204, 204, 204));
                    student_status_table.text14.setBackground(new Color(68, 84, 105));
                    student_status_table.text14.setForeground(new Color(204, 204, 204));
                    student_status_table.text16.setBackground(new Color(68, 84, 105));
                    student_status_table.text16.setForeground(new Color(204, 204, 204));
                    student_status_table.text18.setBackground(new Color(68, 84, 105));
                    student_status_table.text18.setForeground(new Color(204, 204, 204));
                    student_status_table.text20.setBackground(new Color(68, 84, 105));
                    student_status_table.text20.setForeground(new Color(204, 204, 204));
                    student_status_table.text22.setBackground(new Color(68, 84, 105));
                    student_status_table.text22.setForeground(new Color(204, 204, 204));
                    student_status_table.text24.setBackground(new Color(68, 84, 105));
                    student_status_table.text24.setForeground(new Color(204, 204, 204));
                    student_status_table.text26.setBackground(new Color(68, 84, 105));
                    student_status_table.text26.setForeground(new Color(204, 204, 204));
                    student_status_table.text28.setBackground(new Color(68, 84, 105));
                    student_status_table.text28.setForeground(new Color(204, 204, 204));
                    student_status_table.text30.setBackground(new Color(68, 84, 105));
                    student_status_table.text30.setForeground(new Color(204, 204, 204));
                    student_status_table.text32.setBackground(new Color(68, 84, 105));
                    student_status_table.text32.setForeground(new Color(204, 204, 204));
                    basicInformation_table.setBackground(new Color(68, 84, 105));
                    l1.setForeground(new Color(248,248,255));
                    p1.setBackground(new Color(42, 52, 65));
                    p2.setBackground(new Color(68, 84, 105));
                    student_status_table.title_label1.setForeground(new Color(170, 170, 170));
                    student_status_table.title_label2.setForeground(new Color(170, 170, 170));
                    logo.setIcon(new ImageIcon("src/image/xueji1_bgmin.png"));
                }
            }
        });

    }

}






