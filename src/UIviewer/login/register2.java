package UIviewer.login;
import ClientToServer.ClientToServer;
import User.Student;
import User.Teacher;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import net.coobird.thumbnailator.Thumbnails;
import utils.Save_image.*;

//加入限制：两次输入的密码必须一致
public class register2 {
    static Color color1=new Color(31,66,71);
    static Color color2=new Color(125,182,191);
    static Color color3=new Color(111,150,134);
    static Color color4=new Color(207,219,212);
    static Font myfont1=new Font("等线", Font.BOLD, 17);
    static Font myfont2=new Font("等线", Font.BOLD, 15);

    public static void registerUI2(String email,String id) throws SQLException, FileNotFoundException {
        JFrame jf=new JFrame("注册账号");

        //添加头像
        final File[] file = {null};
        JButton b2=new JButton("添加头像");
        b2.setBounds(110,520,100,30);
        b2.setForeground(color1);
        b2.setBackground(color4);
        b2.setFont(myfont2);
        b2.setFocusPainted(false);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    JFileChooser choose_image=new JFileChooser();
                    choose_image.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    choose_image.showOpenDialog(null);
                    choose_image.setBounds(10,10,200,200);
                    file[0] =choose_image.getSelectedFile();
                    jf.add(choose_image);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        JButton save_image=new JButton("保存图片");
        save_image.setForeground(color1);
        save_image.setBackground(color4);
        save_image.setFont(myfont2);
        save_image.setBounds(235,520,100,30);
        jf.add(save_image);
        save_image.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //File file=choose_image.getSelectedFile();
                try {
                    String path= file[0].getAbsolutePath();
                    utils.Save_image.main(path,register.getIdCard());
                    JOptionPane.showMessageDialog(jf, "保存图片成功");
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        jf.add(b2);


        //账号密码
        JLabel l1=new JLabel("密码:");
        l1.setFont(new Font("等线",Font.BOLD,18));
        l1.setForeground(color1);
        l1.setBounds(110,420,100,25);
        jf.add(l1);
        JPasswordField pwd=new JPasswordField();
        pwd.setFont(new Font("宋体",Font.BOLD,17));
        pwd.setBounds(210,420,125,25);
        jf.add(pwd);
        pwd.setColumns(10);

        JLabel l2=new JLabel("确认密码:");
        l2.setFont(new Font("等线",Font.BOLD,18));
        l2.setForeground(color1);
        l2.setBounds(110,470,100,25);
        jf.add(l2);
        JPasswordField textField2=new JPasswordField();
        textField2.setFont(new Font("宋体",Font.BOLD,17));
        textField2.setBounds(210,470,125,25);
        jf.add(textField2);
        textField2.setColumns(10);

        JLabel l3=new JLabel("姓名:");
        l3.setFont(new Font("等线",Font.BOLD,18));
        l3.setForeground(color1);
        l3.setBounds(110,220,100,25);
        jf.add(l3);
        JTextField textField3=new JTextField();
        textField3.setFont(new Font("宋体",Font.BOLD,17));
        textField3.setBounds(210,220,125,25);
        jf.add(textField3);
        textField3.setColumns(10);

        JLabel l4=new JLabel("学/工号:");
        l4.setFont(new Font("等线",Font.BOLD,18));
        l4.setForeground(color1);
        l4.setBounds(110,270,100,25);
        jf.add(l4);
        JTextField textField4=new JTextField();
        textField4.setFont(new Font("宋体",Font.BOLD,17));
        textField4.setBounds(210,270,125,25);
        jf.add(textField4);
        textField4.setColumns(10);

        JLabel l5=new JLabel("年龄:");
        l5.setFont(new Font("等线",Font.BOLD,18));
        l5.setForeground(color1);
        l5.setBounds(110,320,100,25);
        jf.add(l5);
        JTextField textField5=new JTextField();
        textField5.setFont(new Font("宋体",Font.BOLD,17));
        textField5.setBounds(210,320,125,25);
        jf.add(textField5);
        textField5.setColumns(10);

        JLabel l6=new JLabel("性别:");
        l6.setFont(new Font("等线",Font.BOLD,18));
        l6.setForeground(color1);
        l6.setBounds(110,370,50,25);
        jf.add(l6);
        JComboBox<String> comboBox1 =new JComboBox<String>();
        comboBox1.setBounds(160,370,50,21);
        comboBox1.addItem("男");
        comboBox1.addItem("女");
        comboBox1.setEditable(false);//不可修改的文字
        jf.add(comboBox1);
        //comboBox.getSelectedItem

        JLabel l7=new JLabel("身份:");
        l7.setFont(new Font("等线",Font.BOLD,18));
        l7.setForeground(color1);
        l7.setBounds(225,370,50,25);
        jf.add(l7);
        JComboBox<String> comboBox2 =new JComboBox<String>();
        comboBox2.setBounds(275,370,60,21);
        comboBox2.addItem("学生");
        comboBox2.addItem("教师");
        comboBox2.setEditable(false);//不可修改的文字
        jf.add(comboBox2);

        JButton b1=new JButton("确定注册");
        b1.setBounds(110,570,225,30);
        b1.setBackground(color3);
        b1.setForeground(Color.white);
        b1.setFont(new Font("楷体", Font.PLAIN, 25));
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
                    String name=textField3.getText();
                    String xuehao=textField4.getText();
                    int age=0;
                    if(textField5.getText().length()!=0)
                        age=Integer.parseInt(textField5.getText());
                    String mail=email;
                    String gender=(String)comboBox1.getSelectedItem();
                    String identity=(String)comboBox2.getSelectedItem();
                    if(idcard==null||name==null||passwd==null||xuehao==null||age==0||(mail.length()==0)||gender==null||identity==null){
                        JOptionPane.showMessageDialog(jf, "信息填写不完整，请重新填写!");
                        flag=false;
                    }
                    if(!Arrays.equals(pwd.getPassword(), textField2.getPassword())){
                        JOptionPane.showMessageDialog(jf, "两次输入密码不一致！");
                        flag=false;
                    }
                    else if(identity=="学生"&& flag) {
                        Student s = new Student();
                        s.setStudent_idcard(idcard);
                        s.setStudent_pwd(passwd);
                        s.setStudent_name(name);
                        s.setStudent_id(xuehao);
                        s.setStudent_age(age);
                        s.setStudent_email(mail);
                        s.setStudent_gender(gender);
                        if(ClientToServer.registerStudent(s)) {
                            //    System.out.println("学生"+name+"注册成功！");
                            JOptionPane.showMessageDialog(jf, "注册成功!");
                            jf.dispose();
                        }
                    }
                    else if(identity=="教师"&& flag) {
                        Teacher t = new Teacher();
                        t.setTeacher_idcard(idcard);
                        t.setTeacher_pwd(passwd);
                        t.setTeacher_name(name);
                        t.setTeacher_id(xuehao);
                        t.setTeacher_gender(gender);
                        t.setTeacher_email(mail);
                        t.setTeacher_age(age);
                        if(ClientToServer.registerTeacher(t)) {
                            System.out.println("教师"+name+"注册成功！");
                            JOptionPane.showMessageDialog(jf, "注册成功!");
                            jf.dispose();
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        jf.add(b1);

        JPanel p11=new JPanel();
        p11.setBounds(0,0, 450, 200);
        JLabel pic1 = new JLabel();
        int icon1_width= 450;
        int icon1_height=200;
        //裁减2到min的尺寸
        try {
            Thumbnails.of(new File("src/image/登录/13.jpg"))
                    .size((int)(icon1_width), (int)(icon1_height))
                    .keepAspectRatio(false)
                    .toFile(new File("src/image/登录/14_fit.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pic1.setIcon(new ImageIcon("src/image/登录/14_fit.jpg"));
        pic1.setBounds(0,-15 ,450,200);
        p11.add(pic1);
        p11.setBackground(color4);
        jf.add(p11);

        jf.setBackground(color4);
        jf.setBounds(0,0,450,680);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);

    }
}
