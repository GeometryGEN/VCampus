package UIviewer.login;
import ClientToServer.ClientToServer;
import User.Student;
import User.Teacher;
import net.coobird.thumbnailator.Thumbnails;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

//加入限制：两次输入的密码必须一致
public class forgetPWD2{
    static Color color1=new Color(31,66,71);
    static Color color2=new Color(125,182,191);
    static Color color3=new Color(111,150,134);
    static Color color4=new Color(207,219,212);
    static Font myfont1=new Font("等线", Font.BOLD, 17);
    static Font myfont2=new Font("等线", Font.BOLD, 15);

    public static void forgetPWDUI2(String email,String id){
        JFrame jf=new JFrame("注册账号");

        //账号密码
        JLabel l1=new JLabel("新密码:");
        l1.setFont(new Font("等线",Font.BOLD,15));
        l1.setForeground(color1);
        l1.setBounds(240,100,250,25);
        jf.add(l1);
        JPasswordField pwd=new JPasswordField();
        pwd.setFont(new Font("宋体",Font.BOLD,12));
        pwd.setBounds(310,100,125,25);
        jf.add(pwd);
        pwd.setColumns(10);

        JLabel l2=new JLabel("确认密码:");
        l2.setFont(new Font("等线",Font.BOLD,15));
        l2.setForeground(color1);
        l2.setBounds(240,150,250,25);
        jf.add(l2);
        JPasswordField textField2=new JPasswordField();
        textField2.setFont(new Font("宋体",Font.BOLD,12));
        textField2.setBounds(310,150,125,25);
        jf.add(textField2);
        textField2.setColumns(10);

        JLabel l7=new JLabel("身份:");
        l7.setFont(new Font("等线",Font.BOLD,15));
        l7.setForeground(color1);
        l7.setBounds(240,200,250,25);
        jf.add(l7);
        JComboBox<String> comboBox2 =new JComboBox<String>();
        comboBox2.setBounds(310,200,80,21);
        comboBox2.addItem("学生");
        comboBox2.addItem("教师");
        comboBox2.setEditable(false);//不可修改的文字
        jf.add(comboBox2);

        JButton b1=new JButton("确认修改");
        b1.setBounds(360,250,100,30);
        b1.setBackground(color3);
        b1.setForeground(Color.white);
        b1.setFocusPainted(false);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    Boolean flag=true;//信息是否正常
                    String idcard=id;
                    String passwd=null;
                    if(pwd.getPassword().length>0)
                        passwd=String.valueOf(pwd.getPassword());
                    String mail=email;
                    String identity=(String)comboBox2.getSelectedItem();
                    if(idcard==null||passwd==null||(mail.isEmpty())||identity==null){
                        JOptionPane.showMessageDialog(jf, "信息填写不完整，请重新填写!");
                        flag=false;
                    }
                    if(!Arrays.equals(pwd.getPassword(), textField2.getPassword())){
                        JOptionPane.showMessageDialog(jf, "两次输入密码不一致！");
                        flag=false;
                    }
                    if(flag) {
                        ClientToServer.resetPwd(idcard, passwd, identity);
                        JOptionPane.showMessageDialog(null,"修改密码成功！");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"验证错误，请重新尝试！");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        jf.add(b1);

        JPanel p11=new JPanel();
        p11.setBounds(0,0, 400, 200);
        JLabel pic1 = new JLabel();
        int icon1_width= 400;
        int icon1_height=200;
        //裁减2到min的尺寸
        try {
            Thumbnails.of(new File("src/image/登录/13.jpg"))
                    .size((int)(icon1_width), (int)(icon1_height))
                    .keepAspectRatio(false)
                    .toFile(new File("src/image/登录/16_fit.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pic1.setIcon(new ImageIcon("src/image/登录/16_fit.jpg"));
        pic1.setBounds(0,-15 ,400,200);
        p11.add(pic1);
        p11.setBackground(color4);
        jf.add(p11);

        jf.setBackground(color4);
        jf.setBounds(0,0,400,650);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);

    }
}

