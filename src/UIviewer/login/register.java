package UIviewer.login;
import ClientToServer.ClientToServer;
import DAO.Login.Mail;
import UIviewer.Library.readLib;
import User.Student;
import User.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Objects;

import static UIviewer.login.register2.registerUI2;
import static DAO.Login.Mail.*;

/**
 * 注册
 *
 * @author Chen_GuanZhi
 * @date 2022/09/03
 */

public class register {

    public static String captcha;//验证码
    public static String idcard;//一卡通

    Color color1=new Color(31,66,71);
    Color color2=new Color(125,182,191);
    Color color3=new Color(111,150,134);
    Color color4=new Color(207,219,212);
    Font myfont1=new Font("等线", Font.BOLD, 17);
    Font myfont2=new Font("等线", Font.BOLD, 15);
    /**
     * 注册界面
     */
    public static void registerUI(){
        JFrame jf=new JFrame("注册账号");

        //注册信息
        JLabel l2=new JLabel("注册邮箱");
        l2.setBounds(300,50,290,80);
        Font font=new Font("等线",Font.BOLD,26);
        l2.setFont(font);
        //l1.setForeground(new Color(111,222,0));
        jf.getContentPane().add(l2);

        //账号密码
        JLabel l3=new JLabel("一卡通:");
        l3.setFont(new Font("等线",Font.BOLD,18));
        l3.setBounds(260,130,250,25);
        jf.add(l3);
        JTextField textField3=new JTextField();
        textField3.setFont(new Font("宋体",Font.BOLD,17));
        textField3.setBounds(325,130,120,25);
        jf.add(textField3);
        textField3.setColumns(10);

        JLabel l10=new JLabel("邮箱:");
        l10.setFont(new Font("等线",Font.BOLD,18));
        l10.setBounds(260,180,250,25);
        jf.add(l10);
        JTextField textField10=new JTextField();
        textField10.setFont(new Font("宋体",Font.BOLD,15));
        textField10.setBounds(325,180,120,25);
        jf.add(textField10);
        textField10.setColumns(10);

        //填写验证码的地方
        JTextField textField11=new JTextField();
        textField11.setFont(new Font("宋体",Font.BOLD,17));
        textField11.setBounds(260,230,70,25);
        jf.add(textField11);
        textField10.setColumns(11);
        //发送验证码
        JButton b2=new JButton("发送验证码");
        b2.setFont(new Font("等线",Font.BOLD,15));
        b2.setBounds(336,230,110,25);
        b2.setBackground(new Color(235,236,240));
        b2.setFocusPainted(false);
        jf.add(b2);
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    idcard = textField3.getText(); //一卡通号
                    String mail = textField10.getText(); //邮箱
                    if (idcard == null || (mail.isEmpty())) {
                        JOptionPane.showMessageDialog(jf, "信息填写不完整，请重新填写!");
                    }
                    //registerUI2();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                String mail = textField10.getText();
                try{
                    Mail send_mail=new Mail(mail);
                    captcha=send_mail.getVerifiCode();
                }catch (Exception a){
                    a.printStackTrace();
                }
            }
        });

        JButton b1=new JButton("确认");
        b1.setBounds(360,290,100,30);
        b1.setBackground(new Color(235,236,240));
        b1.setFocusPainted(false);

        //点击确认之后对比输入的验证码是否正确，若正确调用注册的函数
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mycaptcha=textField11.getText();//填验证码的文本框
                //测试中先直接点进去，不用验证
                //jf.setVisible(false);
                //registerUI2(textField10.getText(),textField3.getText());
                if(true)
                //if(Objects.equals(mycaptcha, captcha))
                {
                    //继续注册
                    jf.setVisible(false);
                    try {
                        registerUI2(textField10.getText(),textField3.getText());
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else{
                    //报填写错误，验证码不对
                    JOptionPane.showMessageDialog(jf, "验证码错误，请选择重新发送!");
                }


            }
        });
        jf.add(b1);


        //背景图片s
        JLabel lblBackground=new JLabel(); // 创建一个标签组件对象
        ImageIcon icon=new ImageIcon("src/image/登录/04.png"); // 创建背景图片对象
        lblBackground.setIcon(icon); // 设置标签组件要显示的图标
        lblBackground.setBounds(50,0,icon.getIconWidth(),icon.getIconHeight()); // 设置组件的显示位置及大小
        jf.getContentPane().add(lblBackground);

        jf.setBounds(0,0,690,620);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);
        }

        public static String getIdCard(){
            return idcard;
        }

}

