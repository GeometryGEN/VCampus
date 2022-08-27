package UIviewer.Library;
import DAO.Library.Punishment;
import UIhandler.Library.Client_library;
import UIviewer.login.functionChoose;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class giveTicket extends JPanel {

    public giveTicket(){
        setLayout(null);

        //录入信息
        JLabel l = new JLabel("    罚单信息");
        l.setBounds(520, 10, 290, 80);
        Font font = new Font("楷体", Font.BOLD, 26);
        l.setFont(font);
        //l1.setForeground(new Color(111,222,0));
        add(l);

        JLabel l1 = new JLabel("罚单编号:");
        l1.setFont(new Font("宋体", Font.BOLD, 15));
        l1.setBounds(500, 160, 250, 25);
        add(l1);
        JTextField textField1=new JTextField();
        textField1.setFont(new Font("宋体", Font.BOLD, 12));
        textField1.setBounds(575, 160, 150, 25);
        add(textField1);
        textField1.setColumns(10);

        JLabel l2 = new JLabel("罚款金额:");
        l2.setFont(new Font("宋体", Font.BOLD, 15));
        l2.setBounds(500, 200, 250, 25);
        add(l2);
        JTextField textField2=new JTextField();
        textField2.setFont(new Font("宋体", Font.BOLD, 12));
        textField2.setBounds(575, 200, 150, 25);
        add(textField2);
        textField2.setColumns(10);

        JLabel l3 = new JLabel("罚款用户:");
        l3.setFont(new Font("宋体", Font.BOLD, 15));
        l3.setBounds(500, 240, 250, 25);
        add(l3);
        JTextField textField3=new JTextField();
        textField3.setFont(new Font("宋体", Font.BOLD, 12));
        textField3.setBounds(575, 240, 150, 25);
        add(textField3);
        textField3.setColumns(10);

        JLabel l4 = new JLabel("书籍编号:");
        l4.setFont(new Font("宋体", Font.BOLD, 15));
        l4.setBounds(500, 280, 250, 25);
        add(l4);
        JTextField textField4=new JTextField();
        textField4.setFont(new Font("宋体", Font.BOLD, 12));
        textField4.setBounds(575, 280, 150, 25);
        add(textField4);
        textField4.setColumns(10);

        JLabel l5 = new JLabel("罚款备注:");
        l5.setFont(new Font("宋体", Font.BOLD, 15));
        l5.setBounds(500, 320, 250, 25);
        add(l5);
        JTextField textField5=new JTextField();
        textField5.setFont(new Font("宋体", Font.BOLD, 12));
        textField5.setBounds(575, 320, 150, 25);
        add(textField5);
        textField5.setColumns(10);

        JButton b1=new JButton("确定提交");
        b1.setFont(new Font("楷体", Font.BOLD, 18));
        b1.setBounds(575,400,120,50);
        b1.setBackground(new Color(250,250,210));
        add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    Punishment p=new Punishment();
                    p.setPunishmentID(textField1.getText());
                    p.setPrice(Double.valueOf(textField2.getText()));
                    p.setCustomer_iD(textField3.getText());
                    p.setBook_id(textField4.getText());
                    p.setNotice(textField5.getText());
                    p.setStatus(0);
                    Client_library.RequireNewPunishment(p);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        //中间面板
        JPanel p3 = new JPanel();
        p3.setBounds(480, 0, 290, 620);
        p3.setBackground(new Color(255,228,181,150));
        add(p3);

        JPanel p12=new JPanel();
        p12.setBounds(300,0,685,660);
        JLabel pic2 = new JLabel();
        ImageIcon icon2 = new ImageIcon("src/image/bg13.jpg");
        pic2.setIcon(icon2);
        pic2.setBounds(300,0 , 685, 660);
        p12.add(pic2);
        add(p12);

        JPanel p11=new JPanel();
        p11.setBounds(0,0,1280,650);
        JLabel pic1 = new JLabel();
        ImageIcon icon1 = new ImageIcon("src/image/main3.jpg");
        pic1.setIcon(icon1);
        pic1.setBounds(0,0 , 1300, 650);
        p11.add(pic1);
        add(p11);


    }

}