package UIviewer.SelectCourse;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ConsultCourse_Info extends JPanel {

    public static volatile String[][] search_result=null;
    public ConsultCourse_Info()
    {
        setLayout(null);
        //JPanel p17=new JPanel();
        //p17.setBounds(0,0,1273,784);

        /*JLabel touxiang = new JLabel();
        ImageIcon icon = new ImageIcon("src/image/logodz.png");
        touxiang.setIcon(icon);
        touxiang.setBounds(20, 200, 305, 96);
        p17.add(touxiang);*/

        //文字
        /*JLabel l1 = new JLabel("  你好！");
        l1.setBounds(170, 100, 100, 75);
        Font font = new Font("楷体", Font.BOLD, 22);
        l1.setFont(font);
        //l1.setForeground(new Color(111,222,0));
        add(l1);*/


        //信息面板
       /* JLabel l4 = new JLabel("      基本信息");
        l4.setBounds(23, 205, 250, 60);
        Font font2 = new Font("楷体", Font.BOLD, 25);
        l4.setFont(font2);
        l4.setForeground(new Color(94, 38, 18));
        add(l4);*/

       /* String name = "1";
        JLabel l2 = new JLabel(" 姓名：" + name);
        l2.setBounds(30, 300, 250, 60);
        Font font1 = new Font("微软雅黑", Font.PLAIN, 18);
        l2.setFont(font1);
        l2.setForeground(new Color(0, 0, 0));
        add(l2);
        String card = "";
        JLabel l3 = new JLabel(" 卡号：" + card);
        l3.setBounds(30, 410, 250, 60);
        l3.setFont(font1);
        l3.setForeground(new Color(0, 0, 0));
        add(l3);*/

        //label背景
        /*JLabel l11 = new JLabel();
        ImageIcon icon4 = new ImageIcon("src/image/PPT背景图5.jpg");
        l11.setIcon(icon4);
        l11.setBounds(15, 130, 285, 620);
        p11.add(l11);

        //东南大学标志图片
        JLabel logo = new JLabel();
        ImageIcon icon1 = new ImageIcon("src/image/logo-mini.png");
        logo.setIcon(icon1);
        logo.setBounds(315, 5, 210, 65);
        p11.add(logo);*/

        //横向图片
        /*JLabel l12 = new JLabel();
        ImageIcon icon5 = new ImageIcon("src/image/banner3.png");
        l12.setIcon(icon5);
        l12.setBounds(310, 70, 1000, 125);
        add(l12);*/

        String[] tableTitle={"课程编号","课程名","时间","任课老师","地点","学分"};
        DefaultTableModel dtm=new DefaultTableModel(search_result,tableTitle);
        JTable table_want=new JTable(dtm);
        JScrollPane jsp=new JScrollPane(table_want);
        jsp.setBounds(0,0,1280,680);
        add(jsp);
        table_want.setRowHeight(40);
        //add(table_want);


        //左侧面板
       /* JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 310, 784);
        p1.setBackground(new Color(135, 206, 250, 180));
        add(p1);*/

        //查询按钮
        JButton btnNewButton_9 = new JButton("查询");
        btnNewButton_9.setBounds(900, 335, 150, 60);
        Font myfont = new Font("微软雅黑", Font.BOLD, 20);
        btnNewButton_9.setFont(myfont);
        btnNewButton_9.setBackground(new Color(0, 220, 220));
        add(btnNewButton_9);

        //文本编辑框（输入课程编号或课程名字）
        JLabel lblNewLabel = new JLabel("课程信息:");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 35));
        lblNewLabel.setBounds(400, 135, 275, 35);
        add(lblNewLabel);

        JTextField textField = new JTextField();
        textField.setFont(new Font("宋体", Font.BOLD, 25));
        textField.setBounds(595, 135, 275, 35);
        add(textField);
        textField.setColumns(10);
        //五个按钮

        //右下面板
       /* JPanel p3 = new JPanel();
        p3.setBounds(310, 0, 950, 685);
        p3.setBackground(new Color(211, 211, 211, 100));
        add(p3);*/

        //右侧面板
       /* JPanel p2 = new JPanel();
        p2.setBounds(310, 0, 950, 1000);
        p2.setBackground(new Color(245, 245, 245, 180));
        add(p2);*/

        //横向图片
        /*JLabel l15 = new JLabel();
        ImageIcon icon6 = new ImageIcon("src/image/background4.jpg");
        l15.setIcon(icon6);
        l15.setBounds(0, 0, 1273, 790);
        p17.add(l15);*/



        //setLocationRelativeTo(null);


    }
}