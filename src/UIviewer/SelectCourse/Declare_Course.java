package UIviewer.SelectCourse;

import ClientToServer.myInfo;
import DAO.Curriculum.Opencourse;
import UIhandler.Currirulum.Client_curriculum;
import net.coobird.thumbnailator.Thumbnails;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * 申报课程
 *
 * @author 28468
 * @date 2022/09/03
 */
public class Declare_Course extends JPanel{
    /**
     * 拉
     */
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    /**
     * 宽度
     */
    int width=(int ) screensize.getWidth(); //得到宽度
    /**
     * 高度
     */
    int height=(int ) screensize.getHeight();//获得高度
    /**
     * 宽度r
     */
    double width_r=(double)(width)/1273;
    /**
     * 高r
     */
    double height_r=(double)(height)/790;

    /**
     * 申报课程
     */
    public Declare_Course()
    {
        setLayout(null);
        setVisible(true);
    //        JPanel p11=new JPanel();
//        p11.setBounds(0,0,(int)(1273*width_r),(int)(784*height_r));

//        JLabel lblBackground = new JLabel(); // 创建一个标签组件对象
//        ImageIcon icon = new ImageIcon("src/image/logo-mini.png"); // 创建背景图片对象
//        lblBackground.setIcon(icon); // 设置标签组件要显示的图标
//        lblBackground.setBounds((int)(25*width_r), (int)(40*height_r), (int)(210*width_r), (int)(80*height_r)); // 设置组件的显示位置及大小
//        add(lblBackground);

//
//        //文字
//        JLabel l1 = new JLabel("  你好！");
//        l1.setBounds((int)(30*width_r), (int)(130*height_r), (int)(100*width_r), (int)(75*height_r));
//        Font font = new Font("楷体", Font.BOLD, 22);
//        l1.setFont(font);
//        //l1.setForeground(new Color(111,222,0));
//        add(l1);
//
//
        //信息面板
        JLabel l4 = new JLabel("基本信息");
        l4.setBounds((int)(980*width_r), (int)(225*height_r), (int)(250*width_r), (int)(60*height_r));
        Font font2 = new Font("楷体", Font.BOLD, 35);
        l4.setFont(font2);
        l4.setForeground(new Color(255,255,248));
        add(l4);

        String name = "1";
        JLabel l2 = new JLabel(" 姓名：" + myInfo.getName());
        l2.setBounds((int)(950*width_r), (int)(320*height_r), (int)(250*width_r), (int)(60*height_r));
        Font font1 = new Font("微软雅黑", Font.PLAIN, 25);
        l2.setFont(font1);
        l2.setForeground(new Color(255,255,248));
        add(l2);
        String card = "";
        JLabel l3 = new JLabel(" 卡号：" + myInfo.getId());
        l3.setBounds((int)(950*width_r), (int)(410*height_r), (int)(250*width_r), (int)(60*height_r));
        l3.setFont(font1);
        l3.setForeground(new Color(255,255,248));
        add(l3);
        JLabel touxiang = new JLabel();
        ImageIcon icon = new ImageIcon("src/image/默认头像.png");
        int icon_width=160;
        int icon_height=160;
        try {
            Thumbnails.of(new File("src/image/默认头像.png"))
                    .size((int)(icon_width*width_r), (int)(icon_height*height_r))
                    .toFile(new File("src/image/头像_min.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        touxiang.setIcon(new ImageIcon("src/image/头像_min.png"));
        touxiang.setBounds((int) (980*width_r), (int) (60*height_r), (int) (160*width_r), (int) (160*height_r));
        add(touxiang);

        //信息面板
        JPanel p1 = new JPanel();
        p1.setBounds(950, 50, (int)(250*width_r), (int)(475*height_r));
        p1.setBackground(new Color(125, 182, 191));
        add(p1);




        Border blackline=BorderFactory.createLineBorder(Color.black);
        //文本编辑框（输入课程编号或课程名字）
        JLabel lblNewLabel = new JLabel("课程申报");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 45));
        lblNewLabel.setBounds((int)(450*width_r), (int)(80*height_r), (int)(275*width_r), (int)(75*height_r));
        add(lblNewLabel);
        lblNewLabel.setForeground(new Color(255,255,255));



        JLabel lblNewLabel2 = new JLabel(" 课程名称");
        lblNewLabel2.setFont(new Font("宋体", Font.BOLD, 30));
        lblNewLabel2.setBounds((int)(300*width_r), (int)(160*height_r), (int)(160*width_r), (int)(75*height_r));
        add(lblNewLabel2);
        lblNewLabel2.setBorder(blackline);
        lblNewLabel2.setBackground(new Color(248,245,245));
        lblNewLabel2.setForeground(new Color(0,0,0));
        lblNewLabel2.setOpaque(true);
        JTextField textField1 = new JTextField();
        textField1.setFont(new Font("宋体", Font.BOLD, 25));
        textField1.setBounds((int)(459*width_r), (int)(160*height_r), (int)(400*width_r), (int)(75*height_r));
        add(textField1);
        textField1.setColumns(10);

        JLabel lblNewLabel3 = new JLabel(" 课程学分");
        lblNewLabel3.setFont(new Font("宋体", Font.BOLD, 30));
        lblNewLabel3.setBounds((int)(300*width_r), (int)(235*height_r), (int)(160*width_r), (int)(75*height_r));
        add(lblNewLabel3);
        lblNewLabel3.setBorder(blackline);
        lblNewLabel3.setBackground(new Color(248,245,245));
        lblNewLabel3.setForeground(new Color(0,0,0));
        lblNewLabel3.setOpaque(true);
        JTextField textField2 = new JTextField();
        textField2.setFont(new Font("宋体", Font.BOLD, 25));
        textField2.setBounds((int)(459*width_r), (int)(235*height_r), (int)(400*width_r), (int)(75*height_r));
        add(textField2);
        textField2.setColumns(10);

        JLabel lblNewLabel4 = new JLabel(" 课程学时");
        lblNewLabel4.setFont(new Font("宋体", Font.BOLD, 30));
        lblNewLabel4.setBounds((int)(300*width_r), (int)(310*height_r), (int)(160*width_r), (int)(75*height_r));
        add(lblNewLabel4);
        lblNewLabel4.setBorder(blackline);
        lblNewLabel4.setBackground(new Color(248,245,245));
        lblNewLabel4.setForeground(new Color(0,0,0));
        lblNewLabel4.setOpaque(true);

        JTextField textField3 = new JTextField();
        textField3.setFont(new Font("宋体", Font.BOLD, 25));
        textField3.setBounds((int)(459*width_r), (int)(310*height_r), (int)(400*width_r), (int)(75*height_r));
        add(textField3);
        textField3.setColumns(10);


        JButton btnNewButton_7 = new JButton("确认申报");
        btnNewButton_7.setBounds((int)(500*width_r), (int)(425*height_r), (int)(150*width_r), (int)(50*height_r));
        Font myfont3 = new Font("微软雅黑", Font.BOLD, 20);
        btnNewButton_7.setFont(myfont3);
        btnNewButton_7.setBackground(new Color(68,84,105));
        btnNewButton_7.setOpaque(true);
        btnNewButton_7.setForeground(new Color(248, 248, 255));
        btnNewButton_7.setContentAreaFilled(true);//设置按钮透明
        //btnNewButton_6.setBorder(null);//取消边框
        add(btnNewButton_7);
        btnNewButton_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Opencourse opc=new Opencourse();
                    opc.setName(textField1.getText());
                    opc.setPoint(Double.valueOf(textField2.getText()));
                    opc.setHour(Integer.valueOf(textField3.getText()));
                    opc.setTeacher_id(myInfo.getId());
                    opc.setTeacher(myInfo.getName());
                    Client_curriculum.apply(opc);

                }catch(Exception ex){
                    ex.printStackTrace();
                }
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
            }
        });


        //右下面板
        JPanel p3 = new JPanel();
        p3.setBounds((int)(250*width_r), (int)(50*height_r), (int)(650*width_r), (int)(475*height_r));
        p3.setBackground(new Color(106, 113, 122,100));
        add(p3);
