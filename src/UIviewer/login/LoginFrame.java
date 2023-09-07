package UIviewer.login;
import ClientToServer.ClientToServer;
import connection.JDBC_Connector;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static UIviewer.login.register.registerUI;
import static UIviewer.login.forgetPWD.forgetPWDUI;
import static UIviewer.login.forgetPWD.forgetPWDUI;//之后改为修改密码UI函数

/**
 * 登录框
 *
 * @author Tong_tuoyi
 * @date 2023/8/26
 */
//#7DB6BF 125,182,191 薄荷绿色

public class LoginFrame extends JFrame{

    private ClientToServer ucs = new ClientToServer();
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JTextField textField;
    public static JPasswordField passwordField;

    public static JFrame jf = new JFrame("登录");

    /**
     * 登录框
     */
    public LoginFrame(){
        //背景图片
        JLabel lblBackground = new JLabel(); // 创建一个标签组件对象
        ImageIcon icon = new ImageIcon("src/image/登录/05.png"); // 创建背景图片对象
        lblBackground.setIcon(icon); // 设置标签组件要显示的图标
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // 设置组件的显示位置及大小

        jf.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        jf.setLocationRelativeTo(null);


        //账号密码
        JLabel lblNewLabel = new JLabel("一卡通号:");
        lblNewLabel.setIcon(new ImageIcon("src/image/用户名.png"));
        lblNewLabel.setFont(new Font("等线", Font.BOLD, 17));
        lblNewLabel.setForeground(new Color(235,236,240));
        lblNewLabel.setBounds(900, 280, 250, 25);
        jf.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("密  码:");
        lblNewLabel_1.setIcon(new ImageIcon("src/image/密码.png"));
        lblNewLabel_1.setFont(new Font("等线", Font.BOLD, 17));
        lblNewLabel_1.setForeground(new Color(235,236,240));
        lblNewLabel_1.setBounds(900, 325, 250, 25);
        jf.add(lblNewLabel_1);

        textField=new JTextField();
        textField.setFont(new Font("宋体", Font.BOLD, 16));
        textField.setBounds(1000, 285, 125, 20);
        textField.setBackground(new Color(125,182,191));
        //textField.setBorder(null);
        jf.add(textField);
        //textField.setColumns(10);

        passwordField=new JPasswordField();
        passwordField.setFont(new Font("宋体", Font.BOLD, 16));
        passwordField.setBounds(1000, 325, 125, 20);
        passwordField.setBackground(new Color(125,182,191));
        //passwordField.setBorder(null);
        jf.add(passwordField);
        //passwordField.setColumns(10);

        //boolean choice;
        JLabel chooselabel = new JLabel("请选择您的身份： ");
        chooselabel.setFont(new Font("等线", Font.BOLD, 20));
        chooselabel.setForeground(new Color(235,236,240));
        chooselabel.setBounds(900,395,180,20);
        jf.add(chooselabel);
        JRadioButton rbtnstu= new JRadioButton("学生",false);
        rbtnstu.setFont(new Font("等线", Font.BOLD, 20));
        rbtnstu.setForeground(new Color(235,236,240));
        //rbtnstu.setSelected(true);
        rbtnstu.setContentAreaFilled(false);
        rbtnstu.setBounds(900,430,75,22);
        jf.add(rbtnstu);
        JRadioButton rbtntea= new JRadioButton("教师",false);
        rbtntea.setFont(new Font("等线", Font.BOLD, 20));
        rbtntea.setForeground(new Color(235,236,240));
        //rbtntea.setSelected(true);
        rbtntea.setContentAreaFilled(false);
        rbtntea.setBounds(1000,430,75,22);
        jf.add(rbtntea);
        ButtonGroup group1=new ButtonGroup();
        group1.add(rbtnstu);
        group1.add(rbtntea);

        //登录
        JButton btnNewButton_1 = new JButton("登录");
        btnNewButton_1.setBounds(900, 500, 220, 30);
        Font myfont = new Font("楷体", Font.PLAIN, 25);
        btnNewButton_1.setFont(myfont);
        //btnNewButton_1.setBackground(new Color(34, 139, 34));
        btnNewButton_1.setBackground(new Color(125,182,191));
        btnNewButton_1.setForeground(new Color(248, 248, 255));
        btnNewButton_1.setFocusPainted(false);
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    String username=textField.getText();
                    String pwd=String.valueOf(passwordField.getPassword());
                    if(rbtnstu.isSelected()) {
                        if (ucs.checkStudent(username, pwd)) {
                        //if (true) {
                            System.out.println(username + "登录成功！");
                            functionChoose.functionChooseUI();
                            jf.setVisible(false);
                        } else
                            JOptionPane.showMessageDialog(p1, "用户名或密码错误,请重试!");
                    }
                    else if (rbtntea.isSelected()) {
                        if(ucs.checkTeacher(username,pwd)) {
                            System.out.println(username+"登录成功！");
                            functionChoose.functionChooseUI();
                            jf.setVisible(false);}
                            else
                            JOptionPane.showMessageDialog(p1, "用户名或密码错误,请重试!");
                        }
                    else if (ucs.checkAdmin(username,pwd)) {
                                System.out.println(username+"登录成功！");
                                functionChoose.functionChooseUI();
                                jf.setVisible(false);
                            }
                    else
                        JOptionPane.showMessageDialog(p1, "身份选择错误,请重试!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        jf.getContentPane().add(btnNewButton_1);


        // 管理员登录
        JButton btnNewButton_3 = new JButton("管理员登录原始按钮（暂时保留），可尝试不选身份直接输入管理员账密登录");
        btnNewButton_3.setBounds(50, 480, 420, 30);
        btnNewButton_3.setFont(new Font("等线",Font.BOLD,10));
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
        btnNewButton_4.setBounds(1000, 0, 70, 30);
        Font myfont1 = new Font("宋体 ", Font.PLAIN, 14);
        btnNewButton_4.setFont(myfont1);
        btnNewButton_4.setContentAreaFilled(false);//设置按钮透明
        //btnNewButton_4.setBorder(null);//取消边框
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
        JButton btnNewButton_5 = new JButton("忘记/修改密码");
        btnNewButton_5.setBounds(1070, 0, 160, 30);
        btnNewButton_5.setFont(myfont1);
        btnNewButton_5.setContentAreaFilled(false);//设置按钮透明
        //btnNewButton_5.setBorder(null);//取消边框
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

        jf.getContentPane().add(lblBackground); // 将组件添加到面板中
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
