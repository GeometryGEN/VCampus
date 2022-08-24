package UIviewer.status_manage;


import net.coobird.thumbnailator.Thumbnails;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class student_status extends JPanel {
    //信息面板
    public JPanel status_panel(double width_r,double height_r){
        JPanel status=new JPanel();
        status.setBackground(new Color(255,255,255));
        status.setBorder(BorderFactory.createEtchedBorder());
        status.setLayout(null);//设置绝对布局
        //信息面板头像
        JLabel image = new JLabel();
        int icon1_width=320;
        int icon1_height=150;
        try {
            Thumbnails.of(new File("src/image/status_image.png"))
                    .size((int)(icon1_width*width_r), (int)(icon1_height*width_r))
                    .toFile(new File("src/image/status_image_min.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        image.setIcon(new ImageIcon("src/image/status_image_min.png"));
        status.add(image);
        image.setBounds((int)(60*width_r),(int)(60*height_r),(int)((60+icon1_width)*width_r),(int)((60+icon1_height)*height_r));
        return status;
        //头像下名字
    }

    public student_status(int width, int height) {
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
        logo.setBounds((int)(30*width_r),(int)(3*height_r),(int)((30+icon1_width)*width_r),(int)((3+icon1_height)*height_r));
        //标题
        JLabel title=new JLabel("学生基本信息");
        title.setBounds((int)((40+icon1_width)*width_r), (int)(2*width_r), (int)((135+icon1_width)*width_r), (int)((2+icon1_height)*height_r));
        Font title_font = new Font("微软雅黑", Font.BOLD, 24);
        title.setFont(title_font);
        title.setForeground(new Color(255,255,255));
        add(title);

        //信息面板
        JPanel status_jpanel= status_panel(width_r,height_r);
        status_jpanel.setBounds((int)((60+icon1_width)*width_r),(int)((47+icon1_height)*height_r), (int)(width-2*(60+icon1_width)*width_r),height);
        add(status_jpanel);

        //信息面板上透明条
        JPanel white_front_slice=new JPanel();
        white_front_slice.setBackground(new Color(124,136,204));
        white_front_slice.setBounds((int)((90+icon1_width)*width_r),(int)((7+icon1_height)*height_r), (int)(width-2*(90+icon1_width)*width_r),(int)((12+icon1_height)*height_r));
        add(white_front_slice);
        white_front_slice.setLayout(null);//设置绝对布局
        //文字
        JLabel front_title=new JLabel("学生基本信息");
        front_title.setBounds((int)(20*width_r), (int)(0*height_r), (int)(300*width_r), (int)(40*height_r));
        Font front_title_font = new Font("宋体", Font.BOLD, 15);
        front_title.setFont(front_title_font);
        front_title.setForeground(new Color(255,255,255));
        white_front_slice.add(front_title);

        //上方蓝色背景
        JPanel blue_back=new JPanel();
        blue_back.setBackground(new Color(63,81,181));
        blue_back.setBounds(0,0,width,height*2/5);
        add(blue_back);

    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("student_status");
        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int width=(int ) screensize.getWidth(); //得到宽度
        int height=(int ) screensize.getHeight();//获得高度
        frame.setBounds(0,0,width,height);
        frame.setContentPane(new student_status(width,height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
