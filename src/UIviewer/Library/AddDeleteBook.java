package UIviewer.Library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDeleteBook extends JPanel {

    public AddDeleteBook(){
        setLayout(null);
//dddddd
        //录入信息
        JLabel l = new JLabel("   录入书籍");
        l.setBounds(200, 10, 290, 80);
        Font font = new Font("楷体", Font.BOLD, 26);
        l.setFont(font);
        //l1.setForeground(new Color(111,222,0));
        add(l);
        //删除书籍
        JLabel l0 = new JLabel("  删除书籍");
        l0.setBounds(860, 180, 290, 80);
        l0.setFont(font);
        //l1.setForeground(new Color(111,222,0));
        add(l0);


        //账号密码
        JLabel l1 = new JLabel("书籍编号:");
        l1.setFont(new Font("宋体", Font.BOLD, 15));
        l1.setBounds(160, 120, 250, 25);
        add(l1);
        JTextField textField1=new JTextField();
        textField1.setFont(new Font("宋体", Font.BOLD, 12));
        textField1.setBounds(235, 120, 125, 25);
        add(textField1);
        textField1.setColumns(10);

        JLabel l2 = new JLabel("书名:");
        l2.setFont(new Font("宋体", Font.BOLD, 15));
        l2.setBounds(160, 160, 250, 25);
        add(l2);
        JTextField textField2=new JTextField();
        textField2.setFont(new Font("宋体", Font.BOLD, 12));
        textField2.setBounds(235, 160, 125, 25);
        add(textField2);
        textField2.setColumns(10);

        JLabel l3 = new JLabel("作者:");
        l3.setFont(new Font("宋体", Font.BOLD, 15));
        l3.setBounds(160, 200, 250, 25);
        add(l3);
        JTextField textField3=new JTextField();
        textField3.setFont(new Font("宋体", Font.BOLD, 12));
        textField3.setBounds(235, 200, 125, 25);
        add(textField3);
        textField3.setColumns(10);

        JLabel l4 = new JLabel("价格:");
        l4.setFont(new Font("宋体", Font.BOLD, 15));
        l4.setBounds(160, 240, 250, 25);
        add(l4);
        JTextField textField4=new JTextField();
        textField4.setFont(new Font("宋体", Font.BOLD, 12));
        textField4.setBounds(235, 240, 125, 25);
        add(textField4);
        textField4.setColumns(10);

        JLabel l5 = new JLabel("国家:");
        l5.setFont(new Font("宋体", Font.BOLD, 15));
        l5.setBounds(160, 280, 250, 25);
        add(l5);
        JTextField textField5=new JTextField();
        textField5.setFont(new Font("宋体", Font.BOLD, 12));
        textField5.setBounds(235, 280, 125, 25);
        add(textField5);
        textField5.setColumns(10);

        JLabel l6 = new JLabel("馆藏地:");
        l6.setFont(new Font("宋体", Font.BOLD, 15));
        l6.setBounds(160, 320, 250, 25);
        add(l6);
        JTextField textField6=new JTextField();
        textField6.setFont(new Font("宋体", Font.BOLD, 12));
        textField6.setBounds(235, 320, 125, 25);
        add(textField6);
        textField6.setColumns(10);

        JLabel l7 = new JLabel("出版社:");
        l7.setFont(new Font("宋体", Font.BOLD, 15));
        l7.setBounds(160, 360, 250, 25);
        add(l7);
        JTextField textField7=new JTextField();
        textField7.setFont(new Font("宋体", Font.BOLD, 12));
        textField7.setBounds(235, 360, 125, 25);
        add(textField7);
        textField7.setColumns(10);

        JButton b1=new JButton("确定录入");
        b1.setFont(new Font("楷体", Font.BOLD, 18));
        b1.setBounds(235,420,120,50);
        b1.setBackground(new Color(255,160,122));
        add(b1);


        //中间面板
        JPanel p = new JPanel();
        p.setBounds(150, 3, 290, 630);
        p.setBackground(new Color(233,150,122,150));
        add(p);




        JLabel l8 = new JLabel("书籍编号:");
        l8.setFont(new Font("宋体", Font.BOLD, 15));
        l8.setBounds(810, 280, 250, 25);
        add(l8);
        JTextField textField8=new JTextField();
        textField8.setFont(new Font("宋体", Font.BOLD, 12));
        textField8.setBounds(885, 280, 125, 25);
        add(textField8);
        textField8.setColumns(10);

        JButton b2=new JButton("确定删除");
        b2.setFont(new Font("楷体", Font.BOLD, 18));
        b2.setBounds(885,350,120,50);
        b2.setBackground(new Color(255,160,122));
        add(b2);

        //中间面板
        JPanel p0 = new JPanel();
        p0.setBounds(800, 180, 290, 250);
        p0.setBackground(new Color(233,150,122,150));
        add(p0);

        JPanel p11=new JPanel();
        p11.setBounds(0,0,630,650);
        JLabel pic1 = new JLabel();
        ImageIcon icon1 = new ImageIcon("src/image/bg17.jpg");
        pic1.setIcon(icon1);
        pic1.setBounds(0,0 , 630, 650);
        p11.add(pic1);
        add(p11);

        JPanel p12=new JPanel();
        p12.setBounds(630,0,660,650);
        JLabel pic2 = new JLabel();
        ImageIcon icon2 = new ImageIcon("src/image/bg17.jpg");
        pic2.setIcon(icon2);
        pic2.setBounds(630,0, 660, 650);
        p12.add(pic2);
        add(p12);
    }

}