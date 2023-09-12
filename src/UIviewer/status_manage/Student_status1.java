package UIviewer.status_manage;
import ClientToServer.myInfo;
import DAO.StatusManagement.ImageAndTable;
import UIviewer.login.functionChoose;
import net.coobird.thumbnailator.Thumbnails;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Student_status1 extends JFrame{
    static Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    /**
     * 宽度
     */
    static int width=(int ) screensize.getWidth(); //得到宽度
    /**
     * 高度
     */
    static int height=(int ) screensize.getHeight();//获得高度
    /**
     * 宽度r
     */
    double width_r=(double)(width)/1273;
    /**
     * 高r
     */
    double height_r=(double)(height)/784;
    /**
     * 卡布局
     */
    public static CardLayout cardLayout=new CardLayout();
    /**
     * 面板
     */
    public static JPanel panel=new JPanel();
    static String name;
    //public static JPanel panel1=new JPanel();
    static void getName(String a)
    {
        name=a;
    }
    public Student_status1(ImageAndTable iat) throws IOException {
//        functionChoose.jf.getJMenuBar().setBackground(new Color(68,84,105));
//        functionChoose.jf.getJMenuBar().getMenu(0).setForeground(new Color(255,255,255));
        String name= myInfo.getName();
        getName(name);
        Font myfont = new Font("微软雅黑 ", Font.BOLD, 18);
        JPanel p3=new JPanel();
        p3.setBounds((int) (200*width_r),(int) (135*width_r),(int)(850*width_r),(int)(620*height_r));
        p3.setBackground(new Color(80,100,130));
        add(p3);
      //  个人照片
        JLabel image = new JLabel();
        int icon_width = 160;
        int icon_height = 320;
        String IDcard = iat.student.getStudent_idcard();
        //    Client_status.setId(myInfo.getId());  //否则查找学生，id为自身的，识别线程
        //Client_status.getphoto(IDcard);
        if (iat.image != null) {
            FileOutputStream fileOutputStream = new FileOutputStream("src/image/status/" + IDcard + ".jpg");
            fileOutputStream.write(iat.image);
            try {
                Thumbnails.of(new File("src/image/status/" + IDcard + ".jpg"))
                        .size((int) (icon_width * width_r), (int) (icon_height * width_r))
                        .toFile(new File("src/image/status/" + IDcard + "_min.jpg"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            image.setIcon(new ImageIcon("src/image/status/" + IDcard + "_min.jpg"));
        }
        p3.add(image);
        JPanel p4 = new JPanel();
        p4.setBackground(new Color(75,94,120));
        p4.setBounds(0, (int) (145*height_r), width, height * 2/5);
        add(p4);
        JPanel p5=new JPanel();
        p5.setBackground(new Color(147, 163, 180));
        p5.setBounds(0,(int)(450*height_r),width,(int)(320*height_r));
        add(p5);
        JButton btnNewButton_6 = new JButton("退出选课系统");
        btnNewButton_6.setBounds((int) (1100*width_r), (int) (100*height_r), (int) (173*width_r), (int) (50*height_r));
        btnNewButton_6.setFont(myfont);
        btnNewButton_6.setFocusPainted(false);
        btnNewButton_6.setForeground(new Color(220, 220, 220));
        btnNewButton_6.setContentAreaFilled(false);
        btnNewButton_6.setBorder(null);
        btnNewButton_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionChoose.jf.setContentPane(functionChoose.fc_panel);
                functionChoose.jf.setTitle("functionChoose");
                setVisible(false);
            }

        });
        add(btnNewButton_6);
        setBounds(0,0,(int)(1273*width_r),(int)(790*height_r));
        setLayout(null);
        panel.setBounds(0,(int)(150*height_r),(int)(1273*width_r),(int)(790*height_r));
        add(panel);
        JLabel logo = new JLabel();
        ImageIcon icon = new ImageIcon("src/image/xueji1_bg.png");
        int icon1_width = 600;
        int icon1_height = 75;
        try {
            Thumbnails.of(new File("src/image/xueji1_bg.png"))
                    .size((int) (icon1_width * width_r), (int) (icon1_height * height_r))
                    .toFile(new File("src/image/xueji1_bgmin.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logo.setIcon(new ImageIcon("src/image/xueji1_bgmin.png"));
        logo.setBounds((int) (30 * width_r), (int) (10 * height_r), (int) (600 * width_r), (int) (75 * height_r));
        add(logo);
        //文字
        JLabel l1 = new JLabel("你好！" + name);
        l1.setBounds((int) (1100 * width_r), (int) (30 * height_r), (int) (200 * width_r), (int) (55 * height_r));
        l1.setForeground(new Color(248, 248, 255));
        Font font = new Font("楷体", Font.BOLD, (int) (20 * width_r));
        l1.setFont(font);
        add(l1);

        JPanel p1 = new JPanel();
        //上方面板
        p1.setBounds(0, 0, (int) (1279 * width_r), (int) (100 * height_r));
        p1.setBackground(new Color(42, 52, 65));
        add(p1);
        JPanel p2 = new JPanel();
        p2.setBounds(0, (int) (100*height_r), (int) (1280*width_r), (int) (50*height_r));
        p2.setBackground(new Color(68,84,105));
        add(p2);


    }
     public static void main(String[]args) throws IOException {
      //  Student_status1 ss=new Student_status1();
         ImageAndTable iat=new ImageAndTable();
         JFrame frame = new Student_status1(iat);//也可在构造函数中设置窗口标题JFrame frame=new MyLabel("Hello lable");
         //frame.setTitle("hello world");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(width, height);
         frame.setVisible(true);

    }
}
