package UIviewer.SelectCourse;

import javax.swing.*;
import java.awt.*;

public class ChooseCourse_guidance {
    public static void main(String[] args) {
        JFrame jf = new JFrame("ChooseCourse_guidance");
        jf.setSize(1273, 784);

        //小头像
        JLabel touxiang = new JLabel();
        ImageIcon icon = new ImageIcon("src/image/logodz.png");
        touxiang.setIcon(icon);
        touxiang.setBounds(20, 20, 100, 100);
        jf.getContentPane().add(touxiang);

        //文字
        JLabel l1 = new JLabel("  你好！");
        l1.setBounds(120, 40, 200, 75);
        Font font = new Font("楷体", Font.BOLD, 22);
        l1.setFont(font);
        //l1.setForeground(new Color(111,222,0));
        jf.getContentPane().add(l1);

/*
        //左侧面板
        JPanel p3 = new JPanel();
        p3.setBounds(20, 150, 260, 300);
        p3.setBackground(new Color(225,255,255, 180));
        // p3.setBorder(new MyLineBorder(new Color(225,255,255),180,true));
        jf.getContentPane().add(p3);

 */


        //信息面板
        JLabel l4 = new JLabel("      基本信息");
        l4.setBounds(23, 185, 250, 60);
        Font font2 = new Font("楷体", Font.BOLD, 25);
        l4.setFont(font2);
        l4.setForeground(new Color(94, 38, 18));
        jf.getContentPane().add(l4);

        String name = "1";
        JLabel l2 = new JLabel(" 姓名：" + name);
        l2.setBounds(30, 310, 250, 60);
        Font font1 = new Font("微软雅黑", Font.PLAIN, 18);
        l2.setFont(font1);
        l2.setForeground(new Color(0, 0, 0));
        jf.getContentPane().add(l2);
        String card = "";
        JLabel l3 = new JLabel(" 卡号：" + card);
        l3.setBounds(30, 380, 250, 60);
        l3.setFont(font1);
        l3.setForeground(new Color(0, 0, 0));
        jf.getContentPane().add(l3);

        //label背景
        /*JLabel l11 = new JLabel();
        ImageIcon icon4 = new ImageIcon("src/image/PPT背景图1.jpg");
        l11.setIcon(icon4);
        l11.setBounds(15, 120, 285, 840);
        jf.getContentPane().add(l11);*/

        //东南大学标志图片
        /*JLabel logo = new JLabel();
        ImageIcon icon1 = new ImageIcon("src/image/logo-mini.png");
        logo.setIcon(icon1);
        logo.setBounds(315, 5, 210, 65);
        jf.getContentPane().add(logo);
        //右上角图标
        JLabel pic1 = new JLabel();
        ImageIcon icon2 = new ImageIcon("src/image/student.png");
        pic1.setIcon(icon2);
        pic1.setBounds(1100, 15, 25, 25);
        jf.getContentPane().add(pic1);
*/
        JButton btnNewButton_6 = new JButton("安全返回");
        btnNewButton_6.setBounds(1030, 125, 100, 30);
        Font myfont2 = new Font("微软雅黑", Font.PLAIN, 12);
        btnNewButton_6.setFont(myfont2);
        btnNewButton_6.setBackground(new Color(248, 248, 255));
        //btnNewButton_1.setForeground(new Color(248, 248, 255));
        btnNewButton_6.setContentAreaFilled(true);//设置按钮透明
        //btnNewButton_6.setBorder(null);//取消边框

        jf.getContentPane().add(btnNewButton_6);

        //横向图片
        JLabel l12 = new JLabel();
        ImageIcon icon5 = new ImageIcon("src/image/banner3.png");
        l12.setIcon(icon5);
        l12.setBounds(310, 70, 1000, 125);
        jf.getContentPane().add(l12);

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
        jf.getContentPane().add(p1);


        //文本编辑框（输入课程编号或课程名字）
        JLabel lblNewLabel = new JLabel("选课帮助:");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 35));
        lblNewLabel.setBounds(400, 125, 275, 35);
        jf.add(lblNewLabel);

        //文本编辑框（输入选课帮助）
        JLabel lblNewLabel2 = new JLabel("1、登陆选课系统，学生需根据培养方案进行选课");
        lblNewLabel2.setFont(new Font("宋体", Font.BOLD, 25));
        lblNewLabel2.setBounds(400, 235, 605, 35);
        jf.add(lblNewLabel2);

        //文本编辑框（输入选课帮助）
        JLabel lblNewLabel3 = new JLabel("2、每学期选择课程的学分和应不低于12学分");
        lblNewLabel3.setFont(new Font("宋体", Font.BOLD, 25));
        lblNewLabel3.setBounds(400, 305, 605, 35);
        jf.add(lblNewLabel3);

        //文本编辑框（输入选课帮助）
        JLabel lblNewLabel4 = new JLabel("3、教师有权利申报课程，经审核通过后可进行授课");
        lblNewLabel4.setFont(new Font("宋体", Font.BOLD, 25));
        lblNewLabel4.setBounds(400, 375, 605, 35);
        jf.add(lblNewLabel4);

        //文本编辑框（输入选课帮助）
        JLabel lblNewLabel5 = new JLabel("4、管理员有权增添、删除学生教师信息");
        lblNewLabel5.setFont(new Font("宋体", Font.BOLD, 25));
        lblNewLabel5.setBounds(400, 445, 605, 35);
        jf.add(lblNewLabel5);

        //文本编辑框（输入选课帮助）
        JLabel lblNewLabel6 = new JLabel("5、学生需要在选课系统开放的时间内完成选课");
        lblNewLabel6.setFont(new Font("宋体", Font.BOLD, 25));
        lblNewLabel6.setBounds(400, 515, 605, 35);
        jf.add(lblNewLabel6);

        //文本编辑框（输入选课帮助）
        JLabel lblNewLabel7 = new JLabel("6、若对选课系统有疑问，可致电咨询052-84196536");
        lblNewLabel7.setFont(new Font("宋体", Font.BOLD, 25));
        lblNewLabel7.setBounds(400, 585, 605, 35);
        jf.add(lblNewLabel7);

        //右下面板
        JPanel p3 = new JPanel();
        p3.setBounds(330, 200, 920, 585);
        p3.setBackground(new Color(211, 211, 211, 100));
        jf.getContentPane().add(p3);


        //右侧面板
        JPanel p2 = new JPanel();
        p2.setBounds(300, 0, 950, 1000);
        p2.setBackground(new Color(245, 245, 245, 180));
        jf.getContentPane().add(p2);

        //横向图片
        JLabel l16 = new JLabel();
        ImageIcon icon7 = new ImageIcon("src/image/background3.jpg");
        l16.setIcon(icon7);
        l16.setBounds(410, 20, 1273, 784);
        jf.getContentPane().add(l16);

        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

}
