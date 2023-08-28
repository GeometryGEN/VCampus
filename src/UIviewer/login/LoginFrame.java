package UIviewer.login;
import ClientToServer.ClientToServer;
import connection.JDBC_Connector;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static UIviewer.login.register.registerUI;
import static UIviewer.login.forgetPWD.forgetPWDUI;

/**
 * 登录框
 *
 * @author Tong_tuoyi
 * @date 2023/8/26
 */
public class LoginFrame extends JFrame{

    private ClientToServer ucs = new ClientToServer();
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JTextField textField;
    public static JPasswordField passwordField;

    public static JFrame jf = new JFrame("Login");

    /**
     * 登录框
     */
    public LoginFrame(){
        //背景图片
        JLabel lblBackground = new JLabel(); // 创建一个标签组件对象
        ImageIcon icon = new ImageIcon("src/image/登录/01.png"); // 创建背景图片对象
        lblBackground.setIcon(icon); // 设置标签组件要显示的图标
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // 设置组件的显示位置及大小

        jf.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        jf.setLocationRelativeTo(null);
        jf.getContentPane().add(lblBackground); // 将组件添加到面板中

/*
        //东南大学标志图片
        JLabel logo = new JLabel();
        ImageIcon icon1 = new ImageIcon("src/image/logo/03.png");
        logo.setIcon(icon1);
        logo.setBounds(-140, -300, 1500, 1500);
        jf.getContentPane().add(logo);



        //文字
        JLabel l1 = new JLabel("欢迎使用东南大学虚拟校园系统!");
        l1.setBounds(560, 120, 290, 80);
        Font font = new Font("宋体", Font.BOLD, 17);
        l1.setFont(font);
        //l1.setForeground(new Color(111,222,0));
        jf.getContentPane().add(l1);

        //账号密码
        JLabel lblNewLabel = new JLabel("用户名:");
        lblNewLabel.setIcon(new ImageIcon("src/image/用户名.png"));
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 15));
        lblNewLabel.setBounds(50, 280, 250, 25);
        jf.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("密  码:");
        lblNewLabel_1.setIcon(new ImageIcon("src/image/密码.png"));
        lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 15));
        lblNewLabel_1.setBounds(50, 315, 250, 25);
        jf.add(lblNewLabel_1);

        textField=new JTextField();
        textField.setFont(new Font("宋体", Font.BOLD, 12));
        textField.setBounds(140, 285, 125, 20);
        jf.add(textField);
        textField.setColumns(10);

        passwordField=new JPasswordField();
        passwordField.setFont(new Font("宋体", Font.BOLD, 12));
        passwordField.setBounds(140, 310, 125, 20);
        jf.add(passwordField);

 */

        //三个按钮
        // 学生登录
        JButton btnNewButton_1 = new JButton("学生登录");
        btnNewButton_1.setBounds(50, 380, 220, 30);
        Font myfont = new Font("楷体", Font.PLAIN, 20);
        btnNewButton_1.setFont(myfont);
        btnNewButton_1.setBackground(new Color(34, 139, 34));
        btnNewButton_1.setForeground(new Color(248, 248, 255));
        btnNewButton_1.setFocusPainted(false);
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    String username=textField.getText();
                    String pwd=String.valueOf(passwordField.getPassword());
                    if(ucs.checkStudent(username,pwd)) {
                        System.out.println(username+"登录成功！");
                        functionChoose.functionChooseUI();
                        jf.setVisible(false);
                    }else
                        JOptionPane.showMessageDialog(p1, "用户名或密码错误,请重试!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        jf.getContentPane().add(btnNewButton_1);
        // 教师登录
        JButton btnNewButton_2 = new JButton("教师登录");
        btnNewButton_2.setBounds(50, 430, 220, 30);
        btnNewButton_2.setFont(myfont);
        btnNewButton_2.setBackground(new Color(34, 139, 34));
        btnNewButton_2.setForeground(new Color(248, 248, 255));
        btnNewButton_2.setFocusPainted(false);
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    String username=textField.getText();
                    String pwd=String.valueOf(passwordField.getPassword());
                    if(ucs.checkTeacher(username,pwd)) {
                        System.out.println(username+"登录成功！");
                        functionChoose.functionChooseUI();
                        jf.setVisible(false);
                    }else
                        JOptionPane.showMessageDialog(p1, "用户名或密码错误,请重试!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        jf.getContentPane().add(btnNewButton_2);
        // 管理员登录
        JButton btnNewButton_3 = new JButton("管理员登录");
        btnNewButton_3.setBounds(50, 480, 220, 30);
        btnNewButton_3.setFont(myfont);
        btnNewButton_3.setBackground(new Color(34, 139, 34));
        btnNewButton_3.setForeground(new Color(248, 248, 255));
        btnNewButton_3.setFocusPainted(false);
        btnNewButton_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    String username=textField.getText();
                    String pwd=String.valueOf(passwordField.getPassword());
                    if(ucs.checkAdmin(username,pwd)) {
                        System.out.println(username+"登录成功！");
                        functionChoose.functionChooseUI();
                        jf.setVisible(false);
                    }else
                        JOptionPane.showMessageDialog(p1, "用户名或密码错误,请重试!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        jf.getContentPane().add(btnNewButton_3);

        //注册
        JButton btnNewButton_4 = new JButton("注册");
        btnNewButton_4.setBounds(150, 550, 220, 30);
        Font myfont1 = new Font("宋体 ", Font.PLAIN, 14);
        btnNewButton_4.setFont(myfont1);
        btnNewButton_4.setContentAreaFilled(false);//设置按钮透明
        btnNewButton_4.setBorder(null);//取消边框
        btnNewButton_4.setFocusPainted(false);
        btnNewButton_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    registerUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        jf.getContentPane().add(btnNewButton_4);
        //忘记密码
        JButton btnNewButton_5 = new JButton("忘记密码");
        btnNewButton_5.setBounds(150, 570, 220, 30);
        btnNewButton_5.setFont(myfont1);
        btnNewButton_5.setContentAreaFilled(false);//设置按钮透明
        btnNewButton_5.setBorder(null);//取消边框
        btnNewButton_5.setFocusPainted(false);
        btnNewButton_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    forgetPWDUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        jf.getContentPane().add(btnNewButton_5);


        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }


    /**
     * 主要
     *
     * @param args arg游戏
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
           //         JDBC_Connector.first_connect();
                    LoginFrame frame = new LoginFrame();
                    // frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
