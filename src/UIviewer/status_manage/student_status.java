package UIviewer.status_manage;


import net.coobird.thumbnailator.Thumbnails;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class student_status extends JPanel {
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
        logo.setBounds((int)(20*width_r),(int)(0.2*height_r),(int)((20+icon1_width)*width_r),(int)((0.2+height_r)*icon1_height));

        //标题
        JLabel title=new JLabel("学生基本信息");
        title.setBounds((int)((30+icon1_width)*width_r), (int)(0.1*width_r), (int)((130+icon1_width)*width_r), (int)((0.1+height_r)*icon1_height));
        Font title_font = new Font("微软雅黑", Font.BOLD, 25);
        title.setFont(title_font);
        title.setForeground(new Color(255,255,255));
        add(title);


        //信息面板
        /*JPanel status=new JPanel();
        status.setBackground(new Color(255,255,255));
        status.setBounds((int)((50+icon1_width)*width_r),(int)((0.7+height_r)*icon1_height), (int)(width-2*(50+icon1_width)*width_r),height);
        status.setBorder(BorderFactory.createEtchedBorder());
        add(status);*/
        //信息面板头像



        //信息面板上透明条
        JPanel white_front_slice=new JPanel();
        white_front_slice.setLayout(null);//设置绝对布局
        white_front_slice.setBackground(new Color(124,136,204));
        white_front_slice.setBounds((int)((80+icon1_width)*width_r),(int)((0.1+height_r)*icon1_height), (int)(width-2*(80+icon1_width)*width_r),(int)((0.3+height_r)*icon1_height));
        JLabel front_title=new JLabel("学生基本信息");
        front_title.setBounds((int)((80+icon1_width)*width_r), (int)((0.1+height_r)*icon1_height), (int)((85+icon1_width)*width_r), (int)((0.2+height_r)*icon1_height));
        Font front_title_font = new Font("微软雅黑", Font.PLAIN, 18);
        front_title.setFont(front_title_font);
        front_title.setForeground(new Color(255,255,255));
        white_front_slice.add(front_title);
        add(white_front_slice);

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
