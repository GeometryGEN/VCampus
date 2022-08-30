package UIviewer.SelectCourse;

import ClientToServer.myInfo;
import DAO.Curriculum.Opencourse;
import UIhandler.Currirulum.Client_curriculum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Declare_Course extends JPanel{

    public Declare_Course()
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

        //label背景
        /*JLabel l11 = new JLabel();
        ImageIcon icon4 = new ImageIcon("src/image/PPT背景图5.jpg");
        l11.setIcon(icon4);
        l11.setBounds(15, 130, 285, 680);
        jf.getContentPane().add(l11);*/


        /*JButton btnNewButton_6 = new JButton("安全返回");
        btnNewButton_6.setBounds(1040, 45, 100, 30);
        Font myfont2 = new Font("微软雅黑", Font.PLAIN, 16);
        btnNewButton_6.setFont(myfont2);
        btnNewButton_6.setBackground(new Color(248, 248, 255));
        //btnNewButton_1.setForeground(new Color(248, 248, 255));
        btnNewButton_6.setContentAreaFilled(true);//设置按钮透明
        //btnNewButton_6.setBorder(null);//取消边框

        add(btnNewButton_6);*/

        //横向图片
       /* JLabel l12 = new JLabel();
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
        JLabel lblNewLabel = new JLabel("申报课程");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 45));
        lblNewLabel.setBounds(360, 45, 275, 45);
        add(lblNewLabel);

       /* JTextField textField = new JTextField();
        textField.setFont(new Font("宋体", Font.BOLD, 12));
        textField.setBounds(550, 125, 275, 35);
        jf.add(textField);
        textField.setColumns(10);*/

        JLabel lblNewLabel1 = new JLabel("课程编号:");
        lblNewLabel1.setFont(new Font("宋体", Font.BOLD, 30));
        lblNewLabel1.setBounds(400, 125, 275, 35);
        add(lblNewLabel1);

        JTextField textField1 = new JTextField();
        textField1.setFont(new Font("宋体", Font.BOLD, 22));
        textField1.setBounds(600, 125, 275, 35);
        add(textField1);
        textField1.setColumns(10);

        JLabel lblNewLabel2 = new JLabel("课程名:");
        lblNewLabel2.setFont(new Font("宋体", Font.BOLD, 30));
        lblNewLabel2.setBounds(400, 225, 275, 35);
        add(lblNewLabel2);

        JTextField textField2 = new JTextField();
        textField2.setFont(new Font("宋体", Font.BOLD, 22));
        textField2.setBounds(600, 225, 275, 35);
        add(textField2);
        textField2.setColumns(10);

        JLabel lblNewLabel3 = new JLabel("课程学分:");
        lblNewLabel3.setFont(new Font("宋体", Font.BOLD, 30));
        lblNewLabel3.setBounds(400, 325, 275, 35);
        add(lblNewLabel3);

        JTextField textField3 = new JTextField();
        textField3.setFont(new Font("宋体", Font.BOLD, 22));
        textField3.setBounds(600, 325, 275, 35);
        add(textField3);
        textField3.setColumns(10);


        JButton btnNewButton_7 = new JButton("申报");
        btnNewButton_7.setBounds(680, 605, 150, 30);
        Font myfont3 = new Font("微软雅黑", Font.PLAIN, 16);
        btnNewButton_7.setFont(myfont3);
        btnNewButton_7.setBackground(new Color(248, 248, 255));
        //btnNewButton_1.setForeground(new Color(248, 248, 255));
        btnNewButton_7.setContentAreaFilled(true);//设置按钮透明
        //btnNewButton_6.setBorder(null);//取消边框
        add(btnNewButton_7);
        btnNewButton_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Opencourse opc=new Opencourse();
                    opc.setName(textField2.getText());
                    opc.setPoint(Double.valueOf(textField3.getText()));
                    Client_curriculum.apply(opc);
                    JOptionPane.showMessageDialog(null,"课程申报成功！");

                }catch(Exception ex){
                    ex.printStackTrace();
                }
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
            }
        });
        //五个按钮
        //右下面板

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

        JLabel l16 = new JLabel();
        ImageIcon icon7 = new ImageIcon("src/image/background4.jpg");
        l16.setIcon(icon7);
        l16.setBounds(0, 0, 1273, 790);
        add(l16);

        add(p11);
    }
}
