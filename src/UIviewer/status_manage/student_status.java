package UIviewer.status_manage;

import ClientToServer.ClientToServer;
import UIhandler.Shop.Client_shop;
import UIhandler.StatusManagement.Client_status;
import net.coobird.thumbnailator.Thumbnails;
import ClientToServer.ManageClientToServerThread;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class student_status extends JPanel {

    //信息面板
    public static JPanel status_panel(ClientToServer ucs, double width_r, double height_r, double width, double height,String IDcard) throws Exception {
        JPanel status=new JPanel();
        status.setBackground(new Color(255,255,255));
        status.setBorder(BorderFactory.createEtchedBorder());
        status.setLayout(null);//设置绝对布局
        //个人照片
        JLabel image = new JLabel();
        int icon1_width=320;
        int icon1_height=150;

        Client_status.setId(ucs.getIDcard());  //否则查找学生，id为自身的，识别线程

        Client_status.getphoto(IDcard);

        try {
            Thumbnails.of(new File("src/image/"+IDcard+".jpg"))
                    .size((int)(icon1_width*width_r), (int)(icon1_height*width_r))
                    .toFile(new File("src/image/"+IDcard+"_min.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        image.setIcon(new ImageIcon("src/image/"+IDcard+"_min.jpg"));
        status.add(image);
        image.setBounds((int)(60*width_r),(int)(145*height_r),(int)(icon1_width*width_r),(int)(icon1_height*height_r));
        //头像下名字
        String name = Client_status.returnStatusInfo(IDcard).getStudent_name();
        JLabel name_label=new JLabel(name,JLabel.CENTER);
        name_label.setBounds((int)(57*width_r), (int)((165+icon1_height)*height_r), (int)(110*width_r), (int)(15*height_r));
        Font name_font = new Font("微软雅黑", Font.PLAIN, (int)(16*width_r));
        name_label.setFont(name_font);
        name_label.setForeground(new Color(0,0,0));
        status.add(name_label);

        //添加表格
        JPanel table_jpanel = new student_status_table(ucs,width_r,height_r,45*height_r,height-100*height_r,IDcard);
        table_jpanel.setBounds((int)((icon1_width-90)*width_r),(int)(85*height_r), (int)(width-(icon1_width-30)*width_r),(int)(height-140*height_r));
        status.add(table_jpanel);

        return status;
    }

    public student_status(ClientToServer ucs,int width, int height) throws Exception {
        double width_r=(double)(width)/1920;
        double height_r=(double)(height)/1080;
        //设置屏幕大小、背景颜色
        setBounds(0,0,width,height);
        setBackground(new Color(255,255,255));
        //设置绝对布局
        setLayout(null);

        //SEU logo
        JLabel logo = new JLabel();
        int icon1_width=160;
        int icon1_height=50;
        try {
            Thumbnails.of(new File("src/image/student_manage_logo.png"))
                    .size((int)(icon1_width*width_r), (int)(icon1_height*width_r))
                    .toFile(new File("src/image/student_manage_logo_min.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logo.setIcon(new ImageIcon("src/image/student_manage_logo_min.png"));
        add(logo);
        logo.setBounds((int)(30*width_r),(int)(5*height_r),(int)(icon1_width*width_r),(int)(icon1_height*height_r));
        //标题
        JLabel title=new JLabel("学生基本信息");
        title.setBounds((int)((40+icon1_width)*width_r), (int)(3*height_r), (int)(300*width_r), (int)(icon1_height*height_r));
        Font title_font = new Font("微软雅黑", Font.BOLD, (int)(31*width_r));
        title.setFont(title_font);
        title.setForeground(new Color(255,255,255));
        add(title);

        //信息面板
        JPanel status_jpanel= status_panel(ucs,width_r,height_r,width-2*(60+icon1_width)*width_r,(1080-70-icon1_height)*height_r,ucs.getIDcard());
        status_jpanel.setBounds((int)((60+icon1_width)*width_r),(int)((47+icon1_height)*height_r), (int)(width-2*(60+icon1_width)*width_r),(int)((1080-70-icon1_height)*height_r));
        add(status_jpanel);

        //信息面板上透明条
        JPanel white_front_slice=new JPanel();
        white_front_slice.setBackground(new Color(124,136,204));
        white_front_slice.setBounds((int)((90+icon1_width)*width_r),(int)((7+icon1_height)*height_r), (int)(width-2*(90+icon1_width)*width_r),(int)(40*height_r));
        add(white_front_slice);
        white_front_slice.setLayout(null);//设置绝对布局
        //文字
        JLabel front_title=new JLabel("学生基本信息");
        front_title.setBounds((int)(20*width_r), (int)(0*height_r), (int)(300*width_r), (int)(40*height_r));
        Font front_title_font = new Font("微软雅黑", Font.PLAIN, (int)(19*width_r));
        front_title.setFont(front_title_font);
        front_title.setForeground(new Color(240,241,249));
        white_front_slice.add(front_title);

        //上方蓝色背景
        JPanel blue_back=new JPanel();
        blue_back.setBackground(new Color(63,81,181));
        blue_back.setBounds(0,0,width,height*2/5);
        add(blue_back);

    }


    //    public static void main(String[] args) {
//        JFrame frame = new JFrame("student_status");
//        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
//        int width=(int ) screensize.getWidth(); //得到宽度
//        int height=(int ) screensize.getHeight();//获得高度
//        frame.setBounds(0,0,width,height);
//        frame.setContentPane(new student_status(ucs,width,height));
//        jb.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame.getContentPane().setVisible(false);
//            }
//        });
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//    }
}
