package UIviewer.SelectCourse;

import ClientToServer.myInfo;

import javax.swing.*;
import java.awt.*;

public class ChooseCourse_guidance extends JPanel{


    public ChooseCourse_guidance()
    {
        setLayout(null);
        JPanel p11=new JPanel();
        p11.setBounds(0,0,1273,784);
        //文字
        JLabel l1 = new JLabel("  你好！");
        l1.setBounds(170, 100, 100, 75);
        Font font = new Font("楷体", Font.BOLD, 22);
        l1.setFont(font);
        //l1.setForeground(new Color(111,222,0));
        add(l1);


        //信息面板
        JLabel l4 = new JLabel("      基本信息");
        l4.setBounds(23, 205, 250, 60);
        Font font2 = new Font("楷体", Font.BOLD, 25);
        l4.setFont(font2);
        l4.setForeground(new Color(94, 38, 18));
        add(l4);

        String name = "1";
        JLabel l2 = new JLabel(" 姓名：" + myInfo.getName());
        l2.setBounds(30, 300, 250, 60);
        Font font1 = new Font("微软雅黑", Font.PLAIN, 18);
        l2.setFont(font1);
        l2.setForeground(new Color(0, 0, 0));
        add(l2);
        String card = "";
        JLabel l3 = new JLabel(" 卡号：" + myInfo.getId());
        l3.setBounds(30, 410, 250, 60);
        l3.setFont(font1);
        l3.setForeground(new Color(0, 0, 0));
        add(l3);


        //横向图片
        /*JLabel l12 = new JLabel();
        ImageIcon icon5 = new ImageIcon("src/image/banner3.png");
        l12.setIcon(icon5);
        l12.setBounds(310, 70, 1000, 125);
        add(l12);*/

        //文字
        /*JLabel l13 = new JLabel("     功能选择 ");
        l13.setBounds(320, 200, 200, 75);
        Font font13 = new Font("微软雅黑", Font.BOLD, 25);
        l13.setFont(font13);
        //l13.setForeground(new Color(111,222,0));
        jf.getContentPane().add(l13);*/

        //左侧面板
        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 310, 784);
        p1.setBackground(new Color(135, 206, 250, 180));
        add(p1);


        //文本编辑框（输入课程编号或课程名字）
        JLabel lblNewLabel = new JLabel("选课帮助:");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 35));
        lblNewLabel.setBounds(400, 45, 275, 35);
        add(lblNewLabel);

        //文本编辑框（输入选课帮助）
        JLabel lblNewLabel2 = new JLabel("1、登陆选课系统，学生需根据培养方案进行选课");
        lblNewLabel2.setFont(new Font("宋体", Font.BOLD, 25));
        lblNewLabel2.setBounds(400, 135, 605, 35);
        add(lblNewLabel2);

        //文本编辑框（输入选课帮助）
        JLabel lblNewLabel3 = new JLabel("2、每学期选择课程的学分和应不低于12学分");
        lblNewLabel3.setFont(new Font("宋体", Font.BOLD, 25));
        lblNewLabel3.setBounds(400, 205, 605, 35);
        add(lblNewLabel3);

        //文本编辑框（输入选课帮助）
        JLabel lblNewLabel4 = new JLabel("3、教师有权利申报课程，经审核通过后可进行授课");
        lblNewLabel4.setFont(new Font("宋体", Font.BOLD, 25));
        lblNewLabel4.setBounds(400, 275, 605, 35);
        add(lblNewLabel4);

        //文本编辑框（输入选课帮助）
        JLabel lblNewLabel5 = new JLabel("4、管理员有权增添、删除学生教师信息");
        lblNewLabel5.setFont(new Font("宋体", Font.BOLD, 25));
        lblNewLabel5.setBounds(400, 345, 605, 35);
        add(lblNewLabel5);

        //文本编辑框（输入选课帮助）
        JLabel lblNewLabel6 = new JLabel("5、学生需要在选课系统开放的时间内完成选课");
        lblNewLabel6.setFont(new Font("宋体", Font.BOLD, 25));
        lblNewLabel6.setBounds(400, 415, 605, 35);
        add(lblNewLabel6);

        //文本编辑框（输入选课帮助）
        JLabel lblNewLabel7 = new JLabel("6、若对选课系统有疑问，可致电咨询052-84196536");
        lblNewLabel7.setFont(new Font("宋体", Font.BOLD, 25));
        lblNewLabel7.setBounds(400, 485, 605, 35);
        add(lblNewLabel7);

        //右下面板
        JPanel p3 = new JPanel();
        p3.setBounds(310, 0, 950, 685);
        p3.setBackground(new Color(211, 211, 211, 100));
        add(p3);


        //右侧面板
        JPanel p2 = new JPanel();
        p2.setBounds(310, 0, 950, 1000);
        p2.setBackground(new Color(245, 245, 245, 180));
        add(p2);

        //横向图片
        JLabel l16 = new JLabel();
        ImageIcon icon7 = new ImageIcon("src/image/background2.jpg");
        l16.setIcon(icon7);
        l16.setBounds(0, 0, 1273, 790);
        p11.add(l16);

        add(p11);
    }

}