//
//        //右侧面板
//        JPanel p2 = new JPanel();
//        p2.setBounds((int)(310*width_r), 0, (int)(980*width_r), (int)(1000*height_r));
//        p2.setBackground(new Color(245, 245, 245, 180));
//        add(p2);




        JPanel p11 = new JPanel();
        p11.setBounds(0, 0, (int) width, (int) height);
        JLabel pic1 = new JLabel();
        ImageIcon icon1 = new ImageIcon("src/image/xuankebg_2.jpg");
        int icon1_width = 1280;
        int icon1_height = 600;
        try {
            Thumbnails.of(new File("src/image/xuankebg_2.png"))
                    .size((int) (icon1_width * width_r), (int) (icon1_height * height_r))
                    .keepAspectRatio(false)
                    .toFile(new File("src/image/xuankebg_2_min.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pic1.setIcon(new ImageIcon("src/image/xuankebg_2_min.png"));
        pic1.setBounds(0, -10, (int) (icon1_width * width_r), (int) (icon1_height * height_r));
        p11.add(pic1);

//        JLabel l11 = new JLabel();
//        ImageIcon icon4 = new ImageIcon("src/image/label2.png");
//        int icon4_width=300;
//        int icon4_height=600;
//        try {
//            Thumbnails.of(new File("src/image/label2.png"))
//                    .size((int)(icon4_width*width_r), (int)(icon4_height*height_r))
//                    .toFile(new File("src/image/label2_min.png"));
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        l11.setBounds((int) (950*width_r), (int)(50*height_r), (int) (300*width_r), (int) (600*height_r));
//        p11.add(l11);
        add(p11);
    }
}
