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
import java.util.Arrays;

//加入限制：两次输入的密码必须一致
public class forgetPWD2{
    public static void forgetPWDUI2(String email,String id){
        JFrame jf=new JFrame("注册账号");

        //账号密码
        JLabel l1=new JLabel("新密码:");
        l1.setFont(new Font("等线",Font.BOLD,15));
        l1.setBounds(240,200,250,25);
        jf.add(l1);
        JPasswordField pwd=new JPasswordField();
        pwd.setFont(new Font("宋体",Font.BOLD,12));
        pwd.setBounds(310,200,125,25);
        jf.add(pwd);
        pwd.setColumns(10);

        JLabel l2=new JLabel("确认密码:");
        l2.setFont(new Font("等线",Font.BOLD,15));
        l2.setBounds(240,250,250,25);
        jf.add(l2);
        JPasswordField textField2=new JPasswordField();
        textField2.setFont(new Font("宋体",Font.BOLD,12));
        textField2.setBounds(310,250,125,25);
        jf.add(textField2);
        textField2.setColumns(10);

        JLabel l7=new JLabel("身份:");
        l7.setFont(new Font("等线",Font.BOLD,15));
        l7.setBounds(240,300,250,25);
        jf.add(l7);
        JComboBox<String> comboBox2 =new JComboBox<String>();
        comboBox2.setBounds(310,300,80,21);
        comboBox2.addItem("学生");
        comboBox2.addItem("教师");
        comboBox2.setEditable(false);//不可修改的文字
        jf.add(comboBox2);

        JButton b1=new JButton("确认修改");
        b1.setBounds(360,350,100,30);
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

