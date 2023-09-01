package UIviewer.login;
import ClientToServer.ClientToServer;
import User.Student;
import User.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Arrays;
import utils.Save_image.*;

//加入限制：两次输入的密码必须一致
public class register2 {
    public static void registerUI2(String email,String id) throws SQLException, FileNotFoundException {
        JFrame jf=new JFrame("注册账号");

        //添加头像
        JFileChooser choose_image=new JFileChooser();
        choose_image.setFileSelectionMode(JFileChooser.FILES_ONLY);
        choose_image.showOpenDialog(null);
        choose_image.setBounds(10,10,200,200);
        jf.add(choose_image);

        JButton save_image=new JButton("保存图片");
        save_image.setBounds(10,100,200,200);
        jf.add(save_image);
        save_image.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file=choose_image.getSelectedFile();
                try {
                    String path=file.getAbsolutePath();
                    utils.Save_image.main(path,register.getIdCard());
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //账号密码
        JLabel l1=new JLabel("密码:");
        l1.setFont(new Font("等线",Font.BOLD,15));
        l1.setBounds(240,100,250,25);
        jf.add(l1);
        JPasswordField pwd=new JPasswordField();
        pwd.setFont(new Font("宋体",Font.BOLD,12));
        pwd.setBounds(310,100,125,25);
        jf.add(pwd);
        pwd.setColumns(10);

        JLabel l2=new JLabel("确认密码:");
        l2.setFont(new Font("等线",Font.BOLD,15));
        l2.setBounds(240,150,250,25);
        jf.add(l2);
        JPasswordField textField2=new JPasswordField();
        textField2.setFont(new Font("宋体",Font.BOLD,12));
        textField2.setBounds(310,150,125,25);
        jf.add(textField2);
        textField2.setColumns(10);

        JLabel l3=new JLabel("姓名:");
        l3.setFont(new Font("等线",Font.BOLD,15));
        l3.setBounds(240,200,250,25);
        jf.add(l3);
        JTextField textField3=new JTextField();
        textField3.setFont(new Font("宋体",Font.BOLD,12));
        textField3.setBounds(310,200,125,25);
        jf.add(textField3);
        textField3.setColumns(10);

        JLabel l4=new JLabel("学/工号:");
        l4.setFont(new Font("等线",Font.BOLD,15));
        l4.setBounds(240,250,250,25);
        jf.add(l4);
        JTextField textField4=new JTextField();
        textField4.setFont(new Font("宋体",Font.BOLD,12));
        textField4.setBounds(310,250,125,25);
        jf.add(textField4);
        textField4.setColumns(10);

        JLabel l5=new JLabel("年龄:");
        l5.setFont(new Font("等线",Font.BOLD,15));
        l5.setBounds(240,300,250,25);
        jf.add(l5);
        JTextField textField5=new JTextField();
        textField5.setFont(new Font("宋体",Font.BOLD,12));
        textField5.setBounds(310,300,125,25);
        jf.add(textField5);
        textField5.setColumns(10);

        JLabel l6=new JLabel("性别:");
        l6.setFont(new Font("等线",Font.BOLD,15));
        l6.setBounds(240,350,250,25);
        jf.add(l6);
        JComboBox<String> comboBox1 =new JComboBox<String>();
        comboBox1.setBounds(310,350,80,21);
        comboBox1.addItem("男");
        comboBox1.addItem("女");
        comboBox1.setEditable(false);//不可修改的文字
        jf.add(comboBox1);
        //comboBox.getSelectedItem

        JLabel l7=new JLabel("身份:");
        l7.setFont(new Font("等线",Font.BOLD,15));
        l7.setBounds(240,400,250,25);
        jf.add(l7);
        JComboBox<String> comboBox2 =new JComboBox<String>();
        comboBox2.setBounds(310,400,80,21);
        comboBox2.addItem("学生");
        comboBox2.addItem("教师");
        comboBox2.setEditable(false);//不可修改的文字
        jf.add(comboBox2);


        JButton b1=new JButton("确定注册");
        b1.setBounds(360,450,100,30);
        b1.setBackground(new Color(235,236,240));
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

//随机背景图片
        JLabel lblBackground=new JLabel(); // 创建一个标签组件对象
        ImageIcon icon=new ImageIcon("src/image/登录/04.png"); // 创建背景图片对象
        lblBackground.setIcon(icon); // 设置标签组件要显示的图标
        lblBackground.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight()); // 设置组件的显示位置及大小
        jf.getContentPane().add(lblBackground);

        jf.setBounds(0,0,690,620);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);

    }
}
